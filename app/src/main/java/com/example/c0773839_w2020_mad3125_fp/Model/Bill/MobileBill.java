package com.example.c0773839_w2020_mad3125_fp.Model.Bill;

import com.example.c0773839_w2020_mad3125_fp.Model.Provider.CellPhoneProvider;

import java.time.LocalDate;

public class MobileBill extends Bill {

    CellPhoneProvider cellPhoneProvider;
    double usedGB;
    double usedMinutes;

    BillType billType = BillType.Internet;

    public MobileBill(String id, LocalDate date,CellPhoneProvider cellPhoneProvider, double usedGB,double usedMinutes) {
        this.cellPhoneProvider = cellPhoneProvider;
        this.usedGB = usedGB;
        this.usedMinutes = usedMinutes;
        this.id = id;
        this.date = date;
        this.setTotal(this.usedGB,this.usedMinutes);
    }

    private void setTotal(double usedGB, double usedMinutes){
        this.total = this.cellPhoneProvider.calculateTotalBill(usedGB,usedMinutes);
    }
}
