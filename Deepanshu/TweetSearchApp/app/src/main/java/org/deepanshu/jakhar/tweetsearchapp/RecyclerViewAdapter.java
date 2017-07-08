package org.deepanshu.jakhar.tweetsearchapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Deepanshu on 07/07/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    ArrayList<Status> statusArrayList;
    Context c;

    public RecyclerViewAdapter(ArrayList<Status> statusArrayList, Context c) {
        this.statusArrayList = statusArrayList;
        this.c = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater l = LayoutInflater.from(c);
        View v = l.inflate(R.layout.single_cardview,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Status s = statusArrayList.get(position);
        holder.screenName.setText(s.getScreen_name());
        holder.name.setText(s.getUser().getName());
        holder.content.setText(s.getText());
        Picasso.with(c).load(s.getUser().getProfile_image_url_https()).fit().into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(s.getLink()));
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (statusArrayList.size()>0)
        return statusArrayList.size();
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView screenName,name,content;
        ImageView imageView;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView.findViewById(R.id.cardView);
            screenName = (TextView) itemView.findViewById(R.id.screenName);
            name = (TextView) itemView.findViewById(R.id.name);
            content = (TextView) itemView.findViewById(R.id.content);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
