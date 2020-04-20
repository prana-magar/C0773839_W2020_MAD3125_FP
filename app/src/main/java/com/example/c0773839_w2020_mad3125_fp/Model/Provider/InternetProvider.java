package com.example.c0773839_w2020_mad3125_fp.Model.Provider;

import java.io.Serializable;

public class InternetProvider implements Serializable {

    String name;
    double baseRate;
    double gbUsedRate;

    public InternetProvider(String name, double baseRate, double gbUsedRate) {
        this.name = name;
        this.baseRate = baseRate;
        this.gbUsedRate = gbUsedRate;
    }


    public double calculateTotalBill(double gbUsed) {
        return baseRate + (gbUsed * this.gbUsedRate);
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
}
