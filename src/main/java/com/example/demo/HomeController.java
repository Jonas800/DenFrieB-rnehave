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
import java.io.PrintWriter;
import java.util.ArrayList;

@Controller
public class HomeController {
    ArrayList<Barn> barnArray = new ArrayList<>();

<<<<<<< HEAD
    @GetMapping("/")
    public String ledernsmenu() {

        return "ledernsmenu";


    }

    @GetMapping("/Visbarn")
=======
    @GetMapping("/OpretBarn")
    public String OpretBarn(Model model) {
        model.addAttribute("child", new Child());
        return "OpretBarn";
    }




    @PostMapping("/OpretBarn")
    public String OpretBarn(@ModelAttribute("child") Child child) throws IOException {

    @GetMapping("/")
>>>>>>> d8e3f32f9525337dfc0f9fcc0b0233c14a7c8e40
    public String Visbarn(Model model) {
        model.addAttribute("barnArray", barnArray);
        return "Visbarn";
    }

    @GetMapping("/TilmeldBarn")
    public String TilmeldBarn(Model model) {
        model.addAttribute("barn", new Barn());
        return "TilmeldBarn";

<<<<<<< HEAD
    }

    @PostMapping("/TilmeldBarn")
    public String TilmeldBarn(@ModelAttribute Barn barn) throws IOException {
        int id = barnArray.size() + 1;

        barn.setId(id);
        barnArray.add(barn);
        FileWriter fileWriter = new FileWriter(new File("child.txt"));
        for (Barn c : barnArray) {
            fileWriter.write(c + "\n");
=======

        child.setId(id);
        barnArray.add(child);
        FileWriter fileWriter = new FileWriter(new File("child.txt"));
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (Child c : barnArray){
            printWriter.print(c);
>>>>>>> d8e3f32f9525337dfc0f9fcc0b0233c14a7c8e40

        }
        fileWriter.close();
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editChild(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        int chooseChildId = 0;
<<<<<<< HEAD
        for (int i = 0; i < barnArray.size(); i++) {
=======
        for(int i = 0; i < barnArray.size(); i++) {
>>>>>>> d8e3f32f9525337dfc0f9fcc0b0233c14a7c8e40
            if (barnArray.get(i).getId() == id) {
                chooseChildId = i;
            }
        }

<<<<<<< HEAD
        model.addAttribute("barn", barnArray.get(chooseChildId));
=======
        model.addAttribute("child", barnArray.get(chooseChildId));
>>>>>>> d8e3f32f9525337dfc0f9fcc0b0233c14a7c8e40
        return "edit";
    }

    @PostMapping("/edit")
<<<<<<< HEAD
    public String editChild(@ModelAttribute Barn barn) {
        for (int i = 0; i < barnArray.size(); i++) {
            if (barn.getId() == barnArray.get(i).getId()) {
                barnArray.set(i, barn);
=======
    public String editChild(@ModelAttribute Child child){
        for(int i = 0; i < barnArray.size(); i++){
            if(child.getId() == barnArray.get(i).getId()){
                barnArray.set(i, child);
>>>>>>> d8e3f32f9525337dfc0f9fcc0b0233c14a7c8e40
                break;
            } else {
                System.out.println("Ønsket barn findes ikke i vores system");
            }

        }
        return "redirect";
    }
<<<<<<< HEAD
=======

    @PostMapping("/vis")
    public String visBarn(@ModelAttribute Child child){
        for(Child c: barnArray) {
            return "c";
        }
        return "vis";

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
>>>>>>> d8e3f32f9525337dfc0f9fcc0b0233c14a7c8e40
}
