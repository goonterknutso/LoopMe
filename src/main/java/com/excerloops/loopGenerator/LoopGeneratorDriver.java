package com.excerloops.loopGenerator;

/**
 * Created by gunther on 10/1/16.
 */
public class LoopGeneratorDriver {
    public static void main(String[] args){

        LoopGenerator test1 = new LoopGenerator(100, 5, 1);

        test1.generateLoops();
        test1.logLoops();

    }
}
