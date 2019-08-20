package com.example.mrroom.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;

import com.example.mrroom.Adapter.FragmentAdapter;
import com.example.mrroom.Fragment.HomeFragment;
import com.example.mrroom.Fragment.MailFragment;
import com.example.mrroom.Fragment.ManagerFragment;
import com.example.mrroom.Fragment.NotificationFragment;
import com.example.mrroom.Fragment.ProfileFragment;
import com.example.mrroom.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {
    ViewPager viewPager;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mtoggle;
    private   NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);



        mtoggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(mtoggle);
        mtoggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        bottomNavigationView = findViewById(R.id.navigation);
        navigationView=findViewById(R.id.nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        navigationView.setNavigationItemSelectedListener(this);


        viewPager = findViewById(R.id.viewpager);
        setupFm(getSupportFragmentManager(), viewPager);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new PageChange());

    }

    public static void setupFm(FragmentManager fragmentManager, ViewPager viewPager) {
        FragmentAdapter Adapter = new FragmentAdapter(fragmentManager);
        //Add All Fragment To List
        Adapter.add(new HomeFragment(), "Home Fragment");
        Adapter.add(new MailFragment(), "Mail Fragment");
        Adapter.add(new ProfileFragment(), "Profile Fragment");
        Adapter.add(new ManagerFragment(), "Manager fragment");
        Adapter.add(new NotificationFragment(), "Notification Fragment");
        viewPager.setAdapter(Adapter);
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                getSupportActionBar().setTitle("MrRoom");
                getSupportActionBar().setSubtitle("Your Instant Room Partner");
                viewPager.setCurrentItem(0);
                break;
            case R.id.email:
                getSupportActionBar().setTitle("Mail us");
                getSupportActionBar().setSubtitle("Happy to Help!");
                viewPager.setCurrentItem(1);
                break;
            case R.id.profile:
                getSupportActionBar().setTitle("Profile");
                getSupportActionBar().setSubtitle("Manage Settings");

                viewPager.setCurrentItem(2);
                break;
            case R.id.manager:
                getSupportActionBar().setTitle("Personal Rent Manager");
                getSupportActionBar().setSubtitle("Hey,You!");

                viewPager.setCurrentItem(3);
                break;
            case R.id.alert:
                getSupportActionBar().setTitle("Notification");
                getSupportActionBar().setSubtitle("Always Stay Updated");
                viewPager.setCurrentItem(4);
                break;
            case R.id.share:
                ArrayList<String> data = new ArrayList<>();
                data.add("Mr Room");
                data.add("The App simplifies the Process of Searching for rental rooms in a desired Location");
                data.add("https://play.google.com/store/apps/details?id=com.kakarooms");
                String data1 = TextUtils.join("\n", data);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(intent.EXTRA_TEXT, data1);
                startActivity(intent);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    public class PageChange implements ViewPager.OnPageChangeListener {

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mtoggle.onOptionsItemSelected(item)) {

            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
