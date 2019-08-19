package com.example.mrroom.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrroom.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements AdapterView.OnItemClickListener{
    ListView listView;
    int[] IMAGES={R.drawable.ic_settings_black_24dp, R.drawable.ic_person_black_24dp,R.drawable.ic_help_black_24dp,R.drawable.ic_contact_mail_black_24dp,R.drawable.ic_supervisor_account_black_24dp,R.drawable.ic_card_giftcard_black_24dp,R.drawable.ic_web_asset_black_24dp,R.drawable.ic_event_available_black_24dp,R.drawable.ic_zoom_out_map_black_24dp};
    String[] item={"Settings","Logout","Need Help?","Contact with us","Recommend to Friends","Offers","Visit our website","FAQ","Terms and Conditions"};


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View output= inflater.inflate(R.layout.fragment_profile, container, false);

        listView=output.findViewById(R.id.listview);

        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);
       // listView.setOnItemClickListener(this);


        return output;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv=(TextView)view;
        Toast.makeText(getActivity(),"You click on"+tv.getText()+position, Toast.LENGTH_LONG).show();


    }

   class CustomAdapter extends BaseAdapter{

       @Override
       public int getCount() {
           return IMAGES.length;
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
           convertView=getLayoutInflater().inflate(R.layout.row_layout,null);
           ImageView img=(ImageView)convertView.findViewById(R.id.imageview);
           TextView txt=(TextView)convertView.findViewById(R.id.tv_item);

           img.setImageResource(IMAGES[position]);
           txt.setText(item[position]);

           return convertView;
       }
   }
}
