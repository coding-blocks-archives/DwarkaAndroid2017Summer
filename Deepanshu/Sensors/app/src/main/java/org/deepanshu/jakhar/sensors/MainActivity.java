package org.deepanshu.jakhar.sensors;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor s : sensorList){
            Log.d("TAG","onCreate: NAME "+ s.getName());
            Log.d("TAG","onCreate: VERSION "+ s.getVersion());
            Log.d("TAG","onCreate: RANGE "+ s.getMaximumRange());
            Log.d("TAG","onCreate: TYPE "+ s.getType());
            Log.d("TAG","onCreate: POWER "+ s.getPower());
            Log.d("TAG","onCreate: VENDOR "+ s.getVendor());
            Log.d("TAG","---------------------------------");
        }

        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                Log.d("TAG", "onSensorChanged: accel in x " + event.values[0]);
                Log.d("TAG", "onSensorChanged: accel in y " + event.values[1]);
                Log.d("TAG", "onSensorChanged: accel in z " + event.values[2]);
                int r = (int) ((Math.abs(event.values[0])*255)/11);
                int g = (int) ((Math.abs(event.values[1])*255)/11);
                int b = (int) ((Math.abs(event.values[2])*255)/11);
                LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
                layout.setBackgroundColor(Color.rgb(r,g,b));
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        },accel,1000000);
//        Log.d("TAG","onCreate: NAME "+ accel.getName());
//        Log.d("TAG","onCreate: VERSION "+ accel.getVersion());
//        Log.d("TAG","onCreate: RANGE "+ accel.getMaximumRange());
//        Log.d("TAG","onCreate: TYPE "+ accel.getType());
//        Log.d("TAG","onCreate: POWER "+ accel.getPower());
//        Log.d("TAG","onCreate: VENDOR "+ accel.getVendor());
    }
}
