package pl.edu.pjatk.MPR_Projekt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.MPR_Projekt.Model.Piesek;
import pl.edu.pjatk.MPR_Projekt.Service.PiesekService;

import java.util.List;
@RestController
public class MyRestController {
    private PiesekService piesekService;

    @Autowired
    public MyRestController(PiesekService piesekService) {
        this.piesekService = piesekService;
    }

    @GetMapping("piesek/all")
    public List<Piesek> getAll() {
        return this.piesekService.getPiesekList();
    }

    @GetMapping("piesek/id")
    public List<Piesek> get(@PathVariable int id) {
        return this.piesekService.get(id);
    }

    @PostMapping("piesek")
    public void create(@RequestBody Piesek piesek) {
        this.piesekService.createPiesek(piesek);
    }
}
