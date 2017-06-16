package com.codingblocks.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by the-dagger on 16/06/17.
 */

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder>{

    ArrayList<Student> arrayList = new ArrayList<>();
    Context c;

    public StudentsAdapter(ArrayList<Student> arrayList, Context c) {
        this.arrayList = arrayList;
        this.c = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater l = LayoutInflater.from(c);
        View v = l.inflate(R.layout.single_list_item,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Student s = arrayList.get(position);
        viewHolder.name.setText(s.getName());
        viewHolder.age.setText(s.getAge());
        viewHolder.course.setText(s.getCourse());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,age,course;

        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            age = (TextView) v.findViewById(R.id.age);
            course = (TextView) v.findViewById(R.id.course);
        }
    }

}
