package com.codingblocks.whatsapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.whatsapp.R;
import com.codingblocks.whatsapp.model.Status;

import java.util.ArrayList;

/**
 * Created by the-dagger on 24/06/17.
 */

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.StatusHolder> {

    private ArrayList<Status> statusArrayList;

    public StatusAdapter(ArrayList<Status> statusArrayList) {
        this.statusArrayList = statusArrayList;
    }

    @Override
    public StatusHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StatusHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_status, parent, false));
    }

    @Override
    public void onBindViewHolder(StatusHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return statusArrayList.size();
    }

    class StatusHolder extends RecyclerView.ViewHolder {

        public StatusHolder(View itemView) {
            super(itemView);
        }
    }

}
