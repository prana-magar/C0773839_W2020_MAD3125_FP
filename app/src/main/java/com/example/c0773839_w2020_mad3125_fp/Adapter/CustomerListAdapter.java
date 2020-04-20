package com.example.c0773839_w2020_mad3125_fp.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.HttpAuthHandler;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0773839_w2020_mad3125_fp.Model.Customer;
import com.example.c0773839_w2020_mad3125_fp.R;

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.MyViewHolder> {
    private Customer[] customers;
    private OnCardClickListner onCardClickListner;

    public static class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        public TextView textView;
        public TextView textViewName;
        OnCardClickListner onCardClickListner;
        public MyViewHolder(@NonNull View itemView, OnCardClickListner onCardClickListner) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.onCardClickListner = onCardClickListner;
           textView = itemView.findViewById(R.id.textViewId);
            textViewName = itemView.findViewById(R.id.name_id);
        }


        @Override
        public void onClick(View view) {
            onCardClickListner.onClickView(getAdapterPosition());
        }
    }

    public CustomerListAdapter(Customer[] myDataset,OnCardClickListner onCardClickListner) {
        customers = myDataset;
        this.onCardClickListner = onCardClickListner;
    }

    @NonNull
    @Override
    public CustomerListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.item_view_customer, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v,this.onCardClickListner);
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

    public interface OnCardClickListner{
        void onClickView(int position);
    }


}