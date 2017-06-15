package com.codingblocks.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Listview extends AppCompatActivity {

    String[] students = new String[]{
            "Vaibhav",
            "Vaibhav2",
            "Anmol",
            "Pulkit",
            "Gurleen",
            "Priya",
            "Harshit",
            "Suneet",
            "Edwin",
            "Vaibhav",
            "Vaibhav2",
            "Anmol",
            "Pulkit",
            "Gurleen",
            "Priya",
            "Harshit",
            "Suneet",
            "Edwin"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, //Using the default layout provided by android
                android.R.id.text1,  //id of desired TextView in the default layout provided by android
                students);
        listView.setAdapter(arrayAdapter);

    }
}
