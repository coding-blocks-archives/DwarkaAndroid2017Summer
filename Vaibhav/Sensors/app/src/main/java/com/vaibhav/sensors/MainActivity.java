package com.vaibhav.sensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout= (LinearLayout) findViewById(R.id.linearLayout);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

       Sensor accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
     //   List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

       /* for(int i = 0; i<sensorList.size(); i++){
            Sensor currentSensor = sensorList.get(i);
        }
        for(Sensor s: sensorList){
            Log.e("TAG", "onCreate: NAME" + s.getName() );
            Log.e("TAG", "onCreate: VERSION" + s.getVersion() );
            Log.e("TAG", "onCreate: RANGE" + s.getMaximumRange());
            Log.e("TAG", "onCreate: TYPE" + s.getType() );
            Log.e("TAG", "onCreate: VENDOR" + s.getVendor() );
            Log.e("TAG", "onCreate: POWER" + s.getPower());
            Log.e(TAG, "onCreate: ----------------------------" ); */

        sensorManager.registerListener(new SensorEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                Log.e(TAG, "onSensorChanged: accel in x" +sensorEvent.values[0] );
                Log.e(TAG, "onSensorChanged: accel in y" +sensorEvent.values[1] );
                Log.e(TAG, "onSensorChanged: accel in z" +sensorEvent.values[2] );
                int r= (int) (Math.abs(sensorEvent.values[0])*255/11);
                int b= (int) (Math.abs(sensorEvent.values[1])*255/11);
                int g= (int) (Math.abs(sensorEvent.values[2])*255/11);
                linearLayout.setBackgroundColor(Color.rgb(r, b, g));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        },accel, 100000);


        }


    }

