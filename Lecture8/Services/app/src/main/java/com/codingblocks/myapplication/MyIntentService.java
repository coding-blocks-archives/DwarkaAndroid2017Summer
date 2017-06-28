package com.codingblocks.myapplication;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by the-dagger on 28/06/17.
 */

public class MyIntentService extends IntentService {

    public final String TAG = getClass().getSimpleName();

    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int duration = intent.getIntExtra("duration",10);
        for (int i = 0; i < duration; i++) {
            long currTime = System.currentTimeMillis();
            Log.e(TAG, "onHandleIntent: " + i);
            while (System.currentTimeMillis() - currTime < 1000) ;
        }
        //Start the MainActivity again after the work is done
        startActivity(new Intent(this,MainActivity.class));

        //Display a notificationm after the work is done
        Notification notification = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {

            //Only display the notiifcation if SDK version is above jelly bean

            notification = new Notification.Builder(getBaseContext())
                    .setContentTitle("Title")
                    .setContentText("Description")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .build();
        }

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(1,notification);
    }
}
