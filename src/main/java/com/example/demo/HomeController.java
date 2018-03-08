package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String rediger(int id, Model model) {
        int børnID = 0;
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getId() == id) {
                børnID = i;
            }
        }
        model.addAttribute("child", children.get(børnID));
        return "edit";
    }

    @PostMapping("/edit")
    public String rediger(@ModelAttribute Child child) {
        for (int i = 0; i < children.size(); i++) {
            if (child.getId() == children.get(i).getId()) {
                children.set(i, child);
            }
        }
        return "redirect:/";
    }
}