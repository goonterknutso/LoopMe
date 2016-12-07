package com.excerloops.entity;

import com.excerloops.interfaces.ExcerloopsInterface;
import com.google.maps.model.LatLng;

/**
 * Preferences
 * A class that stores information about a Users Preferences
 * Created by Gunther Knutson on 11/22/2016.
 */
public class Preferences implements ExcerloopsInterface{

    private Boolean defaultHomeEnabled;
    private Boolean defaultUnitEnabled;
    private String defaultHome;
    private LatLng defaultHomeGPS;
    private String defaultUnit;
    private int lineColor;
    private String transitMode;
    private int numberOfMarkers;

    /**
     * Default Constructor for Preferences
     */
    public Preferences(){
        defaultHomeEnabled = false;
        defaultUnitEnabled = false;
        defaultHome = "";
        defaultUnit = MI;
        lineColor = BLUE;
        transitMode = RUN;
        numberOfMarkers = 5;
    }

    /**
     * @return defaultHomeEnabled
     */
    public Boolean getDefaultHomeEnabled() {
        return defaultHomeEnabled;
    }

    /**
     * @param defaultHomeEnabled
     */
    public void setDefaultHomeEnabled(Boolean defaultHomeEnabled) {
        this.defaultHomeEnabled = defaultHomeEnabled;
    }

    /**
     * @return defaultUnitEnabled
     */
    public Boolean getDefaultUnitEnabled() {
        return defaultUnitEnabled;
    }

    /**
     * @param defaultUnitEnabled
     */
    public void setDefaultUnitEnabled(Boolean defaultUnitEnabled) {
        this.defaultUnitEnabled = defaultUnitEnabled;
    }

    /**
     * @return defaultHome
     */
    public String getDefaultHome() {
        return defaultHome;
    }

    /**
     * @param defaultHome
     */
    public void setDefaultHome(String defaultHome) {
        this.defaultHome = defaultHome;
    }

    /**
     * @return defaultHomeGPS
     */
    public LatLng getDefaultHomeGPS() {
        return defaultHomeGPS;
    }

    /**
     * @param defaultHomeGPS
     */
    public void setDefaultHomeGPS(LatLng defaultHomeGPS) {
        this.defaultHomeGPS = defaultHomeGPS;
    }

    /**
     * @return defaultUnit
     */
    public String getDefaultUnit() {
        return defaultUnit;
    }

    /**
     * @param defaultUnit
     */
    public void setDefaultUnit(String defaultUnit) {
        this.defaultUnit = defaultUnit;
    }

    /**
     * @return lineColor
     */
    public int getLineColor() {
        return lineColor;
    }

    /**
     * @param lineColor
     */
    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
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
     * @return
     */
    public int getNumberOfMarkers() {
        return numberOfMarkers;
    }

    /**
     * @param numberOfMarkers
     */
    public void setNumberOfMarkers(int numberOfMarkers) {
        this.numberOfMarkers = numberOfMarkers;
    }

    /**
     * Returns the object as a String
     * @return
     */
    @Override
    public String toString() {
        return "Preferences{" +
                "defaultHomeEnabled=" + defaultHomeEnabled +
                ", defaultUnitEnabled=" + defaultUnitEnabled +
                ", defaultHome='" + defaultHome + '\'' +
                ", defaultUnit='" + defaultUnit + '\'' +
                ", lineColor=" + lineColor +
                ", transitMode='" + transitMode + '\'' +
                ", numberOfMarkers=" + numberOfMarkers +
                '}';
    }
}
