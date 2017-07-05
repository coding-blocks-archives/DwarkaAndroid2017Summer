package com.codingblocks.githubapi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by the-dagger on 05/07/17.
 */

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.MyHolder> {

    private ArrayList<User> users;
    private Context context;

    public RecylerViewAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        User user = users.get(position);

        Gson gson = new Gson();
        Picasso.with(context)
                .load(user.getAvatar_url())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(holder.image);
        holder.name.setText(user.getLogin());
        holder.userName.setText(user.getScore());
        holder.id.setText(user.getId());
        holder.url.setText(user.getAvatar_url());

        /*
        Sending serialized data
         */

//        String currentUser = gson.toJson(user);
//
//        Intent i = new Intent(context,MainActivity.class);
//
//        i.putExtra("USER",currentUser);

    }

    @Override
    public int getItemCount() {
        if (users != null)
            return users.size();
        else
            return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
                TextView name, id, userName, url;
        ImageView image;

        public MyHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            id = (TextView) itemView.findViewById(R.id.id);
            userName = (TextView) itemView.findViewById(R.id.userName);
            url = (TextView) itemView.findViewById(R.id.url);
            image = (ImageView) itemView.findViewById(R.id.imageViewUser);
        }
    }

}
