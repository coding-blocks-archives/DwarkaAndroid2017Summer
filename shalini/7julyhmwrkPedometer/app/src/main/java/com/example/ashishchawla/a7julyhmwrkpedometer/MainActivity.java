package com.example.ashishchawla.a7julyhmwrkpedometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

     SensorManager sensorManager;
     TextView textView1;
    boolean running=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        textView1=(TextView)findViewById(R.id.textView1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        running=true;
        Sensor countSensor=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor != null){
            sensorManager.registerListener(this,countSensor,SensorManager.SENSOR_DELAY_UI);
        }else{
            Toast.makeText(this,"Sensor not found",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        running=false;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(running){
            textView1.setText(String.valueOf(sensorEvent.values[0]));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
