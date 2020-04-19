package com.example.c0773839_w2020_mad3125_fp.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**customer class inherits person class and holds the details of customer as well as the vehicles they have rented
 *
 */
public class Customer extends Person {

    private ArrayList<VehicleRent> vehicleRents;

    public Customer(String id, String firstName, String lastName, Gender gender, LocalDate birthDate, String userName, String password, String salt, Contact contact) {
        super(id, firstName, lastName, gender, birthDate, userName, password, salt,contact);
    }

    public Customer(String id, String firstName, String lastName, Gender gender, LocalDate birthDate, String userName, String password, String salt, Address address, ArrayList<VehicleRent> vehicleRents,Contact contact) {
        super(id, firstName, lastName, gender, birthDate, userName, password,salt,contact);
        this.vehicleRents = vehicleRents;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString()+
                " vehicleRents=" + vehicleRents +
                '}';
    }

    public void addVehicleRents(VehicleRent vehicleRent){

        if(this.vehicleRents == null){
            this.vehicleRents = new ArrayList<>();
        }

        this.vehicleRents.add(vehicleRent);
    }

    public void addVehicleRents(List<VehicleRent> vehicleRents){
        for(VehicleRent vehicleRent: vehicleRents){
            this.addVehicleRents(vehicleRent);
        }
    }

    public boolean hasBookings(){
        return this.vehicleRents != null;
    }

    public boolean hasLiveBookings(){

        for(VehicleRent vehicleRent: this.vehicleRents){
            if(vehicleRent.isLive()){
                return true;
            }
        }
        return false;
    }


    public List<VehicleRent> getVehicleRents() {
        return vehicleRents;
    }

    public void setVehicleRents(List<VehicleRent> vehicleRents) {
        this.vehicleRents = (ArrayList<VehicleRent>)vehicleRents;
    }


}
