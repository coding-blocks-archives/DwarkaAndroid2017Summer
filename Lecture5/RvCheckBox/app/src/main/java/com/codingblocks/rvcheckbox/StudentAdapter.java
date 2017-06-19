package com.codingblocks.rvcheckbox;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by the-dagger on 19/06/17.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>{

    ArrayList<Student> studentArrayList;
    Context c;

    public StudentAdapter(ArrayList<Student> students, Context context) {
        studentArrayList = students;
        c = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.single_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Student s = studentArrayList.get(position);
        holder.name.setText(s.getName());

        holder.isChecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                s.setChecked(isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        CheckBox isChecked;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            isChecked = (CheckBox) itemView.findViewById(R.id.checkbox);
        }
    }

}
