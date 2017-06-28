package com.codingblocks.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements OnTickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = new Button(this);
        LinearLayout v = (LinearLayout) findViewById(R.id.linearLayout);
        button.setText("HELLO");
        button.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Timer l = new Timer(10);
//
//                l.setOnTickListener(MainActivity.this);
//
//                l.start();
                startService(new Intent(getBaseContext(), MyIntentService.class));
                Log.e("TAG", "onClick: ");
            }
        });

        v.addView(button);

    }

    @Override
    public void onTick(int count) {
        //Do Something
    }
}
