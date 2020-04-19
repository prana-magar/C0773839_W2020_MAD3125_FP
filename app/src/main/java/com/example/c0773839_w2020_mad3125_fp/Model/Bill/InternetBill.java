package com.example.c0773839_w2020_mad3125_fp.Model.Bill;

import com.example.c0773839_w2020_mad3125_fp.Model.Provider.InternetProvider;

import java.time.LocalDate;

public class InternetBill {

    InternetProvider internetProvider;
    double usedGB;
    String id;
    LocalDate date;
    BillType billType = BillType.Internet;
    Double total;

    public InternetBill(String id, LocalDate date,InternetProvider internetProvider, double usedGB) {
        this.internetProvider = internetProvider;
        this.usedGB = usedGB;
        this.id = id;
        this.date = date;
        this.setTotal(this.usedGB);
    }

    private void setTotal(double usedGB){
        this.total = this.internetProvider.calculateTotalBill(usedGB);
    }
}
