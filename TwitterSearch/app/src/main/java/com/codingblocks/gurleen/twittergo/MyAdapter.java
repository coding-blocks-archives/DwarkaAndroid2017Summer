package com.codingblocks.gurleen.twittergo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by hp on 7/8/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    results obj = new results(new ArrayList<status>());
    Context c;
    ArrayList<status> arrayList=new ArrayList<>();

    public MyAdapter(results obj, Context c)

    {

        this.obj = obj;
        this.c = c;
        arrayList=obj.getStatuses();
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater l = LayoutInflater.from(c);
        View v = l.inflate(R.layout.rowlayout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        final status s = arrayList.get(position);
        // Gson gson = new Gson();
        // String currentUser = gson.toJson(position);
        Picasso.with(c).load(s.getUser().getProfile_image_url_https())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ib);
        if(position%2==0)
           holder.itemView.setBackgroundColor(ContextCompat.getColor(c,R.color.one));
        else
            holder.itemView.setBackgroundColor(ContextCompat.getColor(c,R.color.two));

        holder.name.setText(s.getScreen_name());
        holder.tweet.setText(s.getText());
holder.retweets.setText(s.getRetweet_count());
        holder.likes.setText(s.getFavourites_count());

        holder.tweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(s.getLink()));

                c.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {


        if (arrayList.size() != 0)
            return arrayList.size();
        else return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton ib;
        TextView name, tweet,retweets,likes;
        ImageButton fb;


        public ViewHolder(View itemView) {


            super(itemView);
            ib = (ImageButton) itemView.findViewById(R.id.face);
            name = (TextView) itemView.findViewById(R.id.name);
            tweet = (TextView) itemView.findViewById(R.id.tweet);

retweets=(TextView)itemView.findViewById(R.id.retweets);
            likes=(TextView)itemView.findViewById(R.id.likes);

        }


    }


}
