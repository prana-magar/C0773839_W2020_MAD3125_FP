package com.example.c0773839_w2020_mad3125_fp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0773839_w2020_mad3125_fp.Model.Customer;
import com.example.c0773839_w2020_mad3125_fp.R;

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.MyViewHolder> {
    private Customer[] customers;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public TextView textViewName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           textView = itemView.findViewById(R.id.textViewId);
            textViewName = itemView.findViewById(R.id.name_id);
        }
    }

    public CustomerListAdapter(Customer[] myDataset) {
        customers = myDataset;
    }

    @NonNull
    @Override
    public CustomerListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.item_view_customer, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerListAdapter.MyViewHolder holder, int position) {
        Customer customer = customers[position];
        holder.textView.setText(customer.getId());
        holder.textViewName.setText(customer.getFullName());
    }

    @Override
    public int getItemCount() {
        return customers.length;
    }
}
