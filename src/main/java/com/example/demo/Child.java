package com.example.demo;

import java.util.ArrayList;
import java.util.Date;

public class Child {
    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<Parent> parents;
    private Date dateOfBirth;
    private ArrayList<String> allergies;
    private String picture;

    public Child(){}

    public Child(int id, String firstName, String lastName, ArrayList<Parent> parents, Date dateOfBirth, ArrayList<String> allergies, String picture) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.parents = parents;
        this.dateOfBirth = dateOfBirth;
        this.allergies = allergies;
        this.picture = picture;
    }

    public void createChild(){

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

    public ArrayList<Parent> getParents() {
        return parents;
    }

    public void setParents(ArrayList<Parent> parents) {
        this.parents = parents;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
}
