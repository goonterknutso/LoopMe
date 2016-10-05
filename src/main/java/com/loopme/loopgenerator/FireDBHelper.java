package com.loopme.loopgenerator;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.SerializationConfig;

public class FireDBHelper{
    private String firebase_baseURL = "https://loopme-144918.firebaseio.com/";
    Firebase firebase;


    public FireDBHelper(){
        try{
            firebase = new Firebase(firebase_baseURL);
        } catch (FirebaseException e){
            System.out.println("Error: couldn't connect to Firebase");
        }
    }



    public void writeLoopPatterns(Loops loops){
        //Convert loops to JSON string
        String JSON = convertToJSON(loops);

        //Write JSON string to database
        writeToDatabase(JSON);
    }

    public Loops getLoopPatterns(){
        String JSON = readFromDatabase("loops");
        Loops loops = (Loops) convertToObject(JSON, Loops.class);
        return loops;
    }



    private String readFromDatabase(String URL){
        FirebaseResponse response;
        try {
            response = firebase.get(URL);
            System.out.println(response.getRawBody());
            return response.getBody().toString();
        } catch(FirebaseException e) {
            System.out.println("Error: Loops could not be read");
        } catch(UnsupportedEncodingException e){
            System.out.println("Error: Unsupported Encoding Exception");
        }
        return null;
    }

    private Object convertToObject(String JSON, Class c){

        //Convert loops to JSON string
        try {
            ObjectMapper mapper = new ObjectMapper();
            Object obj = mapper.readValue(JSON, c);
            return obj;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (com.fasterxml.jackson.databind.JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

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

    private void writeToDatabase(String JSON){
        try {
            firebase.put(JSON);
        } catch(FirebaseException e) {
            System.out.println("Error: JSON string could not be written");
        } catch(UnsupportedEncodingException e){
            System.out.println("Error: Unsupported Encoding Exception");
        }
    }
}