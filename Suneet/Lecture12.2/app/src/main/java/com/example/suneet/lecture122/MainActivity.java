package com.example.suneet.lecture122;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    int red,green,blue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SensorManager sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor accl=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        List<Sensor> sensorList=sensorManager.getSensorList(Sensor.TYPE_ALL);
        final LinearLayout linearLayout= (LinearLayout) findViewById(R.id.layout);

        /*for(Sensor s:sensorList)

        {
            Log.e("TAG", "onCreate: "+s.getName() );
            Log.e("TAG", "onCreate: "+accl.getPower() );
            Log.e("TAG", "onCreate: "+accl.getStringType() );
            Log.e("TAG", "onCreate: "+accl.getVendor() );
            Log.e("TAG", "onCreate: "+accl.getMaximumRange() );
            Log.e("TAG", "onCreate: "+accl.getResolution() );
            Log.e("TAG", "=============================" );
        }
        Log.e("TAG", "onCreate: "+accl.getName() );*/
        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                Log.e("TAG", "onSensorChanged: "+sensorEvent.values[0] );
                Log.e("TAG", "onSensorChanged: "+sensorEvent.values[1] );
                Log.e("TAG", "onSensorChanged: "+sensorEvent.values[2] );
                red= (int) Math.abs(((sensorEvent.values[0])*255)/11);
                green= (int) Math.abs(((sensorEvent.values[1])*255)/11);
                blue= (int) Math.abs(((sensorEvent.values[2])*255)/11);
                linearLayout.setBackgroundColor(Color.rgb(red,green,blue));



            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        },accl,1000000000);


    }
}
