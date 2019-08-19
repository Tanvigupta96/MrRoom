package com.example.mrroom.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.mrroom.Adapter.FragmentAdapter;
import com.example.mrroom.Fragment.HomeFragment;
import com.example.mrroom.Fragment.MailFragment;
import com.example.mrroom.Fragment.ManagerFragment;
import com.example.mrroom.Fragment.NotificationFragment;
import com.example.mrroom.Fragment.ProfileFragment;
import com.example.mrroom.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("MrRoom");
        getSupportActionBar().setSubtitle("Your Instant Room Partner");

        viewPager=findViewById(R.id.viewpager);
        setupFm(getSupportFragmentManager(),viewPager);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new PageChange());

    }

    public static void setupFm(FragmentManager fragmentManager, ViewPager viewPager){
        FragmentAdapter Adapter = new FragmentAdapter(fragmentManager);
        //Add All Fragment To List
        Adapter.add(new HomeFragment(), "Home Fragment");
        Adapter.add(new MailFragment(), "Mail Fragment");
        Adapter.add(new ProfileFragment(), "Profile Fragment");
        Adapter.add(new ManagerFragment(), "Manager fragment");
        Adapter.add(new NotificationFragment(),"Notification Fragment");
        viewPager.setAdapter(Adapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.home:
                viewPager.setCurrentItem(0);
                getSupportActionBar().setTitle("MrRoom");
                getSupportActionBar().setSubtitle("Your Instant Room Partner");

                break;
            case R.id.email:
                viewPager.setCurrentItem(1);
                getSupportActionBar().setTitle("Mail us");
                getSupportActionBar().setSubtitle("Happy to Help!");

                break;
            case R.id.profile:
                viewPager.setCurrentItem(2);
                getSupportActionBar().setTitle("Profile");
                getSupportActionBar().setSubtitle("Manage Settings");

                break;
            case R.id.manager:
                viewPager.setCurrentItem(3);
                getSupportActionBar().setTitle("Personal Rent Manager");
                getSupportActionBar().setSubtitle("Hey,You!");

                break;
            case R.id.alert:
                viewPager.setCurrentItem(4);
                getSupportActionBar().setTitle("Notification");
                getSupportActionBar().setSubtitle("Always Stay Updated");

                break;
        }
        return true;
    }



public  class PageChange implements ViewPager.OnPageChangeListener{

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        switch (position) {
            case 0:

                bottomNavigationView.setSelectedItemId(R.id.home);

                break;
            case 1:
                bottomNavigationView.setSelectedItemId(R.id.email);
                break;
            case 2:
                bottomNavigationView.setSelectedItemId(R.id.profile);
                break;
            case 3:
                bottomNavigationView.setSelectedItemId(R.id.manager);
                break;
            case 4:
                bottomNavigationView.setSelectedItemId(R.id.alert);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
}
