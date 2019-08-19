package com.example.mrroom.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mrroom.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MailFragment extends Fragment implements View.OnClickListener {
    ImageView img;


    public MailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View output= inflater.inflate(R.layout.mail_fragment, container, false);
        img=output.findViewById(R.id.img);

        img.setOnClickListener(this);

        return output;
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        Uri uri=Uri.parse("mailto:ask@mrroom.in");
        intent.setData(uri);
        startActivity(intent);


    }
}
