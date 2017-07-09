package com.fazevaib.footstepcounter;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = (TextView)findViewById(R.id.textView1);
        b = (Button)findViewById(R.id.buttonReset);

        SensorManager sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor stepCounter =sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        final float[] initValue = {0f};
        sensorManager.registerListener(new SensorEventListener() {

            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {


                if (initValue[0] == 0f)
                {
                    initValue[0] = sensorEvent.values[0];
                }

                t.setText("" + (int)(sensorEvent.values[0] - initValue[0]));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        },stepCounter,100000);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText("" + 0);
                initValue[0] =0f;
            }
        });
    }
}
