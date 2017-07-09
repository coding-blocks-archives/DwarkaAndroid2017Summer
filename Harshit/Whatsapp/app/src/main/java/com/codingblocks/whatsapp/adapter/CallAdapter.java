package com.codingblocks.whatsapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.whatsapp.R;
import com.codingblocks.whatsapp.model.Call;

import java.util.ArrayList;

/**
 * Created by the-dagger on 24/06/17.
 */

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.CallHolder>{

    ArrayList<Call> callArrayList;

    public CallAdapter(ArrayList<Call> callArrayList) {
        this.callArrayList = callArrayList;
    }

    @Override
    public CallHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CallHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_call,parent,false));
    }

    @Override
    public void onBindViewHolder(CallHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return callArrayList.size();
    }

    class CallHolder extends RecyclerView.ViewHolder{

        public CallHolder(View itemView) {
            super(itemView);
        }
    }

}
