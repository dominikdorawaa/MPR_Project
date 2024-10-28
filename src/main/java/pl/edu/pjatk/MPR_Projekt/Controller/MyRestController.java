package pl.edu.pjatk.MPR_Projekt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.MPR_Projekt.Model.Piesek;
import pl.edu.pjatk.MPR_Projekt.Service.PiesekService;
import pl.edu.pjatk.MPR_Projekt.Service.StringUtilsService;

import java.util.List;
import java.util.Optional;

@RestController
public class MyRestController {
    private PiesekService piesekService;


    @Autowired
    public MyRestController(PiesekService piesekService) {
        this.piesekService = piesekService;
    }

    @GetMapping("piesek/all")
    public List<Piesek> getAll() {
        return piesekService.getPiesekList();
    }

    @GetMapping("piesek/{id}")
    public Optional<Piesek> getById(@PathVariable int id) {
        return this.piesekService.getById(id);
    }

    @GetMapping("piesek/name/{name}")
    public List<Piesek> getByName(@PathVariable String name) {
        return this.piesekService.getPiesekByName(name);
    }

    @GetMapping("piesek/{id}/identyfikator")
    public long getIdentifier(@PathVariable int id) {
        Optional<Piesek> piesek = this.piesekService.getById(id);
        return piesek.map(Piesek::getIdentyfikator).orElseThrow(() -> new RuntimeException("Piesek nie odnaleziony ;("));
    }

    @PostMapping("/piesek/add")
    public void create(@RequestBody Piesek piesek) {
        this.piesekService.createPiesek(piesek);
    }
    @DeleteMapping("/piesek/id/{id}")
    public void delete(@PathVariable int id) {
        this.piesekService.deletePiesekById(id);
    }
    @DeleteMapping("/piesek/name/{name}")
    public void delete(@PathVariable String name) {
        this.piesekService.removePiesekByName(name);
    }

    @PutMapping("piesek/update/{id}")
    public void update(@PathVariable int id, @RequestBody Piesek piesek) {
        this.piesekService.updatePiesek(id, piesek);



}

}
