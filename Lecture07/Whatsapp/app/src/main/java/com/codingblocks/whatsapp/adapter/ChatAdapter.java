package com.codingblocks.whatsapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.whatsapp.R;
import com.codingblocks.whatsapp.model.Chat;

import java.util.ArrayList;

/**
 * Created by the-dagger on 24/06/17.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder>{

    ArrayList<Chat> chatArrayList;

    public ChatAdapter(ArrayList<Chat> chatArrayList) {
        this.chatArrayList = chatArrayList;
    }


    @Override
    public ChatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChatHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_chat,parent,false));
    }

    @Override
    public void onBindViewHolder(ChatHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return chatArrayList.size();
    }

    class ChatHolder extends RecyclerView.ViewHolder{

        public ChatHolder(View itemView) {
            super(itemView);
        }
    }

}
