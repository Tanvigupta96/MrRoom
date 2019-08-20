package com.example.mrroom.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrroom.R;

import org.w3c.dom.Text;

public class PlacesVieHolder extends RecyclerView.ViewHolder {
    TextView title;
    ImageView placeImage;

    public PlacesVieHolder(View itemView) {
        super(itemView);
        title=(TextView)itemView.findViewById(R.id.title);
        placeImage=(ImageView)itemView.findViewById(R.id.placeImage);
    }
}
