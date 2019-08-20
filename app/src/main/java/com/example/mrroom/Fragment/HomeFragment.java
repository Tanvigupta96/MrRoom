package com.example.mrroom.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrroom.Adapter.PlacesAdapter;
import com.example.mrroom.Adapter.ServicesAdapter;
import com.example.mrroom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView rv;
    private RecyclerView rv1;
    int IMAGES[]={R.drawable.cutlery,R.drawable.rent,R.drawable.amenities,R.drawable.manage};
    int PLACES[]={R.drawable.kakadeo,R.drawable.gurudev,R.drawable.kalyanpur,R.drawable.awadput};
    String[] ITEM={"Kakedo","Gurudev","Kalyanpur","Awadpur"};

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View output = inflater.inflate(R.layout.fragment_home,container,false);
        rv=output.findViewById(R.id.rv);
        rv1=output.findViewById(R.id.rv1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(linearLayoutManager);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rv1.setLayoutManager(linearLayoutManager1);

        ServicesAdapter adapter=new ServicesAdapter(getActivity(),IMAGES);
        PlacesAdapter adapter1=new PlacesAdapter(getActivity(),PLACES,ITEM);

        rv.setItemAnimator(new DefaultItemAnimator());
        rv1.setItemAnimator(new DefaultItemAnimator());

        rv.setAdapter(adapter);
        rv1.setAdapter(adapter1);

        return output;
    }


}

