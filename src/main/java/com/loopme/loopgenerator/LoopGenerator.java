package com.loopme.loopgenerator;


import java.io.File;
import java.util.ArrayList;

/**
 * LoopGenerator class is used to randomly generate loops.
 *
 * Created by gunther on 9/16/16.
 */
public class LoopGenerator {

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
        loops = new ArrayList<Loop>;

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
            //loop.add(new Coordinate(xCurrent,yCurrent));

            generateLegs = true;
            int oppositeDirection = 99;

            //Keep looking for route until we reach max distance
            while(generateLegs){
                //System.out.println("new leg....");

                randomDirection = (int) (Math.random()*4);

                //GO UP
                if(randomDirection == 0){
                    if((yCurrent + legLength) >= yMax){ //Test for out of bounds
                        break;
                    }else if(randomDirection == oppositeDirection){ //Test for double back
                        break;
                    }else if(isACoordinate(loop, xCurrent, yCurrent + legLength)) { //Test for already a point
                        break;
                    }else{ //No out of bounds error
                        //System.out.println("UP");

                        yCurrent += legLength;
                        loop.addCoordinate(new Coordinate(xCurrent,yCurrent));
                        oppositeDirection = 1;
                    }

                //GO DOWN
                }else if(randomDirection == 1){
                    if((yCurrent - legLength) <= yMin){ //Test for out of bounds
                        break;
                    }else if(randomDirection == oppositeDirection){ //Test for double back
                        break;
                    }else if(isACoordinate(loop, xCurrent, yCurrent - legLength)) { //Test for already a point
                        break;
                    }else{ //No out of bounds error
                        //System.out.println("DOWN");

                        yCurrent -= legLength;
                        loop.add(new Coordinate(xCurrent,yCurrent));
                        oppositeDirection = 0;
                    }

                //GO LEFT
                }else if(randomDirection == 2){
                    if((xCurrent - legLength) <= xMin){ //Test for out of bonds
                        break;
                    }else if(randomDirection == oppositeDirection){ //Test for double back
                        break;
                    }else if(isACoordinate(loop, xCurrent - legLength, yCurrent)) { //Test for already a point
                        break;
                    }else{ //No out of bounds error
                        //System.out.println("LEFT");

                        xCurrent -= legLength;
                        loop.addCoordinate(new Coordinate(xCurrent,yCurrent));
                        oppositeDirection = 3;
                    }

                //GO RIGHT
                }else if(randomDirection == 3){
                    if((xCurrent + legLength) >= xMax){ //Test for out of bounds
                        break;
                    }else if(randomDirection == oppositeDirection){ //Test for double back
                        break;
                    }else if(isACoordinate(loop, xCurrent + legLength, yCurrent)) { //Test for already a point
                        break;
                    }else{ //No out of bounds error
                        //System.out.println("RIGHT");
                        xCurrent += legLength;
                        loop.addCoordinate(new Coordinate(xCurrent,yCurrent));
                        oppositeDirection = 2;
                    }

                }

                //Check to see if were back to the starting point (we have a loop)
                if((xCurrent == xMid && yCurrent == yMid) && ((loop.size()) * legLength == routeDistance)){
                    //System.out.println("Printing loop:");
                    //writeLoopToFile(loop);
                    loops.add(loop);
                    generateLegs = false;
                }

                //Check to see if we have reached max distance for current route
                if(loop.getDistance(legLength) > routeDistance){
                    generateLegs = false;
                }


            }

            //Check to see if we have generated the number of loops we wanted
            if(loops.size() == numberOfLoops){
                generateLoops = false;
            }

        } //end while(moreLoops)

        writeLoopsToFile();

    } //end method


    private Boolean isACoordinate(Loop loop, int x, int y){
        for(int c = 0; c < loop.getNumLegs(); c++){
            if(loop.getCoordinate(c).getX() == x && loop.getCoordinate(c).getY() == y){
                return true;
            }
        }
        return false;
    }

    private void writeLoopsToFile(){
        //For each loop
        for(int l = 0; l < loops.size(); l++){
            writeLoopToFile(loops.get(l));
        }
    }

    private void writeLoopToFile(Loop loop){
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


}
