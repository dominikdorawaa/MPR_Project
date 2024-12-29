package pl.edu.pjatk.MPR_Projekt.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.MPR_Projekt.Model.Piesek;
import pl.edu.pjatk.MPR_Projekt.Service.PiesekService;

import java.util.List;

@Controller
public class MyViewController {

    private final PiesekService piesekService;

    public MyViewController(PiesekService piesekService) {
        this.piesekService = piesekService;
    }


    @GetMapping("/view/all")
    public String displayAllPiesek(Model model) {
            List<Piesek> piesekList = this.piesekService.getPiesekList();
        if (piesekList == null || piesekList.isEmpty()) {
            model.addAttribute("error", "Brak piesków do wyświetlenia.");
        } else {
            model.addAttribute("pieski", piesekList);
            }
        return "viewAll";
    }

    @GetMapping("/addForm")
    public String displayAddForm(Model model) {
        model.addAttribute("piesek", new Piesek());
        return "addForm";
    }

    @PostMapping("/addForm")
    public String submitForm(@ModelAttribute Piesek piesek) {
        this.piesekService.createPiesek(piesek);
        return "redirect:/view/all";
    }


    @GetMapping("/view/name/{name}")
    public String displayByName(@PathVariable String name, Model model) {
        List<Piesek> piesekList = this.piesekService.getPiesekByName(name);
        if (piesekList == null || piesekList.isEmpty()) {
            model.addAttribute("error", "Brak piesków do wyświetlenia o nazwie: " + name);
        } else {
            model.addAttribute("pieski", piesekList);
        }
        return "viewAll";
    }


    @GetMapping("/view/{id}")
    public String displayById(@PathVariable int id, Model model) {
        Piesek piesek = this.piesekService.getPiesekById(id);
        if (piesek == null) {
            model.addAttribute("error", "Brak piesków do wyświetlenia o id: " + id);
        } else {
            model.addAttribute("pieski", piesek);
        }
        return "viewAll";
    }


    //to do: testy
    @GetMapping("/editForm/{id}")
    public String displayEditForm(@PathVariable int id, Model model) {
        Piesek piesek = (Piesek) this.piesekService.getPiesekById(id);
        model.addAttribute("piesek", piesek);
        return "editForm";
    }


    @PostMapping("/editForm/{id}")
    public String updateForm(@PathVariable int id, @ModelAttribute Piesek piesek) {
        this.piesekService.updatePiesek(piesek,id);
        return "redirect:/view/all";
    }







    @GetMapping("/deleteForm/{id}")
    public String deleteForm(@PathVariable int id) {
        this.piesekService.deletePiesekById(id);
      return "redirect:/view/all";


    }
}
