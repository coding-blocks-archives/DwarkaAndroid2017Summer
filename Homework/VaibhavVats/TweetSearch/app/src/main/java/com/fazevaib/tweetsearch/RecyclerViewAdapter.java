package com.fazevaib.tweetsearch;

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
 * Created by Vaibhav on 07-07-2017.
 * Project: TweetSearch
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    Context c;
    ArrayList<Status> statusArrayList;

    public RecyclerViewAdapter(Context c, ArrayList<Status> statusArrayList) {
        this.c = c;
        this.statusArrayList = statusArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater l = LayoutInflater.from(c);
        View v = l.inflate(R.layout.single_item_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Status status = statusArrayList.get(position);
        holder.t1.setText(status.getText());
        Picasso.with(c).load(status.getUser().getProfile_image_url_https()).resize(50,50).into(holder.i1);
        holder.tName.setText(status.getUser().getName());

    }

    @Override
    public int getItemCount() {
        return statusArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView i1;
        TextView t1;
        TextView tName;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            i1 = (ImageView)itemView.findViewById(R.id.imageView1);
            t1 = (TextView)itemView.findViewById(R.id.textView1);
            tName = (TextView)itemView.findViewById(R.id.textViewName);
            cardView = (CardView)itemView.findViewById(R.id.cardView1);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i= getAdapterPosition();
                    Status s = statusArrayList.get(i);
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(s.getLink()));
                    c.startActivity(intent);
                }
            });
        }
    }
}
