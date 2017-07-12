package com.codingblocks.file;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by the-dagger on 12/07/17.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, intent.getIntExtra("KEY",0) + " seconds have passed", Toast.LENGTH_SHORT).show();
    }
}
