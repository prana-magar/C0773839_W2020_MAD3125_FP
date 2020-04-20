package com.example.c0773839_w2020_mad3125_fp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.c0773839_w2020_mad3125_fp.Model.Contact;
import com.example.c0773839_w2020_mad3125_fp.Model.Customer;
import com.example.c0773839_w2020_mad3125_fp.R;

public class CustomerDetail extends AppCompatActivity {

    TextView tvName;
    TextView tvEmail;
    TextView tvPhone;
    TextView tvDob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);
        tvName = findViewById(R.id.textViewName);
        tvEmail = findViewById(R.id.textViewEmail);
        tvPhone = findViewById(R.id.textViewPhone);
        tvDob = findViewById(R.id.textViewDob);
        Intent intent = getIntent();
        Customer customer = (Customer)intent.getSerializableExtra("obj");
        tvName.setText(customer.getFullName());
        Contact contact = customer.getContact();
        tvEmail.setText(contact.getEmailId());
        tvPhone.setText(contact.getMobileNumber());
        tvDob.setText(customer.getBirthDate().toString());

    }
}
