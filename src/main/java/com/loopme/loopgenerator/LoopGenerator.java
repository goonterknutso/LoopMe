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
    private int X_MAX;
    private int X_MIN;
    private int Y_MAX;
    private int Y_MIN;

    private int legLength;
    private int numberOfLoops;
    private File file;
    private int[][] routeGrid;

    ArrayList<ArrayList> loops;
    ArrayList<Coordinate> loop;

    public LoopGenerator(int routeDistance, int legLength, int numberOfLoops, String fileLocation){
        this.routeDistance = routeDistance;
        this.legLength = legLength;
        this.numberOfLoops = numberOfLoops;
        this.file = new File(fileLocation);

        X_MAX = (int) routeDistance/2;
        X_MIN = (int) -(routeDistance/2);
        Y_MAX = (int) routeDistance/2;
        Y_MIN = (int) -(routeDistance/2);

        routeGrid = new int[routeDistance][routeDistance];
        loops = new ArrayList<ArrayList>();

    }

    public void generateLoops(){

        boolean moreLoops = true;
        boolean moreLegs = true;
        int randomDirection;

        int loopsGenerated = 0;


        //Run until the number of loops we want is generated
        while(moreLoops){

            loop = new ArrayList<Coordinate>();

            //Push first coordinate
            int xCurrent = 0;
            int yCurrent = 0;
            loop.add(new Coordinate(xCurrent,yCurrent));

            moreLegs = true;

            //Keep looking for route until we reach max distance
            while(moreLegs){

                randomDirection = (int) Math.random()*4;

                //GO UP
                if(randomDirection == 0){
                    if((yCurrent += legLength) <= Y_MAX){ //Test for out of bounds
                        break;
                    }else{ //No out of bounds error
                        yCurrent += legLength;
                        loop.add(new Coordinate(xCurrent,yCurrent));

                    }

                //GO DOWN
                }else if(randomDirection == 1){
                    if((yCurrent -= legLength) >= Y_MIN){ //Test for out of bounds
                        break; //Restart loop, try new random direction
                    }else{ //No out of bounds error
                        yCurrent -= legLength;
                        loop.add(new Coordinate(xCurrent,yCurrent));
                    }

                //GO LEFT
                }else if(randomDirection == 2){ //test for out of bounds
                    if((xCurrent -= legLength) >= X_MIN){
                        break; //Restart loop, try new random direction
                    }else{ //No out of bounds error
                        xCurrent -= legLength;
                        loop.add(new Coordinate(xCurrent,yCurrent));
                    }

                //GO RIGHT
                }else if(randomDirection == 3){
                    if((xCurrent += legLength) <= X_MAX){ //Test for out of bounds
                        break; //Restart loop, try new random direction
                    }else{ //No out of bounds error
                        xCurrent += legLength;
                        loop.add(new Coordinate(xCurrent,yCurrent));
                    }

                }

                //Check to see if were back to the starting point (we have a loop)
                if((xCurrent == 0 && yCurrent == 0) && ((loop.size() - 1) * legLength == routeDistance)){
                    loops.add(loop);
                    moreLegs = false;
                }

                //Check to see if we have reached max distance for current route
                if((loop.size() - 1) * legLength > routeDistance){
                    moreLegs = false;
                }


            }

            //Check to see if we have generated the number of loops we wanted
            if(loops.size() == numberOfLoops){
                moreLoops = false;
            }

        } //end while(moreLoops)

        writeLoopsToFile();

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
            routeGrid[loop.get(c).getX()][loop.get(c).getY()] = c;
        }

        //Print grid
        for(int y = Y_MAX; y >= Y_MIN; y--){
            for(int x = X_MIN; x <= X_MAX; x++){
                System.out.print(routeGrid[x][y]);
            }
            System.out.println();
        }
    }

    private void setUpRouteGrid(){
        for(int y = Y_MAX; y >= Y_MIN; y--){
            for(int x = X_MIN; x <= X_MAX; x++){
                routeGrid[x][y] = 0;
            }
        }
    }


}
