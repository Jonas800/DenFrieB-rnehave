package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.*;
import java.io.*;
@Controller
public class HomeController {
    public static ArrayList<Parent> parents;
    @GetMapping("/")
    public String children(){
        return "boern";
    }

    @PostMapping("boern")

    public static void createChild(int id, String firstName, String lastName, ArrayList<Parent> parents
            , Date dateOfBirth, ArrayList<String> allergies, String picture) throws Exception{
        PrintStream child = new PrintStream(new File("src/Child.dat"));
        for(Parent index: parents){
            parents.add(new Parent(id, firstName, lastName, parents.size(), dateOfBirth, allergies.size(), picture));
            child.print(parents);
            child.close();

        }

    }



}