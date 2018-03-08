package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    ArrayList<Child> children = new ArrayList<>();

    @GetMapping("/")
    public String children() {
        return "boern";
    }

    @GetMapping("/edit")
    public String rediger(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        int børnID = 0;
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getId() == id) {
                børnID = i;
            }
        }
        model.addAttribute("child", children.get(børnID));
        return "edit";
    }
}