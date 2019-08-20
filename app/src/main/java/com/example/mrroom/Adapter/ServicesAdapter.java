package com.example.mrroom.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mrroom.R;

public class ServicesAdapter  extends RecyclerView.Adapter<servicesViewHolder> {

    int IMAGES[]={R.drawable.cutlery,R.drawable.rent,R.drawable.amenities,R.drawable.manage};
    Context context;

    public ServicesAdapter(Context context,int[] IMAGES) {
        this.context=context;
        this.IMAGES=IMAGES;
    }



    @NonNull
    @Override
    public servicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowlayout=inflater.inflate(R.layout.services_layout,parent,false);
        return new servicesViewHolder(rowlayout);
    }

    @Override
    public void onBindViewHolder(@NonNull servicesViewHolder holder, int position) {
        holder.img.setImageResource(IMAGES[position]);

    }

    @Override
    public int getItemCount() {
        return IMAGES.length;
    }
}
