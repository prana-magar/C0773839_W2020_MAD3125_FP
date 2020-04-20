package com.example.c0773839_w2020_mad3125_fp.Model;

import com.example.c0773839_w2020_mad3125_fp.Model.Bill.Bill;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.example.c0773839_w2020_mad3125_fp.Util.PasswordUtil;


/**customer class inherits person class and holds the details of customer as well as the vehicles they have rented
 *
 */
public class Customer extends Person implements Serializable {

    private HashMap<String, Bill> billDict = new HashMap<>();

    public Customer(String id, String firstName, String lastName, Gender gender, LocalDate birthDate, String userName, String password, Contact contact) {
        super(id, firstName, lastName, gender, birthDate, userName, password,contact);
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.birthDate = birthDate;
            this.userName = userName;
            this.contact = contact;
            this.salt = PasswordUtil.getSalt(7);
            this.password = PasswordUtil.generateSecurePassword(password,this.salt);
    }


    public void addBill(Bill bill){
        this.billDict.put(bill.getId(), bill);
    }

    public ArrayList<Bill> getBills(){
        return new ArrayList<Bill>(this.billDict.values());
    }

    public double getTotal(){
        double total = 0;
        for(Bill bill: this.billDict.values()){
            total += bill.getTotal();
        }
        return total;
    }

    public String getFullName()
    {
        return firstName +" "+ lastName;
    }
}
