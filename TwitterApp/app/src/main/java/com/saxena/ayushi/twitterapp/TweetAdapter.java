package com.saxena.ayushi.twitterapp;

import android.content.Context;
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
 * Created by dell pc on 7/7/2017.
 */

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder> {
    ArrayList<Statuses> statusesArrayList;
    Context c;

    public TweetAdapter(ArrayList<Statuses> statusesArrayList, Context c) {
        this.statusesArrayList = statusesArrayList;
        this.c = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(c);
        View v = layoutInflater.inflate(R.layout.single_tweet,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Statuses statuses = statusesArrayList.get(position);
        Context context = holder.context;
        holder.name.setText(statuses.getUser().getName());
        holder.screenName.setText(statuses.getUser().getScreen_name());
        holder.link.setText(statuses.getLink());
        holder.text.setText(statuses.getText());
        Picasso.with(context).load(statuses.getUser().getProfile_image_url_https()).into(holder.dp);

    }

    @Override
    public int getItemCount() {
        return statusesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, screenName, link, text;
        ImageView dp;
        Context context;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);

            name= (TextView) itemView.findViewById(R.id.name);
            screenName= (TextView) itemView.findViewById(R.id.screenName);
            link= (TextView) itemView.findViewById(R.id.link);
            text= (TextView) itemView.findViewById(R.id.text);
            dp= (ImageView) itemView.findViewById(R.id.dp);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            context = itemView.getContext();
        }
    }
}
