package com.codingblocks.interfragmentcommunication;


import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void changeText(String text) {
        Fragment fragmentB = getSupportFragmentManager().findFragmentById(R.id.fragmentB);

        FragmentB fragment = (FragmentB) fragmentB;

        fragment.changeText(text);
    }
}
