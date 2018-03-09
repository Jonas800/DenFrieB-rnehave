package com.example.demo;

public class Allergy {
    private String type;
    private int childId;

    public Allergy(){}

    public Allergy(String type, int childId) {
        this.type = type;
        this.childId = childId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }
}
