package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

public class Child {
    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<Parent> parents;
    private ArrayList<String> allergies;
    private String picture;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateOfBirth;

    public Child() {
    }

    public Child(int id, String firstName, String lastName, ArrayList<Parent> parents, Date Date, ArrayList<String> allergies, String picture) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.parents = parents;
        this.dateOfBirth = Date;
        this.allergies = allergies;
        this.picture = picture;

    }

    public int getId() {
        return id;
    }

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

    public ArrayList<Parent> getParents() {
        return parents;
    }

    public void setParents(ArrayList<Parent> parents) {
        this.parents = parents;
    }

    public ArrayList<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(ArrayList<String> allergies) {
        this.allergies = allergies;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}