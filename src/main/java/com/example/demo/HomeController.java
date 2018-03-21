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
import java.util.Random;
import java.util.Scanner;

@Controller
public class HomeController {
    ArrayList<Barn> barnArray = getBarnArray();
    ArrayList<Medarbejder>MedarbejderArray= new ArrayList<>();
    int barnId = 0;
    int medArbejderId = 0;
    public HomeController() throws FileNotFoundException {
    }

    @GetMapping("/")
    public String ledernsmenu(Model model) {
        model.addAttribute("barnArray", barnArray);

        return "ledernsmenu";
    }
      @GetMapping("/Medarbejdere")
    public String Medarbejder(Model model) {
        model.addAttribute("MedarbejderArray", MedarbejderArray);

        return "Medarbejdere";
    }


    @GetMapping("/tilføjMA")
    public String Medarbejdere(Model model) {
        model.addAttribute("medarbejder", new Medarbejder());


        return "tilføjMA";
    }


    @PostMapping("/tilføjMA")
    public String Medarbejdere(@ModelAttribute Medarbejder medarbejder) throws FileNotFoundException {
        int ID = MedarbejderArray.size() + 1;

        medarbejder.setId(ID);
        MedarbejderArray.add(medarbejder);
        medArbejderToFile(MedarbejderArray);

        return "redirect:/";
    }

    @GetMapping("/editEMP")
    public String editEmp(@RequestParam(value = "ID", defaultValue = "1")int ID, Model model){
        if(model != null){
            model.addAttribute("medarbejder", MedarbejderArray.get(ID-1));
        }
        medArbejderId = ID;
        return "editEMP";
    }

    @PostMapping("/editEMP")
    public String editEmp(@ModelAttribute Medarbejder medarbejder) throws FileNotFoundException{
        medarbejder.setId(medArbejderId);
        MedarbejderArray.set(medArbejderId - 1, medarbejder);
        medArbejderToFile(MedarbejderArray);

        return "redirect:/";
    }
    @GetMapping("/Sletansat")
    public String Sletansat(@RequestParam(value = "ID", defaultValue = "0") int ID) throws FileNotFoundException {
        MedarbejderArray.remove(ID - 1);
        medArbejderToFile(MedarbejderArray);
        return "redirect:/";
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
        saveToFile(barnArray);

        return "redirect:/";
    }

    @GetMapping("/Visbarn")
    public String Visbarn(Model model) {
        model.addAttribute("barnArray", barnArray);
        return "Visbarn";
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
    public String editChild(@ModelAttribute Barn barn) throws FileNotFoundException{
        barn.setId(barnId);
        barnArray.set(barnId - 1, barn);
        saveToFile(barnArray);
        return "redirect:/";
    }

    @GetMapping("/SletBarn")
    public String sletChild(@RequestParam(value = "id", defaultValue = "0") int id) throws FileNotFoundException{
        barnArray.remove(id-1);
        saveToFile(barnArray);
        return "redirect:/Visbarn";
    }

    public static void saveToFile(ArrayList<Barn> barnArray) throws FileNotFoundException{
        PrintStream ps = new PrintStream(new File("src/main/resources/child.txt"));

        String s = "";
        for (Barn c : barnArray) {
            s += c.toString() + "\r\n";
        }
        ps.print(s);
        ps.close();


    }


    public static void medArbejderToFile(ArrayList<Medarbejder> MedarbejderArray) throws FileNotFoundException{
        PrintStream stream = new PrintStream(new File("src/main/resources/medarbejder.txt"));
        String e = "";

        for(Medarbejder m: MedarbejderArray){
            e += m.toString() + "\r\n";
        }
        stream.print(e);
        stream.close();
    }



    public ArrayList<Barn> getBarnArray() throws FileNotFoundException {
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
                saveToFile(barnArrayList);

            }
        } catch (FileNotFoundException e) {
        } finally {
            return barnArrayList;
        }
    }
}