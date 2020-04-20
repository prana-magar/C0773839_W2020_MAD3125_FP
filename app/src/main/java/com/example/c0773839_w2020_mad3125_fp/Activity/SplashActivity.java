package com.example.c0773839_w2020_mad3125_fp.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import com.example.c0773839_w2020_mad3125_fp.R;
import com.example.c0773839_w2020_mad3125_fp.Util.ObjectManager;

public class SplashActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);

        ObjectManager.getInstance().loadObjects();
        System.out.println(ObjectManager.getInstance().getCustomers());

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, 1000);
    }
}
