package com.example.demo;

public class Medarbejder {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String telephoneNumber;
    private String Stilling;
    public Medarbejder(){

    }

    public Medarbejder(int id,String firstName, String lastName, String address, String telephoneNumber, String Stilling){
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.Stilling=Stilling;
    }


    public int getId() { return id; }
    public void setId(int id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getStilling() {
        return Stilling;
    }

    public void setStilling(String stilling) {
        Stilling = stilling;
    }

    public String toString() {
        return "Medarbejder{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", address='" + address + '\'' + ", telephoneNumber='" + telephoneNumber + '\'' + ", Stilling='" + Stilling + '\'' + '}';
    }
}