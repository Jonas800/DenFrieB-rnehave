package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import java.io.*;

@Controller
public class HomeController extends Child {
    ArrayList<Child> children = new ArrayList<>();

    @GetMapping
    public String createChild(Model model) {
        model.addAttribute("child", new Child());
        return "OpretBarn";
    }

    @PostMapping("/OpretBarn")
    public String createChild(@ModelAttribute("child") Child child) throws FileNotFoundException {

        int id = children.size() + 1;

        child.setId(id);
        children.add(child);
        PrintStream print = new PrintStream(new File("child.txt"));

        String s = "";
        for (Child c : children) {
            s += c.toString() + "/r/n";
        }

        print.print(s);
        print.close();
        return "OpretBarn";
    }


}