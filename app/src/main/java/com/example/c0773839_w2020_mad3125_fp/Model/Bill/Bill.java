package com.example.c0773839_w2020_mad3125_fp.Model.Bill;

import java.time.LocalDate;


enum BillType{
    Hydro,
    Mobile,
    Internet

}

 abstract class Bill {

    String id;
    LocalDate date;
    BillType billType;
    Double total;




}
