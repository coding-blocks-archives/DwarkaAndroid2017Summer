package com.codingblocks.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("Arun","13","Pandora"));
        studentArrayList.add(new Student("Arjun","13","Pandora"));
        studentArrayList.add(new Student("Hemant","13","Pandora"));
        studentArrayList.add(new Student("Ram","13","Pandora"));
        studentArrayList.add(new Student("Laxman","14","Pandora"));
        studentArrayList.add(new Student("Sita","18","Pandora"));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        StudentsAdapter studentsAdapter = new StudentsAdapter(studentArrayList,this);
        recyclerView.setAdapter(studentsAdapter);
    }
}
