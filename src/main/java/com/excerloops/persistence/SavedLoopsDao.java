package com.excerloops.persistence;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.excerloops.entity.SavedLoop;
import com.excerloops.entity.SessionIdentifierGenerator;
import com.excerloops.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;
import org.apache.log4j.Logger;


public class SavedLoopsDao {

    private String FIREBASE_SAVED_LOOPS_URL = "https://excerloops.firebaseio.com/savedLoops";
    static Logger log = Logger.getLogger(SavedLoopsDao.class.getName());

    Firebase savedLoopsRef;
    Gson gson;

    /**
     * Constructor for SavedLoopsDao
     */
    public SavedLoopsDao(){
        try{
            savedLoopsRef = new Firebase(FIREBASE_SAVED_LOOPS_URL);
            gson = new Gson();
        } catch (FirebaseException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Reads all saved loops into an ArrayList from Firebase for a UID
     * @param uid
     * @return
     */
    public ArrayList<SavedLoop> readAllSavedLoops(String uid){
        ArrayList<SavedLoop> userSavedLoops = new ArrayList<SavedLoop>();
        Firebase userSavedLoopsRef;

        try {
            userSavedLoopsRef = new Firebase(FIREBASE_SAVED_LOOPS_URL);
            FirebaseResponse response = userSavedLoopsRef.get(uid);
            System.out.println(response.getBody());

            Map<String, Object> map = response.getBody();

            //Read each loop
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String json = gson.toJson(entry.getValue());
                System.out.println(json);
                userSavedLoops.add(gson.fromJson(json, SavedLoop.class));
            }

            return userSavedLoops;

        } catch (FirebaseException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return userSavedLoops;
    }

    public SavedLoop readSavedLoop(String id, String uid){
        SavedLoop savedLoopRead = new SavedLoop();

        Firebase userSavedLoopsRef;

        try {
            userSavedLoopsRef = new Firebase(FIREBASE_SAVED_LOOPS_URL + "/" + uid);
            FirebaseResponse response = userSavedLoopsRef.get(id);
            Map<String, Object> map = response.getBody();
            String json = gson.toJson(map);
            savedLoopRead = gson.fromJson(json, SavedLoop.class);
            return savedLoopRead;

        } catch (FirebaseException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return savedLoopRead;
    }

    public Boolean deleteSavedLoop(String id, String uid){
        log.debug("DELETE SAVED LOOP");

        Firebase userSavedLoopsRef;

        try {
            userSavedLoopsRef = new Firebase(FIREBASE_SAVED_LOOPS_URL + "/" + uid);
            userSavedLoopsRef.delete(id);
            log.debug("Loop deleted: "+id);
            return true;
        } catch (FirebaseException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean addSavedLoop(SavedLoop savedLoop, String uid){
        System.out.println("ADDING SAVED LOOP FOR USER "+uid);
        System.out.println(gson.toJson(savedLoop));

        //Check id for duplicate
        while(true) {
            if (checkExist(uid, savedLoop.getId())) {
                savedLoop.setId(SessionIdentifierGenerator.nextSessionId());
            } else {
                break;
            }
        }

        Firebase userSavedLoopsRef;
        String json = gson.toJson(savedLoop);
        Map<String, Object> map = new Gson().fromJson(json, new TypeToken<HashMap<String, Object>>() {}.getType());

        try{
            userSavedLoopsRef = new Firebase(FIREBASE_SAVED_LOOPS_URL + "/" + uid);
            userSavedLoopsRef.put(savedLoop.getId(), map);
            System.out.println("Saved Loop Add");
            return true;
        } catch (FirebaseException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } catch (JacksonUtilityException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean checkExist(String uid, String id){

        Firebase checkSavedLoopRef;

        try{
            checkSavedLoopRef = new Firebase(FIREBASE_SAVED_LOOPS_URL + "/" + uid);

            FirebaseResponse response = checkSavedLoopRef.get(id);
            System.out.println("Response: "+response);
            System.out.println("RawBody: "+response.getRawBody());
            System.out.println("Body: "+response.getBody());
            System.out.println("Code: "+response.getCode());
            System.out.println("Success: "+response.getSuccess());

            if(response.getRawBody().equals("null")){
                System.out.println("Loop id not exist!");
                return false;
            } else {
                System.out.println("Loop id exist!");
                return true;
            }
        } catch (FirebaseException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return false;
    }


}