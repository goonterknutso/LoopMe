package com.loopme.loopgenerator;

import com.firebase.client.Firebase;

/**
 * Created by gunther on 10/3/16.
 */
public class FireDBHelper {
    Firebase myFirebase;

    public FireDBHelper(){
        myFirebase = new Firebase("https://loopme-144918.firebaseio.com/");
    }

    public void saveLoopPatterns(Object o){
        myFirebase.setValue(o);
    }


}
