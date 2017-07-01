package com.codingblocks.ultrabatterysaver;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


public class SaverActivity extends AppCompatActivity {

    ImageView chargingImage;
    TextView chargingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_saver);
        chargingImage = (ImageView) findViewById(R.id.chargingIcon);
        chargingText = (TextView) findViewById(R.id.chargingStatus);
        Intent i = getIntent();
        if (i.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            chargingImage.setImageResource(R.drawable.battery_caliberation_discharging);
            chargingText.setText("DISCHARGING");
            chargingText.setTextColor(Color.RED);
        }else if (i.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            chargingImage.setImageResource(R.drawable.battery_caliberation_charging);
            chargingText.setText("CHARGING");
            chargingText.setTextColor(Color.GREEN);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}