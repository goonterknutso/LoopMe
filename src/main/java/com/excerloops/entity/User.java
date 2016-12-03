package com.excerloops.entity;

import java.util.ArrayList;

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
    private Preferences preferences;
    private ArrayList<SavedLoop> savedLoops;

    /**
     * Constructor (empty) for a new User
     */
    public User(){
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

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    public ArrayList<SavedLoop> getSavedLoops(){
        return savedLoops;
    }

    public void setSavedLoops(ArrayList<SavedLoop> savedLoops){
        this.savedLoops = savedLoops;
    }

}
