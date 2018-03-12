package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.io.*;

@Controller
public class HomeController extends Child {
    ArrayList<Child> children = new ArrayList<>();




    @GetMapping("/OpretBarn")
    public String OpretBarn(Model model) {
        model.addAttribute("child", new Child());
        return "OpretBarn";
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


   @GetMapping("/edit")
    public String editChild(@RequestParam(value = "id", defaultValue = "1") int id, Model model){
        int chooseChildId = 0;
        for(int i = 0; i < children.size(); i++) {
            if (children.get(i).getId() == id) {
                chooseChildId = i;
            }
          }

        model.addAttribute("child", children.get(chooseChildId));
        return "edit";
    }

    @PostMapping("/edit")
    public String editChild(@ModelAttribute Child child){
        for(int i = 0; i < children.size(); i++){
            if(child.getId() == children.get(i).getId()){
                children.set(i, child);
                break;
            }else{
                System.out.println("Ønsket barn findes ikke i vores system");
            }

        }
        return "redirect";
    }

    @PostMapping("/vis")
    public String visBarn(@ModelAttribute Child child){
        for(Child c: children) {
            return "c";
        }
        return "vis";
    }


}