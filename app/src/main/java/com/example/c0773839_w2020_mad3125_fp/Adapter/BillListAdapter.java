package com.example.c0773839_w2020_mad3125_fp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0773839_w2020_mad3125_fp.Model.Bill.Bill;
import com.example.c0773839_w2020_mad3125_fp.Model.Bill.BillType;
import com.example.c0773839_w2020_mad3125_fp.Model.Customer;
import com.example.c0773839_w2020_mad3125_fp.R;
import com.example.c0773839_w2020_mad3125_fp.Util.ObjectManager;

import java.text.NumberFormat;
import java.util.Locale;

public class BillListAdapter extends RecyclerView.Adapter<BillListAdapter.MyViewHolder> {
    private Bill[] bills;
    private OnCardClickListner onCardClickListner;

    public static class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        public TextView textViewBillId;
        public TextView textViewBillTotal;
        public TextView textViewBillDate;
        public TextView textViewBillType;

        OnCardClickListner onCardClickListner;
        public MyViewHolder(@NonNull View itemView, OnCardClickListner onCardClickListner) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.onCardClickListner = onCardClickListner;
            textViewBillId = itemView.findViewById(R.id.textViewBillId);
            textViewBillTotal = itemView.findViewById(R.id.textViewBillTotal);
            textViewBillDate = itemView.findViewById(R.id.textViewBillDate);
            textViewBillType = itemView.findViewById(R.id.textViewBillType);
        }


        @Override
        public void onClick(View view) {
            onCardClickListner.onClickView(getAdapterPosition());
        }
    }

    public BillListAdapter(Bill[] myDataset, OnCardClickListner onCardClickListner) {
        bills = myDataset;
        this.onCardClickListner = onCardClickListner;
    }

    @NonNull
    @Override
    public BillListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.item_view_bill, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v,this.onCardClickListner);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull BillListAdapter.MyViewHolder holder, int position) {
        Bill bill = bills[position];
        holder.textViewBillId.setText(bill.getId());
        holder.textViewBillType.setText(ObjectManager.getInstance().getBillType(bill).name);
        holder.textViewBillDate.setText(bill.getDate().toString());

        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        holder.textViewBillTotal.setText(currencyFormatter.format(bill.getTotal()));
    }

    @Override
    public int getItemCount() {
        return bills.length;
    }

    public interface OnCardClickListner{
        void onClickView(int position);
    }


}
