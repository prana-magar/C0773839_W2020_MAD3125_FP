package com.example.c0773839_w2020_mad3125_fp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.c0773839_w2020_mad3125_fp.Adapter.BillListAdapter;
import com.example.c0773839_w2020_mad3125_fp.Adapter.CustomerListAdapter;
import com.example.c0773839_w2020_mad3125_fp.Model.Contact;
import com.example.c0773839_w2020_mad3125_fp.Model.Customer;
import com.example.c0773839_w2020_mad3125_fp.R;
import com.example.c0773839_w2020_mad3125_fp.Util.ObjectManager;

import java.text.NumberFormat;
import java.util.Locale;

public class CustomerDetail extends AppCompatActivity implements BillListAdapter.OnCardClickListner {

    TextView tvName;
    TextView tvEmail;
    TextView tvPhone;
    TextView tvDob;
    TextView tvTotal;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);
        tvName = findViewById(R.id.textViewName);
        tvEmail = findViewById(R.id.textViewEmail);
        tvPhone = findViewById(R.id.textViewPhone);
        tvDob = findViewById(R.id.textViewDob);
        tvTotal = findViewById(R.id.textViewTotal);

        Toolbar myToolbar =  findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Detail");
        setSupportActionBar(myToolbar);

        Intent intent = getIntent();
        Customer customer = (Customer)intent.getSerializableExtra("obj");

        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);


        tvName.setText(customer.getFullName());
        Contact contact = customer.getContact();
        tvEmail.setText(contact.getEmailId());
        tvPhone.setText(contact.getMobileNumber());
        tvDob.setText(customer.getBirthDate().toString());
        tvTotal.setText(currencyFormatter.format(customer.getTotal()));

        recyclerView =  findViewById(R.id.bill_lister_RV);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // get bills
        mAdapter = new BillListAdapter(customer.getBills(),this);
        recyclerView.setAdapter(mAdapter);


    }

    @Override
    public void onClickView(int position) {
        System.out.println("bill clicked");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.customer_detail_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {

            case R.id.add_bill:
                Intent intent2 = new Intent(CustomerDetail.this,AddBill.class);
                startActivity(intent2);

        }
        return true;
    }
}
