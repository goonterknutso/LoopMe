package com.loopme.entity;

import com.google.maps.model.LatLng;

/**
 * A class to represent a user
 *
 * @author Gunther Knutson
 */
public class User {

    private String name;
    private String photoUrl;
    private String email;
    private LatLng homeGPS;
    private Address homeAddress;
    private Preferences preferences;

    /**
     * Constructor (empty) for a new User
     */
    public User(){
    }

    /**
     * Constructor (with parameters) for a new User
     *
     * @param name        the name
     * @param photoUrl    the photoUrl
     * @param email       the email
     * @param preferences the preferences
     */
    public User(String name, String photoUrl, String email, Preferences preferences){
        this.name = name;
        this.photoUrl = photoUrl;
        this.email = email;
        this.preferences = preferences;
    }

    /**
     * Constructor (with parameters including homeAddressId) for a new User
     *
     * @param name        the  name
     * @param photoUrl    the photoUrl
     * @param email       the email
     * @param preferences the preferences
     * @param homeAddress the home address
     */
    public User(String name, String photoUrl, String email, Preferences preferences, Address homeAddress){
        this.name = name;
        this.photoUrl = photoUrl;
        this.email = email;
        this.preferences = preferences;
        this.homeAddress = homeAddress;
    }

    /**
     * Constructor (with parameters including homeAddressId) for a new User
     *
     * @param name        the  name
     * @param photoUrl    the photoUrl
     * @param email       the email
     * @param preferences the preferences
     * @param homeGPS     the home gps
     */
    public User(String name, String photoUrl, String email, Preferences preferences, LatLng homeGPS){
        this.name = name;
        this.photoUrl = photoUrl;
        this.email = email;
        this.preferences = preferences;
        this.homeGPS = homeGPS;
    }

    /**
     * Constructor (with parameters including homeAddressId) for a new User
     *
     * @param name        the  name
     * @param photoUrl    the photoUrl
     * @param email       the email
     * @param preferences the preferences
     * @param homeAddress the home address
     * @param homeGPS     the home gps
     */
    public User(String name, String photoUrl, String email, Preferences preferences, Address homeAddress, LatLng homeGPS){
        this.name = name;
        this.photoUrl = photoUrl;
        this.email = email;
        this.preferences = preferences;
        this.homeAddress = homeAddress;
        this.homeGPS = homeGPS;
    }








}
