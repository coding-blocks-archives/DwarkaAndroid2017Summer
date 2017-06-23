package com.codingblocks.listfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by the-dagger on 23/06/17.
 */

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerDetail, StudentFragment.newInstance(intent.getStringExtra("NAME"),
                        intent.getStringExtra("COURSE"),
                        intent.getStringExtra("AGE")))
                .commit();
    }
}
