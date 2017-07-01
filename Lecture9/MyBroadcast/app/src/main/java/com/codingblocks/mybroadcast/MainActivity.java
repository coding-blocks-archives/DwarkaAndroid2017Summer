package com.codingblocks.mybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView textView;
    MyNewReceiver myNewReceiver;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        textView = (TextView) findViewById(R.id.textView);

        Button b = new Button(this);
        b.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        b.setText("Intent");

        linearLayout.addView(b);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("my_custom_action");
                intent.putExtra("key", "Notice me senpai!");

                //Sending a custom Local Broadcast
                LocalBroadcastManager
                        .getInstance(getBaseContext())
                        .sendBroadcast(intent);

                //Sending a custom Global Broadcast
//                sendBroadcast(intent);

            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("my_custom_action");
        myNewReceiver = new MyNewReceiver();

    }


    @Override
    protected void onStart() {
        super.onStart();

        //Registering a local broadcast
        LocalBroadcastManager
                .getInstance(this)
                .registerReceiver(myNewReceiver, intentFilter);

        //Registering a global broadcastReceiver
//        registerReceiver(myNewReceiver, intentFilter);

    }

    @Override
    protected void onStop() {
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(myNewReceiver);
        super.onStop();

    }


    class MyNewReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            textView.setText(intent.getStringExtra("key"));
        }
    }

}
