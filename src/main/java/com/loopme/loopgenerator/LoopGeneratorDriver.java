package com.loopme.loopgenerator;

/**
 * Created by gunther on 10/1/16.
 */
public class LoopGeneratorDriver {
    public static void main(String[] args){
        LoopGenerator test = new LoopGenerator(100, 5, 1, null);
        test.generateLoops();
    }
}
