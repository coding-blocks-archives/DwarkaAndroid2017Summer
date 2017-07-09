package com.codingblocks.interfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.buttonNext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),DetailActivity.class));
            }
        });
    }

    @Override
    public void changeText(String text) {
        BFragment bFragment = (BFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentB);
        bFragment.setText();
    }
}
