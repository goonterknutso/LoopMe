package com.loopme.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * Class that represents a route using Hibernate
 *
 * @author Gunther Knutson
 */
public class Route {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "route_id")
    private int routeId;

    @Column(name = "name")
    private String name;

    @Column(name = "distance")
    private Double distance;

    @Column(name = "distance_unit")
    private String distanceUnit;

    @Column(name = "elevation")
    private Double elevation;

    @Column(name = "elevation_unit")
    private String elevationUnit;

    @Column(name = "address_start")
    private int addressStartId;

    @Column(name = "user_id")
    private int userId;

    /**
     * Constructor (empty) for a new Route
     */
    public Route(){
    }

    /**
     * Constructor (with parameters) for a new Route
     *
     * @param name
     * @param distance
     * @param distanceUnit
     * @param elevation
     * @param elevationUnit
     * @param addressStartId
     * @param userId
     */
    public Route(String name, Double distance, String distanceUnit, Double elevation, String elevationUnit, int addressStartId, int userId) {
        this.name = name;
        this.distance = distance;
        this.distanceUnit = distanceUnit;
        this.elevation = elevation;
        this.elevationUnit = elevationUnit;
        this.addressStartId = addressStartId;
        this.userId = userId;
    }

    /**
     * Gets the route id
     * @return the route id
     */
    public int getRouteId() {
        return routeId;
    }

    /**
     * Sets route id
     * @param routeId the route id
     */
    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    /**
     * Gets the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the route name
     * @param name the route name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the distance
     * @return the distance
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * Sets the distance
     * @param distance the distance
     */
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    /**
     * Gets the distance unit
     * @return the distance unit
     */
    public String getDistanceUnit() {
        return distanceUnit;
    }

    /**
     * Sets the distance unit
     * @param distanceUnit the distance unit
     */
    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    /**
     * Gets the elevation
     * @return the elevation
     */
    public Double getElevation() {
        return elevation;
    }

    /**
     * Sets the elevation
     * @param elevation the elevation
     */
    public void setElevation(Double elevation) {
        this.elevation = elevation;
    }

    /**
     * Gets the elevation unit
     * @return the elevation unit
     */
    public String getElevationUnit() {
        return elevationUnit;
    }

    /**
     * Sets the elevation unit
     * @param elevationUnit the elevation unit
     */
    public void setElevationUnit(String elevationUnit) {
        this.elevationUnit = elevationUnit;
    }

    /**
     * Gets the start address
     * @return the start address
     */
    public int getAddressStartId() {
        return addressStartId;
    }

    /**
     * Sets the start address
     * @param addressStartId the start address
     */
    public void setAddressStartId(int addressStartId) {
        this.addressStartId = addressStartId;
    }

    /**
     * Gets the user id
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user id
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
