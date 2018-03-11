package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class HomeController {
    ArrayList<Barn> barnArray = new ArrayList<>();

    @GetMapping("/")
    public String Visbarn(Model model) {
        model.addAttribute("barnArray", barnArray);

        return "Visbarn";
    }

    @GetMapping()

    public String TilmeldBarn(Model model) {
        model.addAttribute("barn", new Barn());
        return "TilmeldBarn";

    }

    @PostMapping()
    public String TilmeldBarn(@ModelAttribute Barn barn) throws IOException {
        int id = barnArray.size() + 1;

        barn.setId(id);
        barnArray.add(barn);
        FileWriter fileWriter = new FileWriter(new File("child.txt"));
        for (Barn c : barnArray){
            fileWriter.write(c + "\n");

        }
        fileWriter.close();
        return "redirect:/";
    }
}

