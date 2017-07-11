package com.example.karanbalani.sensorsl12;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    String TAG = "Logging";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinearLayout l = (LinearLayout) findViewById(R.id.backGroundId);


        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

//        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

//        for (Sensor s : sensorList) {
//            Log.v(TAG, "onCreate: name = " + s.getName());
//            Log.v(TAG, "onCreate: version = " + s.getVersion());
//            Log.v(TAG, "onCreate: range = " + s.getMaximumRange());
//            Log.v(TAG, "onCreate: type = " + s.getType());
//            Log.v(TAG, "onCreate: power = " + s.getPower());
//            Log.v(TAG, "onCreate: vendor = " + s.getVendor());
//            Log.v(TAG, "---------------------------------------------------------");
//        }

        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                Log.d(TAG, "onSensorChanged:accel X =  " + sensorEvent.values[0]);
                Log.d(TAG, "onSensorChanged:accel Y =  " + sensorEvent.values[1]);
                Log.d(TAG, "onSensorChanged:accel Z =  " + sensorEvent.values[2]);

                int r = (int) ((Math.abs(sensorEvent.values[0]) * 255)/11);
                int g = (int) ((Math.abs(sensorEvent.values[1]) * 255)/11);
                int b = (int) ((Math.abs(sensorEvent.values[2]) * 255)/11);

                l.setBackgroundColor(Color.rgb(r,g,b));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        }, accel, 100000000);


    }
}
