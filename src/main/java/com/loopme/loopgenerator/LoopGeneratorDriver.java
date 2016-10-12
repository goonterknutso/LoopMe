package com.loopme.loopgenerator;

import java.io.FileNotFoundException;

/**
 * Created by gunther on 10/1/16.
 */
public class LoopGeneratorDriver {
    public static void main(String[] args){

        FireDBHelper firebase = new FireDBHelper();

        LoopGenerator test1 = new LoopGenerator(100, 10, 1000);

        test1.setLoops(firebase.getLoopPatterns());
        test1.generateLoops();

        firebase.writeLoopPatterns(test1.getLoops());



        test1.writeLoopsToTerminal();

    }
}
