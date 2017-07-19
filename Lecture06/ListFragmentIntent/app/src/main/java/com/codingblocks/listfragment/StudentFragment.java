package com.codingblocks.listfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by the-dagger on 23/06/17.
 */

public class StudentFragment extends Fragment {

    public static final String NAME = "NAME";

    public static StudentFragment newInstance(String name,String course,String age) {
        Bundle args = new Bundle();
        args.putString(NAME,name);
        args.putString("COURSE",course);
        args.putString("AGE",age);
        StudentFragment fragment = new StudentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_student,container,false);

        Bundle b = getArguments();

        TextView name,course,age;
        name = (TextView) v.findViewById(R.id.nameTextView);
        course = (TextView) v.findViewById(R.id.courseTextView);
        age = (TextView) v.findViewById(R.id.ageTextView);

        name.setText(b.getString(NAME));
        course.setText(b.getString("COURSE"));
        age.setText(b.getString("AGE"));

        return v;
    }
}
