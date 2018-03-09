package com.example.demo;

import java.util.ArrayList;
import java.util.Date;

public class Child {
    private int id;
    private String firstName;
    private String lastName;
    //private Date dateOfBirth;
    public Child(){}

    public Child(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        //this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return id + " " + firstName + " " + lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    //public Date getDateOfBirth() {
      //  return dateOfBirth;
    //}

    //public void setDateOfBirth(Date dateOfBirth) {
      //  this.dateOfBirth = dateOfBirth;
    //}



}
