package com.loopme.loopgenerator;

import com.google.maps.model.LatLng;

import java.io.FileNotFoundException;

/**
 * Created by gunther on 10/1/16.
 */
public class LoopGeneratorDriver {
    public static void main(String[] args){

        /*
        FireDBHelper firebase = new FireDBHelper();

        LoopGenerator test1 = new LoopGenerator(100, 5, 1000);

        test1.setLoops(firebase.getLoopPatterns());
        test1.generateLoops();

        firebase.writeLoopPatterns(test1.getLoops());



        test1.writeLoopsToTerminal();*/

        LatLng startLocation = new LatLng(43.179325, -89.445582);
        LoopConverter test = new LoopConverter(startLocation);
        System.out.println(test.calculateLegDistanceKm(10)); //0.001534

        LatLng startLocation2 = new LatLng(64.998567, -97.039141);
        LoopConverter test2 = new LoopConverter(startLocation2);
        System.out.println(test2.calculateLegDistanceKm(10)); //0.001534

    }
}
