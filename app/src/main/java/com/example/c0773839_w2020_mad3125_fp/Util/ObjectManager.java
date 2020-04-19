package com.example.c0773839_w2020_mad3125_fp.Util;

import com.example.c0773839_w2020_mad3125_fp.Model.Bill.HydroBill;
import com.example.c0773839_w2020_mad3125_fp.Model.Bill.InternetBill;
import com.example.c0773839_w2020_mad3125_fp.Model.Bill.MobileBill;
import com.example.c0773839_w2020_mad3125_fp.Model.Customer;
import com.example.c0773839_w2020_mad3125_fp.Model.Provider.CellPhoneProvider;
import com.example.c0773839_w2020_mad3125_fp.Model.Provider.HydroProvider;
import com.example.c0773839_w2020_mad3125_fp.Model.Provider.InternetProvider;

import java.security.SecureRandom;
import java.util.Random;

import java.lang.reflect.Array;
import java.util.HashMap;

public class ObjectManager {
    private static ObjectManager single_instance = null;
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private static final Random RANDOM = new SecureRandom();

    private HashMap<String,Customer> customerHashMap  =  new HashMap<>();
    HashMap<String, MobileBill> mobileBillHashMap  =  new HashMap<>();
    HashMap<String, InternetBill> internetBillHashMap  =  new HashMap<>();
    HashMap<String,HydroBill> hydroBillHashMap  =  new HashMap<>();

    HashMap<String, CellPhoneProvider> cellPhoneProviderHashMap  =  new HashMap<>();
    HashMap<String, InternetProvider> internetProviderHashMap =  new HashMap<>();
    HashMap<String, HydroProvider> hydroProviderHashMap =  new HashMap<>();



    private ObjectManager()
    {

    }

    public static ObjectManager getInstance()
    {
        if (single_instance == null)
            single_instance = new ObjectManager();

        return single_instance;
    }

    public void addCustomer(Customer customer){

        this.customerHashMap.put(customer.getId(),customer);
    }

    public Customer[] getCustomers(){
        return (Customer[]) this.customerHashMap.values().toArray();
    }


    public String getRandomId(){
        StringBuilder returnValue = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }


    public void loadObjects(){
        this.hydroBillHashMap.clear();
        this.internetBillHashMap.clear();
        this.mobileBillHashMap.clear();

        CellPhoneProvider fidoPhoneProvider = new  CellPhoneProvider("FIDO",10,5.0,2);
        this.cellPhoneProviderHashMap.put(fidoPhoneProvider.getName(),fidoPhoneProvider);

        CellPhoneProvider freedomMobilePhoneProvider = new  CellPhoneProvider("Freedom",8,6.0,3);
        this.cellPhoneProviderHashMap.put(fidoPhoneProvider.getName(),freedomMobilePhoneProvider);

        CellPhoneProvider publicMobilePhoneProvider = new  CellPhoneProvider("Public Mobile",30,1.0,2);
        this.cellPhoneProviderHashMap.put(fidoPhoneProvider.getName(),publicMobilePhoneProvider);

        InternetProvider bellInternetProvider = new InternetProvider("Bell",10,5);
        this.internetProviderHashMap.put(bellInternetProvider.getName(),bellInternetProvider);

        InternetProvider rogersInternetProvider = new InternetProvider("Rogers",14,6);
        this.internetProviderHashMap.put(bellInternetProvider.getName(),rogersInternetProvider);

        HydroProvider justEnergyHydroProvider = new HydroProvider("Just Energy", 45, 4);
        this.hydroProviderHashMap.put(justEnergyHydroProvider.getName(),justEnergyHydroProvider);

        HydroProvider bellHydro = new HydroProvider("Bell Energy", 35, 8);
        this.hydroProviderHashMap.put(bellHydro.getName(),bellHydro);



    }


}
