package com.loopme.loopgenerator;


import java.io.File;
import java.util.ArrayList;

/**
 * LoopGenerator class is used to randomly generate loops.
 *
 * Created by gunther on 9/16/16.
 */
public class LoopGenerator {

    private final int ROUTE_DISTANCE = 40;
    private int X_MID;
    private int Y_MID;
    private int X_MAX;
    private int X_MIN;
    private int Y_MAX;
    private int Y_MIN;

    private int legLength;
    private int numberOfLoops;
    private File file;
    private String[][] routeGrid;

    ArrayList<ArrayList> loops;
    ArrayList<Coordinate> loop;

    public LoopGenerator(int legLength, int numberOfLoops, String fileLocation){
        this.legLength = legLength;
        this.numberOfLoops = numberOfLoops;
        //this.file = new File(fileLocation);

        X_MID = ROUTE_DISTANCE/2;
        Y_MID = ROUTE_DISTANCE/2;

        X_MAX = ROUTE_DISTANCE;
        X_MIN = 0;
        Y_MAX = ROUTE_DISTANCE;
        Y_MIN = 0;

        routeGrid = new String[ROUTE_DISTANCE][ROUTE_DISTANCE];
        loops = new ArrayList<ArrayList>();

    }

    public void generateLoops(){
        System.out.println("Generating loops....");

        boolean moreLoops = true;
        boolean moreLegs = true;
        int randomDirection;


        //Run until the number of loops we want is generated
        while(moreLoops){
            //System.out.println("new loop");

            loop = new ArrayList<Coordinate>();

            //Push first coordinate
            int xCurrent = X_MID;
            int yCurrent = Y_MID;
            loop.add(new Coordinate(xCurrent,yCurrent));

            moreLegs = true;
            int previousDirection = 99;

            //Keep looking for route until we reach max distance
            while(moreLegs){
                //System.out.println("new leg....");

                randomDirection = (int) (Math.random()*4);

                //GO UP
                if(randomDirection == 0){
                    if(((yCurrent + legLength) >= Y_MAX) || (randomDirection == previousDirection)){ //Test for out of bounds
                        break;
                    }else{ //No out of bounds error
                        yCurrent += legLength;
                        loop.add(new Coordinate(xCurrent,yCurrent));
                        previousDirection = 1;
                    }

                //GO DOWN
                }else if(randomDirection == 1){
                    if(((yCurrent - legLength) <= Y_MIN) || (randomDirection == previousDirection)){ //Test for out of bounds
                        break; //Restart loop, try new random direction
                    }else{ //No out of bounds error
                        yCurrent -= legLength;
                        loop.add(new Coordinate(xCurrent,yCurrent));
                        previousDirection = 0;
                    }

                //GO LEFT
                }else if(randomDirection == 2){ //test for out of bounds
                    if(((xCurrent - legLength) <= X_MIN) || (randomDirection == previousDirection)){
                        break; //Restart loop, try new random direction
                    }else{ //No out of bounds error
                        xCurrent -= legLength;
                        loop.add(new Coordinate(xCurrent,yCurrent));
                        previousDirection = 3;
                    }

                //GO RIGHT
                }else if(randomDirection == 3){
                    if(((xCurrent + legLength) >= X_MAX)|| (randomDirection == previousDirection)){ //Test for out of bounds
                        break; //Restart loop, try new random direction
                    }else{ //No out of bounds error
                        xCurrent += legLength;
                        loop.add(new Coordinate(xCurrent,yCurrent));
                        previousDirection = 2;
                    }

                }

                //Check to see if were back to the starting point (we have a loop)
                if((xCurrent == X_MID && yCurrent == Y_MID) && ((loop.size() - 1) * legLength == ROUTE_DISTANCE)){
                    System.out.println("Printing loop:");
                    System.out.println();
                    writeLoopToFile(loop);
                    loops.add(loop);
                    moreLegs = false;
                }

                //Check to see if we have reached max distance for current route
                if((loop.size() - 1) * legLength > ROUTE_DISTANCE){
                    moreLegs = false;
                }


            }

            //Check to see if we have generated the number of loops we wanted
            if(loops.size() == numberOfLoops){
                moreLoops = false;
            }

        } //end while(moreLoops)

        //writeLoopsToFile();

    } //end method



    private void writeLoopsToFile(){
        //For each loop
        for(int l = 0; l < loops.size(); l++){
            writeLoopToFile(loops.get(l));
        }
    }

    private void writeLoopToFile(ArrayList<Coordinate> loop){
        setUpRouteGrid();

        //Print Coordinates
        for(int c = 0; c < loop.size(); c++){
            System.out.print(loop.get(c).toString());
            routeGrid[loop.get(c).getX()][loop.get(c).getY()] = Integer.toString(c)+" ";
        }

        System.out.println();
        System.out.println();

        //Print grid
        for(int y = Y_MIN; y < Y_MAX; y++){
            for(int x = X_MIN; x < X_MAX; x++){
                System.out.print(routeGrid[x][y]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    private void setUpRouteGrid(){
        for(int y = Y_MIN; y < Y_MAX; y++){
            for(int x = X_MIN; x < X_MAX; x++){
                routeGrid[x][y] = ". ";
            }
        }
    }


}
