package com.codingblocks.myapplication;

/**
 * Created by the-dagger on 28/06/17.
 */

public class Timer {

    int duration;
    OnTickListener listener;

    public Timer(int duration) {
        this.duration = duration;
        start();
    }

    public void setOnTickListener(OnTickListener l) {
        listener = l;
    }

    public void start(){
        for (int i = 0; i < duration; i++) {
            long currTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - currTime < 1000) ;
            listener.onTick(i);
        }
    }

}
