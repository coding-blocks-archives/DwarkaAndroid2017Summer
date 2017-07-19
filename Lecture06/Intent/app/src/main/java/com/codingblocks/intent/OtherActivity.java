package com.codingblocks.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by the-dagger on 23/06/17.
 */

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Intent i = getIntent();

        TextView otherTextView = (TextView) findViewById(R.id.otherTextView);
        otherTextView.setText(i.getDataString());
    }
}
