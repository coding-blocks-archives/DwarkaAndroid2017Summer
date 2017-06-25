package com.codingblocks.whatsapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.whatsapp.R;

/**
 * Created by the-dagger on 24/06/17.
 */

public class StatusFragment extends Fragment{

    public static StatusFragment newInstance() {

        Bundle args = new Bundle();

        StatusFragment fragment = new StatusFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_status,container,false);
        return v;
    }
}
