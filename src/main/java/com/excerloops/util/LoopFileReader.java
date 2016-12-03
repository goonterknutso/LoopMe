package com.excerloops.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


import com.excerloops.loopGenerator.Coordinate;
import com.excerloops.loopGenerator.Loop;
import com.excerloops.loopGenerator.Loops;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class LoopFileReader{

    Loops loops;
    BufferedReader reader;


    public LoopFileReader(){
        loops = new Loops();
    }

    public Loops readLoopsFromFile(){
        String json = "";
        loops = getLoopsFromJSON("files/loop_patterns.json");
        return loops;
    }


    public Loops getLoopsFromJSON(String fileLocation){

        //System.out.println(JSON);
        Loops loops = new Loops();

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readValue(reader, JsonNode
                    .class);
            //Gets each loop
            for(JsonNode node : rootNode.path("loops")){

                Loop loop = new Loop();
                ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();


                for(JsonNode c : node.path("coordinates")){
                    Coordinate coordinate = new Coordinate();
                    coordinate.setX(c.path("x").intValue());
                    coordinate.setY(c.path("y").intValue());
                    coordinates.add(coordinate);
                }

                Coordinate a = coordinates.get(0);
                Coordinate b = coordinates.get(1);
                int legLength;
                if(a.getX() != b.getX()){
                    legLength = Math.abs(a.getX() - b.getX());
                } else {
                    legLength = Math.abs(a.getY() - b.getY());
                }

                loop.setCoordinates(coordinates);

                loop.setLegLength(legLength);
                loop.setNumLegs(node.path("numLegs").intValue());
                loop.setRouteDistance(node.path("routeDistance").intValue());

                loops.addLoop(loop);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return loops;
    }


}