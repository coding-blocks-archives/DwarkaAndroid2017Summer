package com.codingblocks.rvcheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final ArrayList<Student> studentArrayList = new ArrayList<>();

        studentArrayList.add(new Student("Hari",false));
        studentArrayList.add(new Student("Ram",false));
        studentArrayList.add(new Student("Shyam",false));
        studentArrayList.add(new Student("Bharat",false));
        studentArrayList.add(new Student("Laxman",false));
        studentArrayList.add(new Student("Arun",false));
        studentArrayList.add(new Student("Arjun",false));
        studentArrayList.add(new Student("Kashish",false));
        studentArrayList.add(new Student("Saksham",false));
        studentArrayList.add(new Student("Hari",false));
        studentArrayList.add(new Student("Ram",false));
        studentArrayList.add(new Student("Shyam",false));
        studentArrayList.add(new Student("Bharat",false));
        studentArrayList.add(new Student("Laxman",false));

        final StudentAdapter studentAdapter = new StudentAdapter(studentArrayList,this);
        recyclerView.setAdapter(studentAdapter);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i<studentArrayList.size();i++){
                    if (studentArrayList.get(i).getChecked()){
                        Toast.makeText(getBaseContext(),"Position Checked :" + i,Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
