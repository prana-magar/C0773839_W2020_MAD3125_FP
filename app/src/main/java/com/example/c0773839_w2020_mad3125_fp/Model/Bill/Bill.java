package com.example.c0773839_w2020_mad3125_fp.Model.Bill;

import java.io.Serializable;
import java.time.LocalDate;


enum BillType{
    Hydro,
    Mobile,
    Internet

}

 public abstract class Bill  implements Serializable {

     String id;
     LocalDate date;
     BillType billType;
     Double total;


     public String getId() {
         return id;
     }

     public LocalDate getDate() {
         return date;
     }

     public BillType getBillType() {
         return billType;
     }

     public Double getTotal() {
         return total;
     }
 }