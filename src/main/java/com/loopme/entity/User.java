package com.loopme.entity;

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
    private String homeGPS;
    private String homeAddress;
    private Preferences preferences;
    private int numSavedLoops;

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
        this();
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
    public User(String name, String photoUrl, String email, Preferences preferences, String homeAddress){
        this();
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
     * @param homeAddress the home address
     * @param homeGPS     the home gps
     */
    public User(String name, String photoUrl, String email, Preferences preferences, String homeAddress, String homeGPS){
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

    public String getHomeGPS() {
        return homeGPS;
    }

    public void setHomeGPS(String homeGPS) {
        this.homeGPS = homeGPS;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    public int getNumSavedLoops(){
        return numSavedLoops;
    }

    public void setNumSavedLoops(int numSavedLoops){
        this.numSavedLoops = numSavedLoops;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", email='" + email + '\'' +
                ", uid='" + uid + '\'' +
                ", role='" + role + '\'' +
                ", homeGPS=" + homeGPS +
                ", homeAddress=" + homeAddress +
                ", preferences=" + preferences +
                '}';
    }
}
