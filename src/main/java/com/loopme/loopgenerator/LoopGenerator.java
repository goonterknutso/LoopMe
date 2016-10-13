package com.loopme.loopgenerator;


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

    private static final int SAME_EXIT = 50;
    private static final int FAIL_EXIT = 500000;

    private int routeDistance;

    private int xMax;
    private int xMin;
    private int xMid;

    private int yMax;
    private int yMin;
    private int yMid;

    private int legLength;
    private int numberOfLoops;
    private String[][] routeGrid;

    private int oppositeDirection;

    Loops loops;

    boolean added;
    int sameCounter;
    int failCounter;


    public LoopGenerator(int routeDistance, int legLength, int numberOfLoops){
        this.routeDistance = routeDistance;
        this.legLength = legLength;
        this.numberOfLoops = numberOfLoops;

        xMid = this.routeDistance /2;
        yMid = this.routeDistance /2;

        xMax = this.routeDistance;
        xMin = 0;
        yMax = this.routeDistance;
        yMin = 0;

        routeGrid = new String[this.routeDistance][this.routeDistance];
        loops = new Loops();

        oppositeDirection = Integer.MAX_VALUE;
        sameCounter = 0;
        failCounter = 0;
    }

    public void generateLoops(){
        boolean generateLoops = true;
        boolean generateLegs;
        int randomDirection;
        Loop loop;

        //Run until the number of loops we want is generated
        while(generateLoops){

            loop = new Loop(legLength, routeDistance);

            //Push first coordinate
            int xCurrent = xMid;
            int yCurrent = yMid;
            loop.addCoordinate(new Coordinate(xCurrent,yCurrent));

            generateLegs = true;

            //Keep looking for route until we reach max distance
            while(generateLegs){

                //Create random direction (0-3)
                randomDirection = (int) (Math.random()*4);

                //Checks the random direction, adds point if passes certain conditionals (see check direction)
                if(checkDirection(loop, randomDirection, xCurrent, yCurrent)) {
                    switch(randomDirection){
                        case UP: yCurrent += legLength; oppositeDirection=1; break;
                        case DOWN: yCurrent -= legLength; oppositeDirection=0; break;
                        case LEFT: xCurrent -= legLength; oppositeDirection=3; break;
                        case RIGHT: xCurrent += legLength; oppositeDirection=2; break;
                    }

                    //Add coordinate to loop
                    loop.addCoordinate(new Coordinate(xCurrent,yCurrent));
                }else{
                    break;
                }


                //Loop complete with correct route distance
                if(atStart(xCurrent,yCurrent) && (loop.getNumLegs()*loop.getLegLength() == routeDistance)){
                    added = loops.addLoop(loop);
                    if(added){
                        sameCounter = 0;
                        failCounter = 0;
                    }else{
                        sameCounter++;
                    }
                    generateLegs = false;
                }

                //Loop beyond our route distance, start over
                if(loop.getNumLegs()*loop.getLegLength() > routeDistance){
                    generateLegs = false;
                }
            }

            //Check to see if we have generated the number of loops we wanted
            if(loops.getLoops().size() == numberOfLoops){
                generateLoops = false;
            }

            if(sameCounter == SAME_EXIT|| failCounter == FAIL_EXIT){
                System.out.println("Exited with Failure Number");
                generateLoops = false;
            }

            failCounter++;

        }
    }



    //Private Method for Loop Generating

    /**
     * This method is used within the LoopGenerator class to check directions generated randomly.
     *
     * @param randomDirection
     * @param xCurrent
     * @param yCurrent
     * @return
     */
    private Boolean checkDirection(Loop loop, int randomDirection, int xCurrent, int yCurrent){

        if(randomDirection == oppositeDirection){
            return false;
        }

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
            if ((!atStart(x,y) && loop.getCoordinate(c).getX() == x && loop.getCoordinate(c).getY() == y)) {
                return true;
            }
        }
        return false;
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



    //Getters and Setters

    public void setLoops(Loops loops){
        this.loops = loops;
        this.numberOfLoops += this.loops.getLoops().size();
    }

    public Loops getLoops(){
        return loops;
    }




    //Output Methods for Terminal

    public void writeLoopsToTerminal(){

        //Loop Info
        System.out.println("------------LOOP INFO-------------");
        System.out.println();
        System.out.println("Route Distance:  " + routeDistance);
        System.out.println("Leg Length:      " + legLength);
        System.out.println("Number of Loops: " + loops.getLoops().size());
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println();

        //Print all coordinates first
        System.out.println("::Coordinates::");
        System.out.println();
        for(Loop l: loops.getLoops()){
            for(Coordinate c : l.getCoordinates()){
                System.out.print("(");
                if(c.getX() < 10){
                    System.out.print(" "+c.getX());
                }else{
                    System.out.print(c.getX());
                }
                System.out.print(",");
                if(c.getY() < 10){
                    System.out.print(c.getY()+" ");
                }else{
                    System.out.print(c.getY());
                }
                System.out.print(") ");
            }
            System.out.println();
        }
        System.out.println();

        /*
        System.out.println("::Grid w/ Coordinates::");
        System.out.println();
        //For each loop
        for(int l = 0; l < loops.getLoops().size(); l++){
            writeLoopToTerminal(loops.getLoop(l));
        }*/
    }

    private void writeLoopToTerminal(Loop loop){
        setUpRouteGridForTerminal();

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

    private void setUpRouteGridForTerminal(){
        for(int y = yMin; y < yMax; y++){
            for(int x = xMin; x < xMax; x++){
                routeGrid[x][y] = ".  ";
            }
        }
    }


}
