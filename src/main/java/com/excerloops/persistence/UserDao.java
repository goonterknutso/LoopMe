package com.excerloops.persistence;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.excerloops.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;
import org.apache.log4j.Logger;


public class UserDao {

    private final String FIREBASE_USERS_URL = "https://excerloops.firebaseio.com/users";
    static Logger log = Logger.getLogger(UserDao.class.getName());

    Firebase users;
    Gson gson;

    public UserDao(){
        try{
            users = new Firebase(FIREBASE_USERS_URL);
            gson = new Gson();
        } catch (FirebaseException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //CRUD

    public Boolean createUser(User user){
        log.debug("CREATE USER METHOD CALLED");
        log.debug(gson.toJson(user));

        String json = gson.toJson(user);
        Map<String, Object> map = new Gson().fromJson(json, new TypeToken<HashMap<String, Object>>() {}.getType());
        try {
            users.put(user.getUid(), map);

            log.debug("User created: "+user.getUid());
            return true;
        } catch (FirebaseException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JacksonUtilityException e) {
            e.printStackTrace();
        }

        return false;
    }

    public User readUser(String uid){

        User readUser = new User();
        readUser.setUid(uid);

        try {
            FirebaseResponse response = users.get(uid);
            Map<String, Object> map = response.getBody();
            String json = gson.toJson(map);
            readUser = gson.fromJson(json, User.class);
        } catch (FirebaseException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return readUser;

    }

    public Boolean updateUser(User user){
        log.debug("UPDATE USER METHOD CALLED");
        log.debug(gson.toJson(user));

        String json = gson.toJson(user);
        Map<String, Object> map = new Gson().fromJson(json, new TypeToken<HashMap<String, Object>>() {}.getType());
        try {
            users.put(user.getUid(), map);
            log.debug("User updated: "+user.getUid());
            return true;
        } catch (FirebaseException e){
            e.printStackTrace();
        } catch (JacksonUtilityException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deleteUser(String uid){
        log.debug("DELETE USER METHOD CALLED");
        log.debug(uid);

        try {
            users.delete(uid);
            log.debug("User deleted: "+uid);
            return true;
        } catch (FirebaseException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean checkExist(String uid){
        try {
            FirebaseResponse response = users.get(uid);

            if(response.getRawBody().equals("null")){
                return false;
            } else {
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