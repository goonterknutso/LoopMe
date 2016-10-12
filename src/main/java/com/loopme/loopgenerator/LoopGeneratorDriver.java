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

        LoopGenerator test1 = new LoopGenerator(100, 10, 1);

        //test1.setLoops(firebase.getLoopPatterns());
        test1.generateLoops();

        //firebase.writeLoopPatterns(test1.getLoops());

        test1.writeLoopsToTerminal();

        LatLng startLocation = new LatLng(43.179325, -89.445582);
        LoopConverter test = new LoopConverter(startLocation, 5);


        for(SnappedPoint p : test.snapPointsToRoad(test1.getLoops().getLoop(0))){
            System.out.println(p);
        }


    }
}
