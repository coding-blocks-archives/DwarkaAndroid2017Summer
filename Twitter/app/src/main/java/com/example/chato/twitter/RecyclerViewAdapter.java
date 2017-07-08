package com.example.chato.twitter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by chato on 7/7/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {

    private ArrayList<Status> status=new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<Status> status) {
        this.status= status;

    }



    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Status statuss = status.get(position);
        User userr= statuss.getUser();

        Gson gson = new Gson();
        Picasso.with(context)
                .load(userr.getProfile_image_url_https())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(holder.profile_image_url_https);
       // holder.name.setText(userr.getName());
        holder.screen_name.setText(statuss.getUser().getScreen_name());
        holder.link.setText(statuss.getLink());
        holder.text.setText(statuss.getText());
        holder.name.setText("@"+statuss.getUser().getName());




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
        if (status != null)
            return status.size();
        else
            return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView name, screen_name, link, text;
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