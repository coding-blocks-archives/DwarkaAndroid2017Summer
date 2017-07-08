package com.apps.nishtha.twitterlec12;

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
 * Created by nishtha on 7/7/17.
 */

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder>{

    ArrayList<Statuses> statusesArrayList;
    Context context;
    CardView cardView;

    public TweetAdapter(ArrayList<Statuses> statusesArrayList, Context context) {
        this.statusesArrayList = statusesArrayList;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder;
        View v;
        v=(LayoutInflater.from(context)).inflate(R.layout.single_tweet,parent,false);
        viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Statuses statuses=statusesArrayList.get(position);
        holder.textName.setText(statuses.getUser().getName());
        holder.textText.setText(statuses.getText());
        holder.textUsername.setText("@"+statuses.getUser().getScreen_name());
        Picasso.with(context)
                .load(statuses.getUser().getProfile_image_url_https())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.image);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse(statuses.getLink());
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
//        Log.d("TAG", "getItemCount: "+statusesArrayList.size());
        if (statusesArrayList==null){
            return 0;
        }

        return statusesArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textName,textText,textUsername;
        ImageView image;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            textName=itemView.findViewById(R.id.textName);
            textText=itemView.findViewById(R.id.textText);
            textUsername=itemView.findViewById(R.id.textUserName);
            image=itemView.findViewById(R.id.image);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }
}
