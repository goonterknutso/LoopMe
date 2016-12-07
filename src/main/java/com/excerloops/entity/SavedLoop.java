package com.excerloops.entity;
import java.util.ArrayList;

/**
 * SavedLoop
 * A class that represents a saved loop
 * Created by Gunther Knutson on 11/30/2016.
 */

public class SavedLoop {

    private String id;
    private String name;
    private String startAddress;
    private double startLat;
    private double startLng;
    private double inputDistance;
    private double distanceMI;
    private double distanceKM;
    private String unit;
    private String transitMode;
    private String reponse;
    private ArrayList<Double> resultsLat;
    private ArrayList<Double> resultsLng;
    private int zoom;

    /**
     * Default Constructor for SavedLoop
     * Auto sets id using SessionIdentifierGenerator
     */
    public SavedLoop(){
        this.id = SessionIdentifierGenerator.nextSessionId();
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return startAddress
     */
    public String getStartAddress() {
        return startAddress;
    }

    /**
     * @param startingAddress
     */
    public void setStartAddress(String startingAddress) {
        this.startAddress = startingAddress;
    }

    /**
     * @return startLat
     */
    public double getStartLat() {
        return startLat;
    }

    /**
     * @param startLat
     */
    public void setStartLat(double startLat) {
        this.startLat = startLat;
    }

    /**
     * @return startLng
     */
    public double getStartLng() {
        return startLng;
    }

    /**
     * @param startLng
     */
    public void setStartLng(double startLng) {
        this.startLng = startLng;
    }

    /**
     * @return inputDistance
     */
    public double getInputDistance() {
        return inputDistance;
    }

    /**
     * @param inputDistance
     */
    public void setInputDistance(double inputDistance) {
        this.inputDistance = inputDistance;
    }

    /**
     * @return distanceMI
     */
    public double getDistanceMI() {
        return distanceMI;
    }

    /**
     * @param distanceMI
     */
    public void setDistanceMI(double distanceMI) {
        this.distanceMI = distanceMI;
    }

    /**
     * @return distanceKM
     */
    public double getDistanceKM() {
        return distanceKM;
    }

    /**
     * @param distanceKM
     */
    public void setDistanceKM(double distanceKM) {
        this.distanceKM = distanceKM;
    }

    /**
     * @return unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return transitMode
     */
    public String getTransitMode() {
        return transitMode;
    }

    /**
     * @param transitMode
     */
    public void setTransitMode(String transitMode) {
        this.transitMode = transitMode;
    }

    /**
     * @return reponse
     */
    public String getReponse() {
        return reponse;
    }

    /**
     *
     * @param reponse
     */
    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    /**
     * @return resultsLat
     */
    public ArrayList<Double> getResultsLat() {
        return resultsLat;
    }

    /**
     * @param resultsLat
     */
    public void setResultsLat(ArrayList<Double> resultsLat) {
        this.resultsLat = resultsLat;
    }

    /**
     * @return resultsLng
     */
    public ArrayList<Double> getResultsLng() {
        return resultsLng;
    }

    /**
     * @param resultsLng
     */
    public void setResultsLng(ArrayList<Double> resultsLng) {
        this.resultsLng = resultsLng;
    }

    /**
     * @return zoom
     */
    public int getZoom() {
        return zoom;
    }

    /**
     * @param zoom
     */
    public void setZoom(int zoom) {
        this.zoom = zoom;
    }
}

