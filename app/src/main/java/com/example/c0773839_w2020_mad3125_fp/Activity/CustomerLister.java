package com.example.c0773839_w2020_mad3125_fp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.c0773839_w2020_mad3125_fp.Model.Bill.InternetBill;
import com.example.c0773839_w2020_mad3125_fp.R;

public class CustomerLister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_lister);

        Toolbar myToolbar =  findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Customers");
        setSupportActionBar(myToolbar);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.lister_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.logout:
                Intent intent = new Intent(CustomerLister.this,LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.add_customer:
                System.out.println("Add new clicked");

        }
        return true;
    }
}
