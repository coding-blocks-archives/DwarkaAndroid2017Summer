package com.codingblocks.ultrabatterysaver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SaverReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Intent startActivityIntent = new Intent(context,SaverActivity.class);
        startActivityIntent.setAction(intent.getAction());
        context.startActivity(startActivityIntent);
    }
}
