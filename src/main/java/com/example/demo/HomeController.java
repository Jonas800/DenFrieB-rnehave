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
import java.util.ArrayList;

@Controller
public class HomeController {
    ArrayList<Barn> barnArray = new ArrayList<>();

    @GetMapping("/")
    public String ledernsMenu(Model model) {
        model.addAttribute("barnArray", barnArray);

        return "ledernsMenu";
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
    @GetMapping("/edit")
    public String editChild(@RequestParam(value = "id", defaultValue = "1") int id, Model model){
        int chooseChildId = 0;
        for(int i = 0; i < barnArray.size(); i++) {
            if (barnArray.get(i).getId() == id) {
                chooseChildId = i;
            }
        }

        model.addAttribute("child", barnArray.get(chooseChildId));
        return "edit";
    }

    @PostMapping("/edit")
    public String editChild(@ModelAttribute Barn child){
        for(int i = 0; i < barnArray.size(); i++){
            if(child.getId() == barnArray.get(i).getId()){
                barnArray.set(i, child);
                break;
            }else{
                System.out.println("Ønsket barn findes ikke i vores system");
            }

        }
        return "redirect";
    }
}
