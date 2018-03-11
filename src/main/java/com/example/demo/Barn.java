package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Barn {
    private int id;
    private String firstName;
    private String lastName;
    private String farthersName;
    private String mothersName;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateOfBirth;
    private String allergies;

    public Barn() {
    }


    public Barn(int id, String firstName, String lastName, String farthersName, String mothersName, Date Date, String allergies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.farthersName = farthersName;
        this.mothersName = mothersName;
        this.dateOfBirth = Date;
        this.allergies = allergies;
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

    public String getFarthersName() {
        return farthersName;
    }

    public void setFarthersName(String farthersName) {
        this.farthersName = farthersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", farthersName='" + farthersName + '\'' +
                ", mothersName='" + mothersName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", allergies='" + allergies + '\'' +
                '}';
    }
}