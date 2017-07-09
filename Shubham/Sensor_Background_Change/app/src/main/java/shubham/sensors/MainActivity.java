package shubham.sensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
//                Log.d(TAG, "onSensorChanged: accel in X" + event.values[0]);
//                Log.d(TAG, "onSensorChanged: accel in Y" + event.values[1]);
//                Log.d(TAG, "onSensorChanged: accel in Z" + event.values[2]);

                int r = (int) ((Math.abs(event.values[0])*255)/11);
                int b = (int) ((Math.abs(event.values[1])*255)/11);
                int g = (int) ((Math.abs(event.values[2])*255)/11);

                LinearLayout l = (LinearLayout) findViewById(R.id.linearLayout);

                l.setBackgroundColor(Color.rgb(r,g,b));

            }

//            @Override
//            public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//            }
//        },accel,1000000);

    }
}
