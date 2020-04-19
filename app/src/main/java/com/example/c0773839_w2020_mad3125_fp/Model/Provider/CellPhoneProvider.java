package com.example.c0773839_w2020_mad3125_fp.Model.Provider;

public class CellPhoneProvider {
    String name;
    double baseRate;
    double gbUsedRate;
    double minuteUsedRate;

    public double calculateTotalBill(double gbUsed, double minuteUsed) {
        return baseRate + (minuteUsed * this.minuteUsedRate) + (gbUsed * this.gbUsedRate);
    }

}
