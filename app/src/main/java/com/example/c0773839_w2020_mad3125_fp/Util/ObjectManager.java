package com.example.c0773839_w2020_mad3125_fp.Util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.c0773839_w2020_mad3125_fp.Model.Bill.Bill;
import com.example.c0773839_w2020_mad3125_fp.Model.Bill.BillType;
import com.example.c0773839_w2020_mad3125_fp.Model.Bill.HydroBill;
import com.example.c0773839_w2020_mad3125_fp.Model.Bill.InternetBill;
import com.example.c0773839_w2020_mad3125_fp.Model.Bill.MobileBill;
import com.example.c0773839_w2020_mad3125_fp.Model.Contact;
import com.example.c0773839_w2020_mad3125_fp.Model.Customer;
import com.example.c0773839_w2020_mad3125_fp.Model.Gender;
import com.example.c0773839_w2020_mad3125_fp.Model.Provider.CellPhoneProvider;
import com.example.c0773839_w2020_mad3125_fp.Model.Provider.HydroProvider;
import com.example.c0773839_w2020_mad3125_fp.Model.Provider.InternetProvider;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import java.lang.reflect.Array;
import java.util.HashMap;

public class ObjectManager {
    private static ObjectManager single_instance = null;
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private static final Random RANDOM = new SecureRandom();

    private HashMap<String,Customer> customerHashMap  =  new HashMap<>();
    public HashMap<String, MobileBill> mobileBillHashMap  =  new HashMap<>();
    public HashMap<String, InternetBill> internetBillHashMap  =  new HashMap<>();
    public HashMap<String,HydroBill> hydroBillHashMap  =  new HashMap<>();

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
        Customer[] customers = new Customer[this.customerHashMap.size()];
        ArrayList<Customer> list = new ArrayList<Customer>(this.customerHashMap.values());
        int i =0;
        for(Customer customer: list){
            customers[i] = customer;
            i++;
        }
        return customers;
    }

    public BillType getBillType(Bill bill){
        String id = bill.getId();
        for(HydroBill hydroBill: this.hydroBillHashMap.values()){
            if(hydroBill.getId().equals(id)){
                return BillType.Hydro;
            }
        }
        for(InternetBill internetBill: this.internetBillHashMap.values()){
            if(internetBill.getId().equals(id)){
                return BillType.Internet;
            }
        }

        return BillType.Mobile;
    }


    public String getRandomId(){
        StringBuilder returnValue = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }


    public CellPhoneProvider getCellProvider(String name){
        if(this.cellPhoneProviderHashMap.containsKey(name)){
            return this.cellPhoneProviderHashMap.get(name);
        }
        else{
            return this.cellPhoneProviderHashMap.get("FIDO");
        }

    }

    public InternetProvider getInternetProvider(String name){
        if(this.internetProviderHashMap.containsKey(name)){
            return this.internetProviderHashMap.get(name);
        }
        else{
            return this.internetProviderHashMap.get("Bell");
        }

    }

    public HydroProvider getHydroProvider(String name){
        if(this.hydroProviderHashMap.containsKey(name)){
            return this.hydroProviderHashMap.get(name);
        }
        else{
            return this.hydroProviderHashMap.get("Bell Energy");
        }

    }

    public Customer getCustomer(String id){
        for(Customer customer: this.customerHashMap.values()){
            if(customer.getId().equals(id)){
                return customer;
            }
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
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


        MobileBill mobileBill1 = new MobileBill("fido_1", LocalDate.of(2019,7,11),fidoPhoneProvider,
                5,45);
        this.mobileBillHashMap.put(mobileBill1.getId(), mobileBill1);

        HydroBill hydroBill1 = new HydroBill("justenergy_1",LocalDate.of(2019,4,1),justEnergyHydroProvider,
                45);
        this.hydroBillHashMap.put(hydroBill1.getId(),hydroBill1);

        Contact contact1 = null;
        try{
            contact1 = new Contact("(647)2339102","johncena@invisible.com");
        }
        catch (Exception e){
            System.out.println("Cannot create contact");
            System.out.println(e);
        }

        Customer customer1 = new Customer(ObjectManager.getInstance().getRandomId(),
                "John",
                "Cena",
                Gender.MALE,LocalDate.of(1993,4,6),
                "johncena",
                "letmein",
                contact1
                );
        customer1.addBill(mobileBill1);
        customer1.addBill(hydroBill1);

        this.customerHashMap.put(customer1.getId(),customer1);


        // Customer2
        MobileBill mobileBill2 = new MobileBill("publicMobile_1", LocalDate.of(2018,7,11),fidoPhoneProvider,
                5,45);
        this.mobileBillHashMap.put(mobileBill2.getId(), mobileBill2);

        InternetBill internetBill2 = new InternetBill("bell_1",
                LocalDate.of(2019,5,20),
                bellInternetProvider,
                67.8);
        this.internetBillHashMap.put(internetBill2.getId(),internetBill2);

        Contact contact2 = null;
        try{
            contact2 = new Contact("(647)23224444","ram@gmail.com");
        }
        catch (Exception e){
            System.out.println("Cannot create contact");
            System.out.println(e);
        }

        Customer customer2 = new Customer(ObjectManager.getInstance().getRandomId(),
                "Ram",
                "Thapa",
                Gender.MALE,LocalDate.of(1993,4,6),
                "ramthapa",
                "letmein2",
                contact2
        );
        customer2.addBill(mobileBill2);
        customer2.addBill(internetBill2);
        this.customerHashMap.put(customer2.getId(),customer2);



        // Customer3
        MobileBill mobileBill3= new MobileBill("publicMobile_3", LocalDate.of(2015,7,11),fidoPhoneProvider,
                34,5);
        this.mobileBillHashMap.put(mobileBill3.getId(), mobileBill3);

        InternetBill internetBill3 = new InternetBill("bell_3",
                LocalDate.of(2020,1,20),
                bellInternetProvider,
                27.8);
        this.internetBillHashMap.put(internetBill3.getId(),internetBill3);

        InternetBill internetBill4 = new InternetBill("bell_4",
                LocalDate.of(2019,3,20),
                bellInternetProvider,
                7.8);
        this.internetBillHashMap.put(internetBill4.getId(),internetBill4);

        HydroBill hydroBill4 = new HydroBill("bell_energy4",
                LocalDate.of(2019,3,20),
                bellHydro,
                55.90);
        this.hydroBillHashMap.put(hydroBill4.getId(),hydroBill4);

        Contact contact3 = null;
        try{
            contact3 = new Contact("(647)23224434","prakash@gmail.com");
        }
        catch (Exception e){
            System.out.println("Cannot create contact");
            System.out.println(e);
        }

        Customer customer3 = new Customer(ObjectManager.getInstance().getRandomId(),
                "Prakash",
                "Rana",
                Gender.MALE,LocalDate.of(1995,4,6),
                "prakashrana",
                "letmein2",
                contact3
        );
        customer3.addBill(mobileBill3);
        customer3.addBill(internetBill3);
        customer3.addBill(internetBill4);
        customer3.addBill(hydroBill4);
        this.customerHashMap.put(customer3.getId(),customer3);


        Contact contact4 = null;
        try{
            contact4 = new Contact("(647)33224434","shyam@gmail.com");
        }
        catch (Exception e){
            System.out.println("Cannot create contact");
            System.out.println(e);
        }

        Customer customer4 = new Customer(ObjectManager.getInstance().getRandomId(),
                "Shyam",
                "tam",
                Gender.MALE,LocalDate.of(1989,4,6),
                "prakashrana",
                "letmein2",
                contact4
        );

        this.customerHashMap.put(customer4.getId(),customer4);

    }


}
