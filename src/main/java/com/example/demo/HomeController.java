package com.example.demo;


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

    @GetMapping("/")
    public String OpretBarn(Model model) {
        model.addAttribute("child", new Child());
        return "ledernsmenu";
    }




    @PostMapping("/OpretBarn")
    public String OpretBarn(@ModelAttribute("child") Child child) throws IOException {

        int id = children.size() + 1;

        child.setId(id);
        children.add(child);
        FileWriter fileWriter = new FileWriter(new File("child.txt"));
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (Child c : children){
            printWriter.print(c);

        }
        printWriter.close();
        return "redirect:/";
    }
}
