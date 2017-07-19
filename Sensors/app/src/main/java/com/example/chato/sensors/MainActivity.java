package com.example.chato.sensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RelativeLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);

       Sensor accel=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        List<Sensor> sensorList= sensorManager.getSensorList(Sensor.TYPE_ALL);
//        for(int i=0;i<sensorList.size();i++){
//            Sensor currentSensor= sensorList.get(i);
//        }
//        for(Sensor s:sensorList){
//            Log.d(TAG,"onCreate: "+s.getName());
//            Log.d(TAG,"onCreate: "+s.getVersion());
//            Log.d(TAG,"onCreate: "+s.getMaximumRange());
//            Log.d(TAG,"onCreate: "+s.getType());
//            Log.d(TAG,"onCreate: "+s.getPower());
//            Log.d(TAG,"onCreate: "+s.getVendor());
//            Log.d(TAG,"____________________________");
//        }
        sensorManager.registerListener(new SensorEventListener() {

            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                Log.d(TAG,"onSensorChanged: accel in x "+sensorEvent.values[0]);
                Log.d(TAG,"onSensorChanged: accel in y"+sensorEvent.values[1]);
                Log.d(TAG,"onSensorChanged: accel in z"+sensorEvent.values[2]);
                int r=(int)((Math.abs(sensorEvent.values[0])*255)/11);
                int g=(int)((Math.abs(sensorEvent.values[1])*255)/11);
                int b=(int)((Math.abs(sensorEvent.values[2])*255)/11);
                //Color.rgb(r,g,b);
                RelativeLayout layout=(RelativeLayout)findViewById(R.id.layout);
                       layout.setBackgroundColor(Color.rgb(r,g,b));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        },accel,1000000);

//        Log.d(TAG,"onCreate: "+accel.getName());
//        Log.d(TAG,"onCreate: "+accel.getVersion());
//        Log.d(TAG,"onCreate: "+accel.getMaximumRange());
//        Log.d(TAG,"onCreate: "+accel.getType());
//        Log.d(TAG,"onCreate: "+accel.getPower());
//        Log.d(TAG,"onCreate: "+accel.getVendor());
//        07-07 17:56:08.456 22984-22984/com.example.chato.sensors D/MainActivity: onCreate: BOSCH BMA253 3-axis Accelerometer
//        07-07 17:56:08.456 22984-22984/com.example.chato.sensors D/MainActivity: onCreate: 5021020
//        07-07 17:56:08.456 22984-22984/com.example.chato.sensors D/MainActivity: onCreate: 39.2266
//        07-07 17:56:08.456 22984-22984/com.example.chato.sensors D/MainActivity: onCreate: 1
//        07-07 17:56:08.456 22984-22984/com.example.chato.sensors D/MainActivity: onCreate: 0.2
//        07-07 17:56:08.456 22984-22984/com.example.chato.sensors D/MainActivity: onCreate: BOSCH




    }
}
