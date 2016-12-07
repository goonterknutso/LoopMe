package com.excerloops.entity;

import java.util.ArrayList;

/**
 * User
 * A class to represent a user
 * @author Gunther Knutson on 11/30/2016.
 */
public class User {

    private String name;
    private String photoUrl;
    private String email;
    private String uid;
    private String role;
    private Preferences preferences;
    private ArrayList<SavedLoop> savedLoops;

    /**
     * Default Constructor for User
     */
    public User(){
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
     * @return photoUrl
     */
    public String getPhotoUrl() {
        return photoUrl;
    }

    /**
     * @param photoUrl
     */
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return preferences
     */
    public Preferences getPreferences() {
        return preferences;
    }

    /**
     * @param preferences
     */
    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

}
