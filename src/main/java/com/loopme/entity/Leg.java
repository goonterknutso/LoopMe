package com.loopme.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * A class to represent a Leg (of a route) using Hibernate
 *
 * @author Gunther Knutson
 */
@Entity
@Table(name = "legs")
public class Leg {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "leg_id")
    private int legId;

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

    @Column(name = "address_end")
    private int addressEndId;

    @Column(name = "route_id")
    private int routeId;

    /**
     * Constructor (empty) for a new Leg.
     */
    public Leg(){
    }

    /**
     * Constructor (with parameters) for a new Leg.
     * @param distance          the distance
     * @param distance_unit     the distance unit
     * @param elevation         the elevation
     * @param elevation_unit    the elevation unit
     * @param addressStartId    the start address id
     * @param addressEndId      the end address id
     * @param routeId           the route id
     */
    public Leg(Double distance, String distance_unit, Double elevation, String elevation_unit, int addressStartId, int addressEndId, int routeId) {
        this.distance = distance;
        this.distanceUnit = distance_unit;
        this.elevation = elevation;
        this.elevationUnit = elevation_unit;
        this.addressStartId = addressStartId;
        this.addressEndId = addressEndId;
        this.routeId = routeId;
    }

    /**
     * Gets the leg id
     * @return the leg id
     */
    public int getLegId() {
        return legId;
    }

    /**
     * Sets the leg id
     * @param legId the leg id
     */
    public void setLegId(int legId) {
        this.legId = legId;
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
     * Gets the start address id
     * @return the start address id
     */
    public int getAddressStartId() {
        return addressStartId;
    }

    /**
     * Sets the start address id
     * @param addressStartId the start address id
     */
    public void setAddressStartId(int addressStartId) {
        this.addressStartId = addressStartId;
    }

    /**
     * Gets the end address id
     * @return the end address id
     */
    public int getAddressEndId() {
        return addressEndId;
    }

    /**
     * Sets the end address id
     * @param addressEndId the end address id
     */
    public void setAddressEndId(int addressEndId) {
        this.addressEndId = addressEndId;
    }

    /**
     * Gets the route id
     * @return the route id
     */
    public int getRouteId() {
        return routeId;
    }

    /**
     * Sets the route id
     * @param routeId the route id
     */
    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }
}
