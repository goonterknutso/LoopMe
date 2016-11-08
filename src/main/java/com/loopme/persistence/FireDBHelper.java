package com.loopme.persistence;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.loopme.entity.User;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;
import org.apache.log4j.Logger;


public class FireDBHelper{

    private String firebase_baseURL = "https://excerloops.firebaseio.com/";
    Firebase firebase;
    static Logger log = Logger.getLogger(FireDBHelper.class.getName());


    public FireDBHelper(){
        try{
            firebase = new Firebase(firebase_baseURL);
        } catch (FirebaseException e){
            log.debug("Error: couldn't connect to Firebase");
        }
    }

    public void saveUsers(List<User> users){
        //Convert loops to JSON string
        String JSON = convertToJSON(users);
        log.debug(JSON);

        //Write JSON string to database
        try {
            firebase.put(JSON);
        } catch(FirebaseException e) {
            log.error("Error: JSON string could not be written");
        } catch(UnsupportedEncodingException e){
            log.error("Error: Unsupported Encoding Exception");
        }

    }

    /**
     * Takes an object and converts it into JSON
     *
     * @param o
     * @return
     */
    private String convertToJSON(Object o){
        //Convert loops to JSON string
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Convert object to JSON string
            String JSON = mapper.writeValueAsString(o);
            return JSON;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (com.fasterxml.jackson.databind.JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public User getUser(String email){
        User user = new User();
        List<User> users = getUsers();

        for(User u : users){
            if((u.getEmail()).equals(email)){
                user = u;
            }
        }

        return user;
    }

    public List<User> getUsers(){
        //http://tutorials.jenkov.com/java-json/jackson-jsonparser.html
        //http://wiki.fasterxml.com/JacksonTreeModel

        String JSON = readFromDatabase("users");
        log.debug("Read from database: " + JSON);

        List<User> users = new ArrayList<User>();

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readValue(JSON, JsonNode.class);

            //Gets each user
            for(JsonNode node : rootNode){

                try {
                    User user = mapper.readValue(node.toString(), User.class);
                    users.add(user);
                } catch (JsonGenerationException e) {
                    e.printStackTrace();
                } catch (com.fasterxml.jackson.databind.JsonMappingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }


    private String readFromDatabase(String URL){
        FirebaseResponse response;
        try {
            response = firebase.get(URL);
            return response.getRawBody();
        } catch(FirebaseException e) {
            log.error("Error: Loops could not be read");
        } catch(UnsupportedEncodingException e){
            log.error("Error: Unsupported Encoding Exception");
        }
        return null;
    }

}