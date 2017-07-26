package com.example.suneet.lecture12hw;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    SensorManager  sensorManager;
    Sensor sensor;
    int c=0;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.textView);
        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                textView.setText(event.values[0]+"");
                Log.e("TAG", "onSensorChanged: "+c+ " VALUE "+event.values[0] );
            }


            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, sensor, 2000);
    }






}
