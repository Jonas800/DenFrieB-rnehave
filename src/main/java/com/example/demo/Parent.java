package com.example.demo;

import java.util.ArrayList;
import java.util.Date;

public class Parent {
    private String firstName;
    private String telephoneNumber;
    private String type;
    private int id;
    private String lastName;
    private int childId;

    public Parent(){}
    public Parent(String firstName, String telephoneNumber, String type, int id, String lastName, int childId) {
        this.firstName = firstName;
        this.telephoneNumber = telephoneNumber;
        this.type = type;
        this.id = id;
        this.lastName = lastName;
        this.childId = childId;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
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

}
