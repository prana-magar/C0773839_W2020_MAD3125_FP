package com.example.c0773839_w2020_mad3125_fp.Model.Bill;

public enum BillType {

        Hydro("Hydro"),
        Mobile("Mobile"),
        Internet("Internet");
        public final String name;

        BillType(String s) {
            name = s;
        }

        public static String getName(BillType billType) {
                switch (billType){
                        case Hydro:
                                return "Hydro";
                        case Mobile:
                                return "Mobile";
                        case Internet:
                                return "Internet";
                                default:
                                        return "Hydro";

                }
        }
}
