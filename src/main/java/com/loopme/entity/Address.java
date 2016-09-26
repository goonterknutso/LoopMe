package com.loopme.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * A class to represent an Address using Hibernate
 *
 * @author Gunther Knutson
 */
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "address_id")
    private int addressId;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    /**
     * Constructor (empty) for a new Address
     */
    public Address(){
    }

    /**
     * Constructor (with parameters) for a new Address
     *
     * @param street    the street
     * @param city      the city
     * @param state     the state
     * @param zip       the zip code
     */
    public Address(String street, String city, String state, String zip){
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    /**
     * Gets the address id
     * @return the address id
     */
    public int getAddressId() {
        return addressId;
    }

    /**
     * Sets the address id
     * @param addressId the address id
     */
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    /**
     * Gets the street
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street
     * @param street the street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the city
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the zip code
     * @return the zip code
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the zip code
     * @param zip the zip code
     */
    public void setZip(String zip) {
        this.zip = zip;
    }
}
