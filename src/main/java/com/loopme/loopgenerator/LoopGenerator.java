package com.loopme.loopgenerator;


import java.io.File;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * LoopGenerator class is used to randomly generate loops.
 *
 * Created by gunther on 9/16/16.
 */
public class LoopGenerator {

    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;

    private int routeDistance;

    private int xMax;
    private int xMin;
    private int xMid;

    private int yMax;
    private int yMin;
    private int yMid;

    private int legLength;
    private int numberOfLoops;
    private File file;
    private String[][] routeGrid;

    ArrayList<Loop> loops;
    Loop loop;

    public LoopGenerator(int routeDistance, int legLength, int numberOfLoops, String fileLocation){
        this.routeDistance = routeDistance;
        this.legLength = legLength;
        this.numberOfLoops = numberOfLoops;
        //this.file = new File(fileLocation);

        xMid = this.routeDistance /2;
        yMid = this.routeDistance /2;

        xMax = this.routeDistance;
        xMin = 0;
        yMax = this.routeDistance;
        yMin = 0;

        routeGrid = new String[this.routeDistance][this.routeDistance];
        loops = new ArrayList<Loop>();

    }

    public void generateLoops(){
        System.out.println("Generating loops....");

        boolean generateLoops = true;
        boolean generateLegs;
        int randomDirection;

        //Run until the number of loops we want is generated
        while(generateLoops){
            //System.out.println("new loop");

            loop = new Loop();

            //Push first coordinate
            int xCurrent = xMid;
            int yCurrent = yMid;
            //loop.addCoordinate(new Coordinate(xCurrent,yCurrent));

            generateLegs = true;

            //Keep looking for route until we reach max distance
            while(generateLegs){

                //Create random direction (0-3)
                randomDirection = (int) (Math.random()*4);

                //Checks the random direction, adds point if passes certain conditionals (see check direction)
                if(checkDirection(randomDirection, xCurrent, yCurrent)) {
                    switch(randomDirection){
                        case UP: yCurrent += legLength; break;
                        case DOWN: yCurrent -= legLength; break;
                        case LEFT: xCurrent -= legLength; break;
                        case RIGHT: xCurrent += legLength; break;
                    }

                    //Add coordinate to loop
                    loop.addCoordinate(new Coordinate(xCurrent,yCurrent));
                }else{
                    break;
                }

                //Loop complete with correct route distance
                if(atStart(xCurrent,yCurrent) && (loop.getDistance(legLength) == routeDistance)){
                    loops.add(loop);
                    generateLegs = false;
                }

                //Loop beyond our route distance, start over
                if(loop.getDistance(legLength) > routeDistance){
                    generateLegs = false;
                }
            }

            //Check to see if we have generated the number of loops we wanted
            if(loops.size() == numberOfLoops){
                generateLoops = false;
            }

        }

        writeLoopsToTerminal();
    }

    /**
     * This method checks a pair of x,y coordinate values to see if they are
     * at the start of the loop
     *
     * @param xCurrent the x value to check
     * @param yCurrent the y value to check
     * @return
     */
    private Boolean atStart(int xCurrent, int yCurrent){
        if(xCurrent == xMid && yCurrent == yMid){
            return true;
        }
        return false;
    }

    /**
     * This method is used within the LoopGenerator class to check directions generated randomly.
     *
     * @param randomDirection
     * @param xCurrent
     * @param yCurrent
     * @return
     */
    private Boolean checkDirection(int randomDirection, int xCurrent, int yCurrent){
        /*
        if (randomDirection == oppositeDirection) {
            return false;
        }*/


        switch(randomDirection){
            case UP: if((yCurrent + legLength) >= yMax){ return false; }
                    else if(isACoordinate(loop, xCurrent, yCurrent + legLength)) { return false; }
                    break;
            case DOWN: if((yCurrent - legLength) <= yMin){ return false;}
                    else if(isACoordinate(loop, xCurrent, yCurrent - legLength)) { return false; }
                    break;
            case LEFT: if((xCurrent - legLength) <= xMin){ return false; }
                    else if(isACoordinate(loop, xCurrent - legLength, yCurrent)) { return false; }
                    break;
            case RIGHT: if((xCurrent + legLength) >= xMax){ return false; }
                    else if(isACoordinate(loop, xCurrent + legLength, yCurrent)) { return false; }
                    break;
        }

        return true;
    }

    /**
     * This method is used within the LoopGenerator class as a way of testing if an x,y coordinate
     * pair is already part of the loop
     *
     * @param loop The loop we want to test coordinates from
     * @param x The x value of the coordinate pair to test for
     * @param y The y value of the coordinate pair to test for
     * @return
     */
    private Boolean isACoordinate(Loop loop, int x, int y){
        for(int c = 0; c < loop.getNumLegs(); c++){
            if(loop.getCoordinate(c).getX() == x && loop.getCoordinate(c).getY() == y){
                return true;
            }
        }
        return false;
    }

    /*
    private String generateJSON(){
        JSONObject obj = new JSONObject();

        JSONObject jsonCoordinates;
        JSONArray jsonCoordinate;

        JSONObject jsonLoops;
        JSONArray jsonLoop;

        jsonLoops = new JSONObject();
        jsonLoop = new JSONArray();

        for(int loop = 0; loop < loops.size(); loop++){

            jsonCoordinates = new JSONObject();

            for(int coordinate = 0; coordinate < loops.get(loop).getNumLegs(); coordinate++){
                jsonCoordinate = new JSONArray();
                jsonCoordinate.add("x:"+loops.get(loop).getCoordinate(coordinate).getX());
                jsonCoordinate.add("y:"+loops.get(loop).getCoordinate(coordinate).getY());
                jsonCoordinates.put("coordinates", jsonCoordinates);
            }

            jsonLoop.add("coordinates:", jsonCoordinates);

        }
        jsonLoops.put("loops", jsonLoop);
        return null;
    }*/


    private void writeLoopsToTerminal(){
        //For each loop
        for(int l = 0; l < loops.size(); l++){
            writeLoopToTerminal(loops.get(l));
        }
    }

    private void writeLoopToTerminal(Loop loop){
        setUpRouteGrid();

        //Print Coordinates
        for(int c = 0; c < loop.getNumLegs(); c++){
            System.out.print(loop.getCoordinate(c).toString());
            if(c < 10) {
                routeGrid[loop.getCoordinate(c).getX()][loop.getCoordinate(c).getY()] = Integer.toString(c) + "  ";
            }else{
                routeGrid[loop.getCoordinate(c).getX()][loop.getCoordinate(c).getY()] = Integer.toString(c) + " ";
            }
        }

        System.out.println();
        System.out.println();

        //Print grid
        for(int y = yMax -1; y > yMin; y--){
            for(int x = xMin; x < xMax; x++){
                System.out.print(routeGrid[x][y]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    private void setUpRouteGrid(){
        for(int y = yMin; y < yMax; y++){
            for(int x = xMin; x < xMax; x++){
                routeGrid[x][y] = ".  ";
            }
        }
    }



    //Getters and Setters

    public int getRouteDistance() {
        return routeDistance;
    }

    public void setRouteDistance(int routeDistance) {
        this.routeDistance = routeDistance;
    }

    public int getLegLength() {
        return legLength;
    }

    public void setLegLength(int legLength) {
        this.legLength = legLength;
    }

    public int getNumberOfLoops() {
        return numberOfLoops;
    }

    public void setNumberOfLoops(int numberOfLoops) {
        this.numberOfLoops = numberOfLoops;
    }

}
