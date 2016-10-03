package com.loopme.loopgenerator;

import java.util.ArrayList;

/**
 * Created by gunther on 10/3/16.
 */
public class Loops {

    ArrayList<Loop> loops;

    public Loops(){
        loops = new ArrayList<Loop>();
    }

    public Loop getLoop(int position){
        return loops.get(position);
    }

    public void addLoop(Loop loop){
        loops.add(loop);
    }

    public void removeLoop(Loop loop){
        loops.remove(loop);
    }

    public ArrayList<Loop> getLoops(){
        return loops;
    }

    public void setLoops(ArrayList<Loop> loops){
        this.loops = loops;
    }

}
