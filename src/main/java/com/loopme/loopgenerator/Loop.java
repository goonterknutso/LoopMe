package com.loopme.loopgenerator;

import java.util.ArrayList;

/**
 * Created by gunther on 10/3/16.
 */
public class Loop {

    private ArrayList<Coordinate> coordinates;
    private int legLength;

    /**
     * Constructor (empty)
     */
    public Loop(){
        coordinates = new ArrayList<Coordinate>();
    }

    /**
     * Constructor (with parameters)
     *
     * @param legLength the leg length for the loop
     */
    public Loop(int legLength){
        super();
        this.legLength = legLength;
    }

    public void addCoordinate(Coordinate coordinate){
        coordinates.add(coordinate);
    }

    public Coordinate getCoordinate(int position){
        return coordinates.get(position);
    }

    public int getNumLegs(){
        return coordinates.size()-1;
    }

    public int getDistance(int legLength){
        return (legLength * getNumLegs());
    }


    //Getters and Setters

    /**
     * Gets the coordinates from the loop
     * @return the coordinates from the loop
     */
    public ArrayList<Coordinate> getCoordinates(){
        return coordinates;
    }

    /**
     * Sets the coordinates for the loop
     * @param coordinates the coordinates for the loop
     */
    public void setCoordinates(ArrayList<Coordinate> coordinates){
        this.coordinates = coordinates;
    }

    /**
     * Gets the leg length for the loop
     * @return the leg length for the loop
     */
    public int getLegLegth(){
        return legLength;
    }

    /**
     * Sets the leg length for the loop
     * @param legLength the leg length for the loop
     */
    public void setLegLength(int legLength){
        this.legLength = legLength;
    }

}
