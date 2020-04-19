package com.example.c0773839_w2020_mad3125_fp.Model.Provider;

public class InternetProvider {

    String name;
    double baseRate;
    double gbUsedRate;


    public double calculateTotalBill(double gbUsed) {
        return baseRate + (gbUsed * this.gbUsedRate);
    }

}
