package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

@Controller
public class HomeController {
    ArrayList<Barn> barnArray = new ArrayList<>();
    int barnId = 0;

    @GetMapping("/")
    public String ledernsmenu(Model model) {
        model.addAttribute("barnArray", barnArray);

        return "ledernsmenu";
    }

    @GetMapping("/Visbarn")
    public String Visbarn(Model model) {
        model.addAttribute("barnArray", barnArray);
        return "Visbarn";
    }

    @GetMapping("/TilmeldBarn")
    public String TilmeldBarn(Model model) {
        model.addAttribute("barn", new Barn());
        return "TilmeldBarn";

    }

    @PostMapping("/TilmeldBarn")
    public String TilmeldBarn(@ModelAttribute Barn barn) throws IOException {
        int id = barnArray.size() + 1;

        barn.setId(id);
        barnArray.add(barn);
        PrintStream ps = new PrintStream(new File("src/main/resources/child.txt"));
        String s = "";
        for (Barn c : barnArray) {
            s += c.toString() + "\r\n";
        }
        ps.print(s);
        ps.close();
        return "redirect:/";
    }


    @GetMapping("/edit")
    public String editChild(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        if (model != null) {
            model.addAttribute("barn", barnArray.get(id - 1));
        }
        barnId = id;
        return "edit";
    }

    @PostMapping("/edit")
    public String editChild(@ModelAttribute Barn barn) {
        barn.setId(barnId);
        barnArray.set(barnId - 1, barn);
        System.out.println(barn);
        return "redirect:/";
    }


}