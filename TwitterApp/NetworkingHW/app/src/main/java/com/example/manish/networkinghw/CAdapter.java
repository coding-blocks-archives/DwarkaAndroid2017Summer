package com.example.manish.networkinghw;

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
 * Created by Manish on 26-06-2017.
 */

public class CAdapter extends RecyclerView.Adapter<CAdapter.ViewHolder>{


    ArrayList arrayList;
    Context context;


    public CAdapter(ArrayList<User> arrayList, Context c) {


        this.arrayList=arrayList;
        this.context=c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View v=li.inflate(R.layout.single_line,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User c = (User) arrayList.get(position);

        holder.name.setText(c.getScreen_name());
        holder.status.setText(c.getText());
        holder.link.setText(c.getLink());
        holder.like.setText("Likes "+c.getFavourites_count());
        holder.retweet.setText("Retweet "+ c.getRetweet_count());
        Picasso.with(context).load(c.getUser().getProfile_image_url_https()).into(holder.img);





    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name,status,link,like,retweet;
        public ViewHolder(View v) {
            super(v);

          img=v.findViewById(R.id.image);
            name=v.findViewById(R.id.name);
            status=v.findViewById(R.id.status);
            link=v.findViewById(R.id.link);
            like=v.findViewById(R.id.like);
            retweet=v.findViewById(R.id.retweet);




        }
    }
}
