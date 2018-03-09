package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

public class Parent {
    private String firstName;
    private String telephoneNumber;
    private String type;
    private int id;
    private String lastName;
    private static ArrayList<Parent> parents;
    private static ArrayList<String> allergies;
    private String picture;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateOfBirth;

    public Parent(int id, String firstName, String lastName, String telephoneNumber, String type, Date Date, ArrayList<String> allergies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.type = type;
        this.picture = picture;
        this.parents = parents;
        this.allergies = allergies;
        this.dateOfBirth=Date;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static ArrayList<Parent> getParents() {
        return parents;
    }

    public static void setParents(ArrayList<Parent> parents) {
        Parent.parents = parents;
    }

    public static ArrayList<String> getAllergies() {
        return allergies;
    }

    public static void setAllergies(ArrayList<String> allergies) {
        Parent.allergies = allergies;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getDateOfBirth(){
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    public String toString() {
        return "Parent{" +
                "firstName='" + firstName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", lastName='" + lastName + '\'' +
                ", picture='" + picture + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

