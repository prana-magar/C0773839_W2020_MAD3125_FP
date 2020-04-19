package com.example.c0773839_w2020_mad3125_fp.Model.Provider;

public class HydroProvider {
    String name;
    double baseRate;
    double unitRate;

    public double calculateTotalBill(double unitConsumed){
        return baseRate + (unitConsumed * this.unitRate);
    }

}
