package com.example.c0773839_w2020_mad3125_fp.Model;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import com.example.c0773839_w2020_mad3125_fp.Util.PasswordUtil;

/**
 * Person class is an abstract class containing attributes to be inherited by Customer, Driver and Owner Classes
 */
public abstract class Person {
     String id;
     String firstName;
     String lastName;
     Gender gender;
     LocalDate birthDate;
     int age;
     String userName;
     String password;
     String salt;
     Contact contact;

    Person(String id, String firstName, String lastName, Gender gender, LocalDate birthDate, String userName,
           String password,String salt, Contact contact) {
        this.salt = PasswordUtil.getSalt(password.length());
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.contact = contact;
        this.userName = userName;
        this.password = PasswordUtil.generateSecurePassword(password, salt);
        this.age = setAge();
    }

    String getFullName() {
        return this.firstName + " " + this.lastName;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private int setAge() {
        this.age = LocalDate.now().getYear() - this.birthDate.getYear();
        return this.age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", age=" + age +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = PasswordUtil.generateSecurePassword(password, salt);
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
