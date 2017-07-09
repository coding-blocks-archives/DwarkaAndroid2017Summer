package com.example.dell.twitter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dell on 7/3/2017.
 */

public class DataAdapter extends BaseAdapter {
    ArrayList<Status> dataArrayList;
    Context c;

    public DataAdapter(ArrayList<Status> dataArrayList, Context c) {
        this.dataArrayList = dataArrayList;
        this.c = c;
    }

    @Override
    public int getCount() {
        return dataArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        LayoutInflater layoutInflater= LayoutInflater.from(c);
        ViewHolder viewHolder=new ViewHolder();
        if (convertView==null) {
            v = layoutInflater.inflate(R.layout.single_list_item, parent, false);
            viewHolder.name=(TextView)v.findViewById(R.id.name);
            viewHolder.user_id=(TextView)v.findViewById(R.id.id);
            viewHolder.imageView=(ImageView) v.findViewById(R.id.image);
            viewHolder.image=(TextView) v.findViewById(R.id.text);
            v.setTag(viewHolder);
        }
        else
        {
            v=convertView;
            viewHolder=(ViewHolder)v.getTag();
        }
        Status d = dataArrayList.get(position);
        viewHolder.name.setText(d.user.getName());
        viewHolder.user_id.setText(d.user.getUser_id());
        viewHolder.image.setText(d.getText());
        viewHolder.link=d.getLink();
        //Log.e("TAGAGAG",d.user.getProfile_image_url_https());
        Picasso.with(c).load(d.user.getProfile_image_url_https()).into(viewHolder.imageView);
        return v;
    }
    public class ViewHolder{
        ImageView imageView;
        String link;
        TextView name,user_id,image;
    }
}
