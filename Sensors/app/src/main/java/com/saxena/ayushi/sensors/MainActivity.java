package com.saxena.ayushi.sensors;

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
    public static final String TAG="MAIN ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SensorManager sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        
//        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
//
//        for(Sensor s : sensorList){
//            Log.e(TAG, "onCreate: Name "+s.getName() );
//            Log.e(TAG, "onCreate: Version "+s.getVersion() );
//            Log.e(TAG, "onCreate: MaxRange "+s.getMaximumRange() );
//            Log.e(TAG, "onCreate: Power "+s.getPower() );
//            Log.e(TAG, "onCreate: Vendor "+s.getVendor() );
//            Log.e(TAG, "--------------------------------------");
//        }
        
        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                Log.e(TAG, "onSensorChanged: X " +sensorEvent.values[0]);
                Log.e(TAG, "onSensorChanged: Y " +sensorEvent.values[1]);
                Log.e(TAG, "onSensorChanged: Z " +sensorEvent.values[2]);

                int r = (int) ((Math.abs(sensorEvent.values[0]))*255/11);
                int g = (int) ((Math.abs(sensorEvent.values[1]))*255/11);
                int b = (int) ((Math.abs(sensorEvent.values[2]))*255/11);

                LinearLayout l = (LinearLayout) findViewById(R.id.linearLayout);
                l.setBackgroundColor(Color.rgb(r,b,g));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        },accel,0);


    }
}
