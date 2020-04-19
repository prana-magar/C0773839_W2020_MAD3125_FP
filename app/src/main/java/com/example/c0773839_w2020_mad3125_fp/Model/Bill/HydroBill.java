package com.example.c0773839_w2020_mad3125_fp.Model.Bill;

import com.example.c0773839_w2020_mad3125_fp.Model.Provider.HydroProvider;

import java.time.LocalDate;

public class HydroBill extends Bill {

    HydroProvider hydroProvider;
    double unitConsumed;
    String id;
    LocalDate date;
    BillType billType = BillType.Hydro;
    Double total;

    public HydroBill(String id, LocalDate date,HydroProvider hydroProvider, double unitConsumed) {
        this.hydroProvider = hydroProvider;
        this.unitConsumed = unitConsumed;
        this.id = id;
        this.date = date;
        this.setTotal(this.unitConsumed);
    }

    private void setTotal(double unitConsumed){
        this.total = this.hydroProvider.calculateTotalBill(unitConsumed);
    }
}
