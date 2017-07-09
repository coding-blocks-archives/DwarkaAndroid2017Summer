package com.codingblocks.interfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    @Override
    public void changeText(String text) {
        CFragment cFragment = (CFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentC);
        cFragment.changeFragmentCText(text);
    }
}
