package com.loopme.persistence;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.loopme.entity.Coordinate;
import com.loopme.entity.Loop;
import com.loopme.entity.Loops;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;
import org.apache.log4j.Logger;


public class FireDBHelper{

    private String firebase_baseURL = "https://loopme-144918.firebaseio.com/";
    Firebase firebase;
    static Logger log = Logger.getLogger(FireDBHelper.class.getName());


    public FireDBHelper(){
        try{
            firebase = new Firebase(firebase_baseURL);
        } catch (FirebaseException e){
            log.debug("Error: couldn't connect to Firebase");
        }
    }



    /**
     * Takes an object and converts it into JSON
     *
     * @param o
     * @return
     */
    private String convertToJSON(Object o){
        //Convert loops to JSON string
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Convert object to JSON string
            String JSON = mapper.writeValueAsString(o);
            return JSON;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (com.fasterxml.jackson.databind.JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    public void writeLoopPatterns(Loops loops){
        //Convert loops to JSON string
        String JSON = convertToJSON(loops);
        log.debug(JSON);
        //Write JSON string to database
        writeToDatabase(JSON);
    }

    public Loops getLoopPatterns(){
        //http://tutorials.jenkov.com/java-json/jackson-jsonparser.html
        //http://wiki.fasterxml.com/JacksonTreeModel

        String JSON = readFromDatabase("loops");
        log.debug("Read from database: " + JSON);

        Loops loops = new Loops();

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readValue(JSON, JsonNode.class);

            //Gets each loop
            for(JsonNode node : rootNode){

                Loop loop = new Loop();
                ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();

                for(JsonNode c : node.path("coordinates")){
                    Coordinate coordinate = new Coordinate();
                    coordinate.setX(c.path("x").intValue());
                    coordinate.setY(c.path("y").intValue());
                    coordinates.add(coordinate);
                }

                loop.setCoordinates(coordinates);

                loop.setLegLength(node.path("legLegth").intValue());
                loop.setNumLegs(node.path("numLegs").intValue());
                loop.setRouteDistance(node.path("routeDistance").intValue());

                loops.addLoop(loop);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return loops;
    }


    private String readFromDatabase(String URL){
        FirebaseResponse response;
        try {
            response = firebase.get(URL);
            return response.getRawBody();
        } catch(FirebaseException e) {
            log.error("Error: Loops could not be read");
        } catch(UnsupportedEncodingException e){
            log.error("Error: Unsupported Encoding Exception");
        }
        return null;
    }

    private Object convertToObject(String JSON, Class c){

        //Convert loops to JSON string
        try {
            ObjectMapper mapper = new ObjectMapper();
            Object obj = mapper.readValue(JSON, c);
            return obj;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (com.fasterxml.jackson.databind.JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    //TODO Change this method to write to file

    /**
     * Writes JSON to database
     * @param JSON
     */
    private void writeToDatabase(String JSON){
        try {
            firebase.put(JSON);
        } catch(FirebaseException e) {
            log.error("Error: JSON string could not be written");
        } catch(UnsupportedEncodingException e){
            log.error("Error: Unsupported Encoding Exception");
        }
    }
}