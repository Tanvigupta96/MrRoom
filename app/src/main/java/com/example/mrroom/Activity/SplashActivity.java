package com.example.mrroom.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mrroom.R;

public class SplashActivity extends AppCompatActivity {
    Thread splashThread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(50);
                        waited += 50;
                    }


                    loadMainActivity();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
//                    SplashActivity.this.finish();

                }

            }
        };
        splashThread.start();
    }

    public void loadMainActivity()
    {
        Intent pintent = new Intent(SplashActivity.this, MainActivity.class);
        pintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        pintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        pintent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(pintent);
    }

}
