package com.example.c0773839_w2020_mad3125_fp.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0773839_w2020_mad3125_fp.Adapter.CustomerListAdapter;
import com.example.c0773839_w2020_mad3125_fp.Model.Bill.InternetBill;
import com.example.c0773839_w2020_mad3125_fp.R;
import com.example.c0773839_w2020_mad3125_fp.Util.ObjectManager;

public class CustomerLister extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove later
        ObjectManager.getInstance().loadObjects();
        setContentView(R.layout.activity_customer_lister);
        recyclerView =  findViewById(R.id.customer_recycler_id);


        Toolbar myToolbar =  findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Customers");
        setSupportActionBar(myToolbar);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new CustomerListAdapter(ObjectManager.getInstance().getCustomers());
        recyclerView.setAdapter(mAdapter);



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
