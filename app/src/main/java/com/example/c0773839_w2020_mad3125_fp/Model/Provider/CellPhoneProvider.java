package com.example.c0773839_w2020_mad3125_fp.Model.Provider;

import java.io.Serializable;

public class CellPhoneProvider implements Serializable {
    String name;
    double baseRate;
    double gbUsedRate;
    double minuteUsedRate;

    public CellPhoneProvider(String name, double baseRate, double gbUsedRate, double minuteUsedRate) {
        this.name = name;
        this.baseRate = baseRate;
        this.gbUsedRate = gbUsedRate;
        this.minuteUsedRate = minuteUsedRate;
    }

    public double calculateTotalBill(double gbUsed, double minuteUsed) {
        return baseRate + (minuteUsed * this.minuteUsedRate) + (gbUsed * this.gbUsedRate);
    }

    public String getName() {
        return name;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public double getGbUsedRate() {
        return gbUsedRate;
    }

    public double getMinuteUsedRate() {
        return minuteUsedRate;
    }
}
