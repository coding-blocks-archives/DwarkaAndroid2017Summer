package com.codingblocks.broadcastreceivers;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    LinearLayout constraintLayout;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tView);
        constraintLayout = (LinearLayout) findViewById(R.id.constraintLayout);
        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
//                                     startAnewThread(5);
//                                     buildNotification();
                                     Intent intent = new Intent();
                                     intent.setAction("MY_Action");
                                     intent.putExtra("key", "Notice me Senpai");

                                     LocalBroadcastManager.getInstance(getBaseContext()).sendBroadcast(intent);
                                 }
                             }
        );
        MyReceiver myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(myReceiver, intentFilter);

        MyOtherReceiver myOtherReceiver = new MyOtherReceiver();
        IntentFilter intentFilter1 = new IntentFilter("MY_Action");

        LocalBroadcastManager.getInstance(this).registerReceiver(myOtherReceiver, intentFilter1);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        Log.e("TAG", "onActivityResult: " + requestCode);
        if (requestCode == 111) {
            Toast.makeText(this, "Launched Via pendingIntent", Toast.LENGTH_SHORT).show();
        }
    }

    private void buildNotification() {

        Intent intent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 111, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("This is a title")
                .setContentText("Hi, I'm the description")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentIntent(pendingIntent)
                .addAction(android.R.drawable.ic_menu_send, "Send", pendingIntent)
                .build();

        ((NotificationManager) getSystemService(NOTIFICATION_SERVICE)).notify(1, notification);
    }

    private void startAnewThread(final int timer) {

        Handler h = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };
//
//        HandlerThread handlerThread = new HandlerThread("thread");
//        handlerThread.start();
//
//        Handler h = new Handler(handlerThread.getLooper());
//
//        h.post(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < timer;i++){
//                    long currtime = System.currentTimeMillis();
//                    while (System.currentTimeMillis() - currtime < 1000);
//                }
//                textView.setText("Work Done");
//            }
//        });

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < timer;i++){
//                    long currtime = System.currentTimeMillis();
//                    while (System.currentTimeMillis() - currtime < 1000);
//                }
//                textView.setText("Work Done");
//            }
//        });
//        thread.start();
    }

    class MyOtherReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            textView.setText(intent.getStringExtra("key"));
        }
    }

    class MyReceiver extends BroadcastReceiver {

        public MyReceiver() {
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
            if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
                textView.setText("Power Connected");
                constraintLayout.setBackgroundColor(Color.GREEN);
            } else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
                textView.setText("Power Disconnected");
                constraintLayout.setBackgroundColor(Color.RED);
            }
        }
    }

}
