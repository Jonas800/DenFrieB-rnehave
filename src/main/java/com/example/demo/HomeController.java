package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

@Controller
public class HomeController {
    ArrayList<Barn> barnArray = getBarnArray();
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

    public ArrayList<Barn> getBarnArray() {
        ArrayList<Barn> barnArrayList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/child.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner readLine = new Scanner(line).useDelimiter("#");

                Barn barn = new Barn();
                barn.setId(readLine.nextInt());
                barn.setFirstName(readLine.next());
                barn.setLastName(readLine.next());
                barn.setFarthersName(readLine.next());
                barn.setMothersName(readLine.next());
                DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy");
                Date dateOfBirth = (df.parse(readLine.next()));
                barn.setDateOfBirth(dateOfBirth);
                barn.setAllergies(readLine.next());

                barnArrayList.add(barn);
            }
        } catch (FileNotFoundException e) {
        } finally {
            return barnArrayList;
        }
    }
}