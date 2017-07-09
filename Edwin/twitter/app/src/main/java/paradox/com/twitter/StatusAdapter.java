package paradox.com.twitter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by winbr on 7/7/2017.
 */

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ViewHolder> {
    ArrayList<Status> statuses = new ArrayList<>();
    Context context;
    public StatusAdapter(ArrayList<Status> statuses) {
        this.statuses = statuses;
    }

    @Override
    public StatusAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater l = LayoutInflater.from(parent.getContext());
        context=parent.getContext();
        Log.e("SA", "onCreateViewHolder");
        View v = l.inflate(R.layout.single_recycler_layout, parent,false);
        ViewHolder vH = new ViewHolder(v);
        return vH;
    }

    @Override
    public void onBindViewHolder(StatusAdapter.ViewHolder holder, int position) {
        Log.e("SA","onBindViewHolder: "+position );
        final Status s = statuses.get(position);
        holder.name.setText(s.getUser().getName());
        holder.place_name.setText(s.getPlace_name());
        holder.user_id.setText(s.getUser().getUser_id());
        holder.screen_name.setText(s.getUser().getScreen_name());
        holder.link.setText(s.getLink());
        holder.favourite_count.setText(s.getFavourite_count());
        holder.retweet_count.setText(s.getRetweet_count());
        holder.link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(s.getLink()));
                context.startActivity(browserIntent);
            }
        });
        holder.text.setText(s.getText());
        Picasso.with(context)
                .load(s.getUser().getProfile_image_url_https())
                .resize(400,400)
                .centerCrop()
                .into(holder.profile_image);
    }

    @Override
    public int getItemCount() {
        return statuses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            screen_name = (TextView) itemView.findViewById(R.id.screen_name);
            user_id = (TextView) itemView.findViewById(R.id.user_id);
            link = (TextView) itemView.findViewById(R.id.link);
            place_name = (TextView) itemView.findViewById(R.id.place);
            text = (TextView) itemView.findViewById(R.id.text);
            profile_image = (ImageView) itemView.findViewById(R.id.user_image);
            favourite_count = (TextView)itemView.findViewById(R.id.favourite_count);
            retweet_count = (TextView) itemView.findViewById(R.id.retweets);
        }
        TextView link, place_name, text, screen_name, name, user_id, favourite_count, retweet_count;
        ImageView profile_image;
    }
}
