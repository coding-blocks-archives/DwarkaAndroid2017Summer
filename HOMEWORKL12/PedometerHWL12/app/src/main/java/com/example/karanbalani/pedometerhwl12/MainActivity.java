package com.example.karanbalani.pedometerhwl12;

import android.app.Notification;
import android.app.NotificationManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView stepsTextView;
    String TAG = "LOGGING";

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stepsTextView = (TextView) findViewById(R.id.stepsTextViewId);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        SensorManager pedoDetectorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor pedoSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        Sensor pedoDetector = pedoDetectorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

        pedoDetectorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                Log.d(TAG, "onSensorChanged: " + sensorEvent.values[0]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        }, pedoDetector, 10000);

        final Notification.Builder stepNotification = new Notification.Builder(MainActivity.this);

        sensorManager.registerListener(new SensorEventListener() {

            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                Log.d(TAG, "onSensorChanged: " + sensorEvent.values[0]);
                stepsTextView.setText("" + sensorEvent.values[0]);

                stepNotification.setContentTitle("PedoMeter App").setContentText("Steps Walked "+sensorEvent.values[0])
                        .setSubText("").setSmallIcon(R.mipmap.ic_launcher_round)
                        .setAutoCancel(true).setOngoing(true);
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(1, stepNotification.build());
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        }, pedoSensor, 100000);
    }
}
