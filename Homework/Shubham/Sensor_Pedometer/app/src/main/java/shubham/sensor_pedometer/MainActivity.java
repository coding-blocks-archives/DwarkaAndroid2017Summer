package shubham.sensor_pedometer;

import android.app.Notification;
import android.app.NotificationManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        SensorManager manager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Step Detector
        manager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                Log.e("TAG", "onSensorChanged: " + event.values[0]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, manager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER),SensorManager.SENSOR_DELAY_UI);

        //Step Counter
        manager.registerListener(new SensorEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onSensorChanged(SensorEvent event) {
                Log.e("TAG", "onSensorChanged: " + event.values[0]);
                textView.setText(""+event.values[0]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, manager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR),SensorManager.SENSOR_DELAY_UI );
    }

    @Override
    protected void onStop() {
        finish();
        super.onStop();
    }
}
