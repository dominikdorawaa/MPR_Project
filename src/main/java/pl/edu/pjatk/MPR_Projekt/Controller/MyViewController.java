package pl.edu.pjatk.MPR_Projekt.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.MPR_Projekt.Model.Piesek;
import pl.edu.pjatk.MPR_Projekt.Service.PiesekService;

import java.util.List;

@Controller
public class MyViewController {

    private PiesekService piesekService;

    public MyViewController(PiesekService piesekService) {
        this.piesekService = piesekService;
    }


    @GetMapping("/view/all")
    public String displayAllPiesek(Model model) {
        model.addAttribute("piesek", "jakas wartosc");
        List<Piesek> piesekList = this.piesekService.getPiesekList();
        model.addAttribute("pieski", piesekList);
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


    @GetMapping("/editForm/{id}")
    public String displayEditForm(@PathVariable int id, Model model) {
        Piesek piesek = piesekService.getById(id);
        model.addAttribute("piesek", piesek);
        return "editForm";
    }


    @PostMapping("/editForm/{id}")
    public String updateForm(@PathVariable int id, @ModelAttribute Piesek piesek) {
        this.piesekService.updatePiesek(id, piesek);
        return "redirect:/view/all";
    }


    @GetMapping("/deleteForm/{id}")
    public String deleteForm(@PathVariable int id) {
        this.piesekService.deletePiesekById(id);
      return "redirect:/view/all";


    }
}
