package com.example.c0773839_w2020_mad3125_fp.Model.Provider;

public class HydroProvider {
    String name;
    double baseRate;
    double unitRate;

    public HydroProvider(String name, double baseRate, double unitRate) {
        this.name = name;
        this.baseRate = baseRate;
        this.unitRate = unitRate;
    }

    public double calculateTotalBill(double unitConsumed){
        return baseRate + (unitConsumed * this.unitRate);
    }

    public String getName() {
        return name;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public double getUnitRate() {
        return unitRate;
    }
}
