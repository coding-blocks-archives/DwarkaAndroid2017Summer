package com.codingblocks.jobscheduler;

import android.app.Application;
import android.util.Log;

/**
 * Created by aayusharora on 7/26/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TAG", "onCreate: of Application ");
    }
}
