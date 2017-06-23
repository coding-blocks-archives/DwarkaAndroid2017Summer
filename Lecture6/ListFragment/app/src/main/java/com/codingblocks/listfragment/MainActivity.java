package com.codingblocks.listfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentArrayList;
    ArrayList<String> stringArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listViewStudnt);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.containerFragment);
        studentArrayList = new ArrayList<>();
        stringArrayList = new ArrayList<>();
        studentArrayList.add(new Student("Arun", "13", "Pandora"));
        studentArrayList.add(new Student("Arjun", "13", "Pandora"));
        studentArrayList.add(new Student("Hemant", "13", "Pandora"));
        studentArrayList.add(new Student("Ram", "13", "Pandora"));
        studentArrayList.add(new Student("Laxman", "14", "Pandora"));
        studentArrayList.add(new Student("Sita", "18", "Pandora"));
        stringArrayList.add("Arun");
        stringArrayList.add("Arjun");
        stringArrayList.add("Hemant");
        stringArrayList.add("Ram");
        stringArrayList.add("Laxman");
        stringArrayList.add("Sita");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,
                android.R.id.text1,
                stringArrayList
        );

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student currentStudent = studentArrayList.get(position);
                getSupportFragmentManager().
                        beginTransaction().
                        replace(R.id.containerFragment, StudentFragment.newInstance(currentStudent.getName(),
                                currentStudent.getCourse(),
                                currentStudent.getAge())).
                        commit();
            }
        });
    }

}
