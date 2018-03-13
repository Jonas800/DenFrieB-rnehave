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
            s = c.toString() + "\r\n";
        }
        ps.print(s);
        ps.close();
        return "redirect:/";
    }


    @GetMapping("/edit")
    public String editChild(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        int chooseChildId = 0;
        for (int i = 0; i < barnArray.size(); i++) {
            if (barnArray.get(i).getId() == id) {
                chooseChildId = i;
            }
        }

        model.addAttribute("barn", barnArray.get(chooseChildId));
        return "edit";
    }

    @PostMapping("/edit")
    public String editChild(@ModelAttribute Barn barn, int id) throws IOException {
        FileWriter fileupdater= new FileWriter("src/main/resources/child.txt");
        for (int i = 0; i < barnArray.size(); i++) {
            if (barn.getId() == id) {
                barn.set
                barnArray.get(barnArray.size() -1).getId();


                break;
            } else {
                System.out.println("Ã˜nsket barn findes ikke i vores system");
            }

        }
        return "redirect";
    }
}
 /*   @GetMapping("/loginside")
    public String loginSide(Model model){
        model.addAttribute("barnArray", barnArray);

        return "loginside";
    }

    @PostMapping(@ModelAttribute )

*/