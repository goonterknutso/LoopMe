package com.loopme.loopgenerator;

/**
 * Created by gunther on 10/1/16.
 */
public class LoopGeneratorDriver {
    public static void main(String[] args){
        LoopGenerator test1 = new LoopGenerator(100, 5, 1, null);
        test1.generateLoops();
        System.out.println(test1.generateJSON());

        LoopGenerator test2 = new LoopGenerator(20, 5, 5, null);
        test2.generateLoops();
        System.out.println(test2.generateJSON());
    }
}
