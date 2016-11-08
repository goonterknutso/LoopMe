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
    private String uid;
    private String role;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LatLng getHomeGPS() {
        return homeGPS;
    }

    public void setHomeGPS(LatLng homeGPS) {
        this.homeGPS = homeGPS;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }
}
