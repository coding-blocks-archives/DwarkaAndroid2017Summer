package shubham.twitter_api;

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

import static shubham.twitter_api.R.id.imageView;

/**
 * Created by Shubham on 7/7/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    Context c;
    ArrayList<Statuses> arrayList;

    public DataAdapter(Context c, ArrayList<Statuses> arrayList) {
        this.c = c;
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.single_card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Picasso.with(c).load(arrayList.get(position).getUser().getProfile_image_url_https()).fit().into(holder.image);
        holder.name.setText(arrayList.get(position).getUser().getName());
        holder.screenName.setText(arrayList.get(position).getUser().getScreen_name());
        holder.userId.setText(arrayList.get(position).getUser().getUser_id());
        holder.link.setText(arrayList.get(position).getLink());
        holder.favcount.setText(arrayList.get(position).getFavourites_count());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(arrayList.get(position).getLink()));
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, userId, link, favcount, screenName;
        ImageView image;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            name = (TextView) itemView.findViewById(R.id.name);
            userId = (TextView) itemView.findViewById(R.id.userId);
            link = (TextView) itemView.findViewById(R.id.link);
            favcount = (TextView) itemView.findViewById(R.id.favCount);
            screenName = (TextView) itemView.findViewById(R.id.screenName);
            image = (ImageView) itemView.findViewById(imageView);
        }
    }
}
