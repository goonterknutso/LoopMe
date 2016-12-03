package com.excerloops.entity;

import com.excerloops.interfaces.ExcerloopsInterface;
import com.google.maps.model.LatLng;

import java.awt.*;

/**
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

    public Preferences(){
        defaultHomeEnabled = false;
        defaultUnitEnabled = false;
        defaultHome = "";
        defaultUnit = MI;
        lineColor = BLUE;
        transitMode = RUN;
        numberOfMarkers = 5;
    }

    public Boolean getDefaultHomeEnabled() {
        return defaultHomeEnabled;
    }

    public void setDefaultHomeEnabled(Boolean defaultHomeEnabled) {
        this.defaultHomeEnabled = defaultHomeEnabled;
    }

    public Boolean getDefaultUnitEnabled() {
        return defaultUnitEnabled;
    }

    public void setDefaultUnitEnabled(Boolean defaultUnitEnabled) {
        this.defaultUnitEnabled = defaultUnitEnabled;
    }

    public String getDefaultHome() {
        return defaultHome;
    }

    public void setDefaultHome(String defaultHome) {
        this.defaultHome = defaultHome;
    }

    public LatLng getDefaultHomeGPS() {
        return defaultHomeGPS;
    }

    public void setDefaultHomeGPS(LatLng defaultHomeGPS) {
        this.defaultHomeGPS = defaultHomeGPS;
    }

    public String getDefaultUnit() {
        return defaultUnit;
    }

    public void setDefaultUnit(String defaultUnit) {
        this.defaultUnit = defaultUnit;
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
    }

    public String getTransitMode() {
        return transitMode;
    }

    public void setTransitMode(String transitMode) {
        this.transitMode = transitMode;
    }

    public int getNumberOfMarkers() {
        return numberOfMarkers;
    }

    public void setNumberOfMarkers(int numberOfMarkers) {
        this.numberOfMarkers = numberOfMarkers;
    }

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
