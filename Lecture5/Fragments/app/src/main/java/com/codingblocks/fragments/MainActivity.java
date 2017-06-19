package com.codingblocks.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    int r=0, b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentA fragmentA = new FragmentA();
        final FragmentB fragmentB = new FragmentB();

        Button red = (Button) findViewById(R.id.redButton);
        Button blue = (Button) findViewById(R.id.blueButton);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r++;
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.container,FragmentB.newInstance(r));
                transaction.commit();
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b++;
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.container,FragmentA.newInstance(b));
                transaction.commit();
            }
        });

    }
}
