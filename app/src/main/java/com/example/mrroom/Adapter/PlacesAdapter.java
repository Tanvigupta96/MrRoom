package com.example.mrroom.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mrroom.R;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesVieHolder> {
    Context context;
    int PLACES[]={R.drawable.kakadeo,R.drawable.gurudev,R.drawable.kalyanpur,R.drawable.awadput};
    String[] ITEM={"Kakedo","Gurudev","Kalyanpur","Awadpur"};



    public PlacesAdapter(Context context,int[] PLACES,String[] ITEM){
        this.context=context;
        this.PLACES=PLACES;
        this.ITEM=ITEM;
    }

    @NonNull
    @Override
    public PlacesVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowlayout=inflater.inflate(R.layout.places_layout,parent,false);
        return  new PlacesVieHolder(rowlayout);

    }

    @Override
    public void onBindViewHolder(@NonNull PlacesVieHolder holder, int position) {
        holder.placeImage.setImageResource(PLACES[position]);
        holder.title.setText(ITEM[position]);

    }

    @Override
    public int getItemCount() {
        return PLACES.length;
    }
}
