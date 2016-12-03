package com.excerloops.entity;

import java.security.SecureRandom;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by gunth on 11/30/2016.
 */

public class SavedLoop {

    String id;
    String name;

    String startingAddress;
    double startLat;
    double startLng;
    double inputDistance;
    double distance;
    String unit;

    String reponse;
    ArrayList<Double> resultsLat;
    ArrayList<Double> resultsLng;

    int zoom;

    public SavedLoop(){
        this.id = SessionIdentifierGenerator.nextSessionId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartingAddress() {
        return startingAddress;
    }

    public void setStartingAddress(String startingAddress) {
        this.startingAddress = startingAddress;
    }

    public double getStartLat() {
        return startLat;
    }

    public void setStartLat(double startLat) {
        this.startLat = startLat;
    }

    public double getStartLng() {
        return startLng;
    }

    public void setStartLng(double startLng) {
        this.startLng = startLng;
    }

    public double getInputDistance() {
        return inputDistance;
    }

    public void setInputDistance(double inputDistance) {
        this.inputDistance = inputDistance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public ArrayList<Double> getResultsLat() {
        return resultsLat;
    }

    public void setResultsLat(ArrayList<Double> resultsLat) {
        this.resultsLat = resultsLat;
    }

    public ArrayList<Double> getResultsLng() {
        return resultsLng;
    }

    public void setResultsLng(ArrayList<Double> resultsLng) {
        this.resultsLng = resultsLng;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }
}

final class SessionIdentifierGenerator {
    private static SecureRandom random = new SecureRandom();

    public static String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }
}
