package com.codingblocks.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    public MyService() {
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //Create a new thread and do some work over ther

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    loopForOneSec();
                    Log.e("TAG", "onStartCommand: " + i++);
                }
            }
        });

        thread.start();

        //Stop the service as soon as possible
        stopSelf();

        // Can return either START_STICKY,START_NOT_STICKY or START_REDELIVER_INTENT
        return super.onStartCommand(intent, flags, startId);


    }

    public void loopForOneSec() {
        long currTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - currTime < 1000) ;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
