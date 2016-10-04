package com.loopme.loopgenerator;

import java.io.FileNotFoundException;

/**
 * Created by gunther on 10/1/16.
 */
public class LoopGeneratorDriver {
    public static void main(String[] args){
        LoopGenerator test1 = new LoopGenerator(20, 2, 2, null);
        test1.generateLoops();
        test1.writeLoopsToTerminal();

        try {
            test1.writeToFirebase();
        } catch (FileNotFoundException e){

        }


        /*LoopGenerator test2 = new LoopGenerator(20, 5, 5, null);
        test2.generateLoops();
        System.out.println(test2.generateJSON());*/
    }
}
