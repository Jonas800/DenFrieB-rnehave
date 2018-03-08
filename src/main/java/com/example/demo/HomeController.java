package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.*;
import java.io.*;
@Controller
public class HomeController extends Child{
    ArrayList<Child> children = new ArrayList<>();
    public static ArrayList<Parent> parents;
    @GetMapping("/")
    public String children(){
        return "boern";
    }

    @PostMapping("boern")

    public static void createChild(String firstName, String telephoneNumber, String type, int id, String lastName, String picture
                     ,String Date, ArrayList<String> allergies) throws Exception{
        PrintStream child = new PrintStream(new File("src/Child.dat"));
        for(Parent index: parents){
            parents.add(new Parent(firstName, lastName, Date, allergies.size(), picture));
            child.print(parents);
            child.close();

        }

    }



}