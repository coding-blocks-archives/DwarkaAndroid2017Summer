package com.example.karanbalani.twittersearchl12;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by karanbalani on 07/07/17.
 */

public class RecyclerStatusAdapter extends RecyclerView.Adapter<RecyclerStatusAdapter.ViewHolder> {

    ArrayList<Statuses> arrayList;
    Context context;

    public RecyclerStatusAdapter(ArrayList<Statuses> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_status, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Statuses S = arrayList.get(position);

        holder.userScreenName.setText("Screen Name: "+S.getUser().getScreen_name());
        holder.userTweet.setText("Tweet: "+S.getText());
        holder.userName.setText("Username: "+S.getUser().getName());
        holder.userId.setText("User ID: "+S.getUser().getUser_id());

        Picasso.with(context).load(S.getUser().getProfile_image_url_https())
                .into(holder.userProfilePic);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userScreenName, userTweet, userName, userId;
        CircleImageView userProfilePic;
        public ViewHolder(View itemView) {
            super(itemView);
            userScreenName = itemView.findViewById(R.id.userScreenNameTextViewId);
            userTweet = itemView.findViewById(R.id.userTweetTextViewId);
            userName = itemView.findViewById(R.id.userNameTextViewId);
            userId = itemView.findViewById(R.id.userIdTextViewId);
            userProfilePic = itemView.findViewById(R.id.userImageViewId);
        }
    }
}
