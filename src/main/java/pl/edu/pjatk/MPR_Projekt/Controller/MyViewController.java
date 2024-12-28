package pl.edu.pjatk.MPR_Projekt.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.MPR_Projekt.Model.Piesek;
import pl.edu.pjatk.MPR_Projekt.Service.PiesekService;
import pl.edu.pjatk.MPR_Projekt.exception.PiesekNotFoundException;

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


//to do: poprawic addForm i editForm + testy
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



    @GetMapping("/editForm/{name}")
    public String displayEditForm(@PathVariable String name, Model model) {
        Piesek piesek = (Piesek) this.piesekService.getPiesekByName(name);
        model.addAttribute("piesek", piesek);
        return "editForm";
    }


    @PostMapping("/editForm/{name}")
    public String updateForm(@PathVariable String name, @ModelAttribute Piesek piesek) {
        this.piesekService.updatePiesek(name, piesek);
        return "redirect:/view/all";
    }


    @GetMapping("/deleteForm/{id}")
    public String deleteForm(@PathVariable int id) {
        this.piesekService.deletePiesekById(id);
      return "redirect:/view/all";


    }
}
