package com.example.ashishchawla.sensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {
public static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);

       Sensor accel=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        List<Sensor> sensorList=sensorManager.getSensorList(Sensor.TYPE_ALL);

       // for(int i=0; i<sensorList.size(); i++){
         //   Sensor currentSensor=sensorList.get(i);
        //}


        //foreach loop-- there is no need of increment in this
        for(Sensor s:sensorList){
            Log.d(TAG, "onCreate: NAME " +s.getName());
            Log.d(TAG, "onCreate: VERSION" +s.getVersion());
            Log.d(TAG, "onCreate: MAXIMUM RANGE" +s.getMaximumRange());
            Log.d(TAG, "onCreate: TYPE" +s.getType());
            Log.d(TAG, "onCreate: POWER" +s.getPower());
            Log.d(TAG, "onCreate: VENDOR" +s.getVendor());

            Log.d(TAG, "---------------------");

        }

         sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                Log.d(TAG, "onSensorChanged:accel in x " + sensorEvent.values[0]);
                Log.d(TAG, "onSensorChanged:accel in y " + sensorEvent.values[1]);
                Log.d(TAG, "onSensorChanged:accel in z " + sensorEvent.values[2]);
                int r=(int)((Math.abs(sensorEvent.values[0]*255)/11));
                int g=(int)((Math.abs(sensorEvent.values[1]*255)/11));
                int b=(int)((Math.abs(sensorEvent.values[2]*255)/11));

               // Color.rgb(r,g,b);

                LinearLayout l=(LinearLayout)findViewById(R.id.layout);
                l.setBackgroundColor(Color.rgb(r,g,b));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        }, accel,10000);

        //  Log.d(TAG, "onCreate: NAME " +accel.getName());
        //Log.d(TAG, "onCreate: VERSION" +accel.getVersion());
        //Log.d(TAG, "onCreate: MAXIMUM RANGE" +accel.getMaximumRange());
        //Log.d(TAG, "onCreate: TYPE" +accel.getType());
        //Log.d(TAG, "onCreate: POWER" +accel.getPower());
        //Log.d(TAG, "onCreate: VENDOR" +accel.getVendor());



    }
}
