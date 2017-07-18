package com.example.kashishchugh.twitter;

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
 * Created by kashish chugh on 07-Jul-17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder> {
    ArrayList<Statuses> statuses=new ArrayList<>();
    Context context;

    public RecyclerViewAdapter(ArrayList<Statuses> statuses, Context context) {
        this.statuses = statuses;
        this.context = context;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater l=LayoutInflater.from(context);
        View v=l.inflate(R.layout.single_tweet,parent,false);
        viewHolder vh=new viewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        Statuses user=statuses.get(position);
        holder.text.setText(user.getText());
        holder.link.setText(user.getLink());
        holder.name.setText(user.user.getName());
        holder.id.setText("@"+user.user.getScreen_name());
        Picasso.with(context).load(user.user.getProfile_image_url_https()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return statuses.size();
    }

    public  class viewHolder extends RecyclerView.ViewHolder{
        TextView text,link,name,id;
        ImageView image;
        public viewHolder(View itemView) {
            super(itemView);
            text= (TextView) itemView.findViewById(R.id.tweet);
            id= (TextView) itemView.findViewById(R.id.id);
            name= (TextView) itemView.findViewById(R.id.name);
            link= (TextView) itemView.findViewById(R.id.url);
            image= (ImageView) itemView.findViewById(R.id.image1);
        }
    }
}
