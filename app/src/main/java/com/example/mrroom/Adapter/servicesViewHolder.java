package com.example.mrroom.Adapter;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.mrroom.R;

public class servicesViewHolder extends RecyclerView.ViewHolder {

    ImageView img;

    public servicesViewHolder(View itemView){
        super(itemView);
        img=itemView.findViewById(R.id.image);
    }
}
