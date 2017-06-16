package com.codingblocks.customadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import static com.codingblocks.customadapter.R.id.studentsListView;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentArrayList = new ArrayList<>();
    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentArrayList.add(new Student("Arun","13","Pandora"));
        studentArrayList.add(new Student("Arjun","13","Pandora"));
        studentArrayList.add(new Student("Hemant","13","Pandora"));
        studentArrayList.add(new Student("Ram","13","Pandora"));
        studentArrayList.add(new Student("Laxman","14","Pandora"));
        studentArrayList.add(new Student("Sita","18","Pandora"));
        ListView studentsList = (ListView) findViewById(studentsListView);
        StudentsAdapter studentsAdapter = new StudentsAdapter(studentArrayList,this);
        studentsList.setAdapter(studentsAdapter);
    }

}
