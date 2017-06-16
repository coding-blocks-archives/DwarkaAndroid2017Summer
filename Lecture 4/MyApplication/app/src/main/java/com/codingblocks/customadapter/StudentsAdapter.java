package com.codingblocks.customadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;
import static com.codingblocks.customadapter.R.id.course;

/**
 * Created by the-dagger on 16/06/17.
 */

public class StudentsAdapter extends BaseAdapter {

    ArrayList<Student> studentArrayList;
    Context c;

    public StudentsAdapter(ArrayList<Student> arrayList, Context context) {
        this.studentArrayList = arrayList;
        this.c = context;
    }

    @Override
    public int getCount() {
        return studentArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.e(TAG, "convertView: " + convertView);
        LayoutInflater l = LayoutInflater.from(c);
        View v;
        ViewHolder viewHolder;

        if (convertView == null){
            v = l.inflate(R.layout.list_single_student,
                    parent,false);

            viewHolder = new ViewHolder();
            viewHolder.age = (TextView) v.findViewById(R.id.age);
            viewHolder.name = (TextView) v.findViewById(R.id.name);
            viewHolder.course = (TextView) v.findViewById(course);
            v.setTag(viewHolder);
        }
        else{
            v = convertView;
            viewHolder = (ViewHolder) v.getTag();
        }

        Student s = studentArrayList.get(position);
        viewHolder.name.setText(s.getName());
        viewHolder.age.setText(s.getAge());
        viewHolder.course.setText(s.getCourse());
        return v;
    }

    static class ViewHolder{
        TextView name,age,course;
    }
}