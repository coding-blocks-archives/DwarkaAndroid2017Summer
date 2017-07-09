package com.bac.nikuson.twitter_api;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by nikus on 07-07-2017.
 */

public class RecyclerVIewAdapter extends RecyclerView.Adapter<RecyclerVIewAdapter.ViewHolder> {
    ArrayList<Statuses> statutes;
    Context c;

    public RecyclerVIewAdapter(ArrayList<Statuses> statutes, Context c) {
        this.statutes = statutes;
        this.c = c;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater l = LayoutInflater.from(c);
        View v = l.inflate(R.layout.card,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Statuses statuses = statutes.get(position);
        holder.textView.setText(statuses.getUsers().getName());
        holder.textView1.setText(statuses.getLink());
        holder.textView2.setText(statuses.getUsers().getUser_id());
        Picasso.with(c).load(statuses.getUsers().getProfile_image_url_https()).fit().into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return statutes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,textView1,textView2;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView1);
            textView = (TextView) itemView.findViewById(R.id.textName);
            textView1 = (TextView) itemView.findViewById(R.id.textLink);
            textView2 = (TextView) itemView.findViewById(R.id.textUser);
        }
    }
}
