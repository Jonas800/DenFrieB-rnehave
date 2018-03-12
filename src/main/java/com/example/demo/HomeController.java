package com.example.demo;

<<<<<<< HEAD

=======
>>>>>>> faf1034f97e242304ec8548460676a9f82a12ed4
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



    @GetMapping("/OpretBarn")
    public String OpretBarn(Model model) {
        model.addAttribute("child", new Child());
        return "OpretBarn";
    }




    @PostMapping("/OpretBarn")
    public String OpretBarn(@ModelAttribute("child") Child child) throws IOException {
=======
    @GetMapping("/")
    public String Visbarn(Model model) {
        model.addAttribute("barnArray", barnArray);

        return "Visbarn";
    }
>>>>>>> faf1034f97e242304ec8548460676a9f82a12ed4

    @GetMapping()

<<<<<<< HEAD
        child.setId(id);
        barnArray.add(child);
        FileWriter fileWriter = new FileWriter(new File("child.txt"));
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (Child c : barnArray){
            printWriter.print(c);

        }
        printWriter.close();
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
    public String editChild(@ModelAttribute Child child){
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

    @PostMapping("/vis")
    public String visBarn(@ModelAttribute Child child){
        for(Child c: barnArray) {
            return "c";
        }
        return "vis";
=======
    public String TilmeldBarn(Model model) {
        model.addAttribute("barn", new Barn());
        return "TilmeldBarn";

>>>>>>> faf1034f97e242304ec8548460676a9f82a12ed4
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

