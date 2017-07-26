package com.amarpreetsinghprojects.myapplication;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    String TAG = "msg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        


        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        
        /*Log.d(TAG, "onCreate: Name"+ accel.getName());
        Log.d(TAG, "onCreate: Version"+ accel.getVersion());
        Log.d(TAG, "onCreate: Maximum Range"+ accel.getMaximumRange());
        Log.d(TAG, "onCreate: Type"+ accel.getType());
        Log.d(TAG, "onCreate: Power"+ accel.getPower());
        Log.d(TAG, "onCreate: Vendor"+ accel.getVendor());*/
        // for each loop
        // every iteration goes through one object of the list
       /* for (Sensor s : sensorList){
            Log.d(TAG, "onCreate: Name"+ s.getName());
            Log.d(TAG, "onCreate: Version"+ s.getVersion());
            Log.d(TAG, "onCreate: Maximum Range"+ s.getMaximumRange());
            Log.d(TAG, "onCreate: Type"+ s.getType());
            Log.d(TAG, "onCreate: Power"+ s.getPower());
            Log.d(TAG, "onCreate: Vendor"+ s.getVendor());
        }
        */
        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                Log.e(TAG, "onSensorChanged: accel in x"+event.values[0]);
                Log.e(TAG, "onSensorChanged: accel in x" + event.values[1]);
                Log.e(TAG, "onSensorChanged: accel in x" + event.values[2]);

                int r = (int) (Math.abs(event.values[0])*255/11);
                int g = (int) (Math.abs(event.values[1])*255/11);
                int b = (int) (Math.abs(event.values[2])*255/11);

                ConstraintLayout constraintLayout = (ConstraintLayout)findViewById(R.id.parentLayout);
                constraintLayout.setBackgroundColor(Color.rgb(r,g,b));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        },accel,100000);
    }
}
