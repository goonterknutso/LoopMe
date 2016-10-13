package com.loopme.loopgenerator;

import com.google.maps.model.LatLng;
import com.google.maps.model.SnappedPoint;

import java.io.FileNotFoundException;

/**
 * Created by gunther on 10/1/16.
 */
public class LoopGeneratorDriver {
    public static void main(String[] args){


        //FireDBHelper firebase = new FireDBHelper();

        LoopGenerator test1 = new LoopGenerator(100, 5, 1);

        //test1.setLoops(firebase.getLoopPatterns());
        test1.generateLoops();

        //firebase.writeLoopPatterns(test1.getLoops());

        //test1.writeLoopsToTerminal();

        LatLng startLocation = new LatLng(43.179325, -89.445582);
        LoopConverter test = new LoopConverter(startLocation, 20);

        test.waypoints(test1.getLoops().getLoop(0));


        /*
        for(SnappedPoint p : test.snapToRoad(test1.getLoops().getLoop(0))){
            System.out.println(p.location.lat+","+p.location.lng);
        }*/


    }
}
