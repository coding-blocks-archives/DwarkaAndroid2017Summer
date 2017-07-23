package com.codingblocks.mywidget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.helloText);
        Intent i = getIntent();

        if (i.getAction().equals("android.appwidget.action.APPWIDGET_UPDATE")){
            tv.setText(""+i.getIntExtra("VALUE",0));
        }

    }
}
