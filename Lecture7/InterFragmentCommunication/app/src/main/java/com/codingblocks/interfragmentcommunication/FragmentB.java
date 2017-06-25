package com.codingblocks.interfragmentcommunication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by the-dagger on 25/06/17.
 */

public class FragmentB extends Fragment {


    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);

        textView = v.findViewById(R.id.textViewfragmentB);

        return v;
    }

    public void changeText(String text) {
        textView.setText(text);
    }

}
