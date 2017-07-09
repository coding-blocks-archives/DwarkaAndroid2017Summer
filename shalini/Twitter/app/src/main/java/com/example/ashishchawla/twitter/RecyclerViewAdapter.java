package com.example.ashishchawla.twitter;

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
 * Created by ashishchawla on 07/07/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {

    private ArrayList<Status> statusArrayList;

    private Context context;

    public RecyclerViewAdapter(ArrayList<Status> statusArrayList,Context context) {
        this.statusArrayList = statusArrayList;
        this.context=context;
    }




    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater l=LayoutInflater.from(context);
        View v=l.inflate(R.layout.single_layout,
                parent,
                false);
        MyHolder vh=new MyHolder(v);

        return vh;
    }


    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

       final Status statuss = statusArrayList.get(position);

        Picasso.with(context)
                .load(statuss.getUser().getProfile_image_url_https())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(holder.profile_image_url_https);


       holder.screen_name.setText( statuss.getUser().getScreen_name());
        holder.name.setText( statuss.getUser().getName());

        holder.link.setText( statuss.getLink());
        holder.text.setText( statuss.getText());

    }

    @Override
    public int getItemCount() {
        return this.statusArrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView screen_name,name,link,text;
        ImageView profile_image_url_https;

        public MyHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            screen_name = (TextView) itemView.findViewById(R.id.screen_name);
            link = (TextView) itemView.findViewById(R.id.link);
            text = (TextView) itemView.findViewById(R.id.text);
            profile_image_url_https=(ImageView)itemView.findViewById(R.id.profile_image_url_https);
        }
    }


}

