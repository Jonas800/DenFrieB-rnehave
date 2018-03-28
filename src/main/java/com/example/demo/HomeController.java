package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

@Controller
public class HomeController {
    ArrayList<Barn> barnArray = getBarnArray();
    ArrayList<Medarbejder> MedarbejderArray = GetMedarbejder();
    ArrayList<Parent>ParentArray = new ArrayList<>();
    int barnId = 0;
    int medArbejderId = 0;

    public HomeController() throws FileNotFoundException, ParseException {
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
        return "Createparent";
    }

    @GetMapping("/editEMP")
    public String editEmp(@RequestParam(value = "ID", defaultValue = "1") int ID, Model model) {
        medArbejderId = ID;
        if (model != null) {
            model.addAttribute("medarbejder", MedarbejderArray.get(ID - 1));
        }
        return "editEMP";
    }

    @PostMapping("/editEMP")
    public String editEmp(@ModelAttribute Medarbejder medarbejder) throws FileNotFoundException {
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

        return "redirect:/Createparent"; }


        @GetMapping("/Visbarn")
    public String Visbarn(Model model) {
        for (int i = 0; i <barnArray.size() ; i++) {

            if (i <= 30) {
                model.addAttribute("barnArray", barnArray.subList(0, barnArray.size()));
            }

            else
                model.addAttribute("barnArray", barnArray.subList(0,30));

        }
        return"Visbarn";
    }

    @GetMapping("/edit")
    public String editChild(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        if (model != null) {
            for (Barn barn : barnArray) {
                if (barn.getId() == id)
                    model.addAttribute("barn", barn);
            }
        }
        barnId = id;
        return "edit";
    }

    @PostMapping("/edit")
    public String editChild(@ModelAttribute Barn barn) throws FileNotFoundException {
        barn.setId(barnId);
        for (int i = 0; i < barnArray.size(); i++) {
            if (barnArray.get(i).getId() == barn.getId()) {
                barnArray.set(i, barn);
            }
        }
        saveToFile(barnArray);
        return "redirect:/";
    }

    @GetMapping("/SletBarn")
    public String sletChild(@RequestParam(value = "id", defaultValue = "0") int id) throws FileNotFoundException {
        for (int i = 0; i < barnArray.size(); i++) {
            if (barnArray.get(i).getId() == id) {
                barnArray.remove(i);
            }
        }
        saveToFile(barnArray);
        return "redirect:/Visbarn";
    }

    @GetMapping("/Venteliste")
    public String venteListe(Model model) {
        for (int i = 0; i < barnArray.size(); i++) {

            if (i >= 30) {

                model.addAttribute("barnArray", barnArray.subList(30, barnArray.size()));
            }

        }
        return "Venteliste"; }


    @GetMapping("/Createparent")
    public String Createparent(Model model) {
        model.addAttribute("parent", new Parent());
        return "Createparent";

    }

    @PostMapping("/Createparent")
    public String Createparent(@ModelAttribute Parent parent)  {
        int id = ParentArray.size() + 1;

        parent.setParentID(id);
        ParentArray.add(parent);

        return "redirect:/"; }

    @GetMapping("/Visforrældre")
    public String visforældre (Model model){
        model.addAttribute("parentArray", ParentArray);
        return "Visforældre";
    }



        public static void saveToFile(ArrayList<Barn> barnArray) throws FileNotFoundException {
        PrintStream ps = new PrintStream(new File("src/main/resources/child.txt"));

        String s = "";
        for (Barn c : barnArray) {
            s += c.toString() + "\r\n";
        }
        ps.print(s);
        ps.close();


    }



    public static void medArbejderToFile(ArrayList<Medarbejder> MedarbejderArray) throws FileNotFoundException {
        PrintStream stream = new PrintStream(new File("src/main/resources/ansatte.txt"));
        String e = "";

        for (Medarbejder m : MedarbejderArray) {
            e += m.toString() + "\r\n";
        }
        stream.print(e);
        stream.close();
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

    public ArrayList<Medarbejder> GetMedarbejder() throws FileNotFoundException {
        ArrayList<Medarbejder> medarbejderArrayList = new ArrayList<>();
        Scanner scan = new Scanner(new File("src/main/resources/ansatte.txt"));

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            Scanner readLine = new Scanner(line).useDelimiter("#");
            Medarbejder medarbejder = new Medarbejder();
            medarbejder.setId(readLine.nextInt());
            medarbejder.setFirstName(readLine.next());
            medarbejder.setLastName(readLine.next());
            medarbejder.setAddress(readLine.next());
            medarbejder.setTelephoneNumber(readLine.next());
            medarbejder.setStilling(readLine.next());
            medarbejderArrayList.add(medarbejder);

        }
        return medarbejderArrayList;
    }


}
