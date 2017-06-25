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

    String text;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        textView = v.findViewById(R.id.textViewfragmentB);

        if (savedInstanceState != null && savedInstanceState.containsKey("KEY")){
            String s = savedInstanceState.getString("KEY");
            textView.setText(s);
        }


        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("KEY",text);
    }

    public void changeText(String text) {
        this.text = text;
        textView.setText(text);
    }

}
