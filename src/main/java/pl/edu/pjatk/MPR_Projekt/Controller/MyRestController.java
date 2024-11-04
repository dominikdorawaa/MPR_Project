package pl.edu.pjatk.MPR_Projekt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <List<Piesek>> getAll() {
        return new ResponseEntity<>(this.piesekService.getPiesekList(), HttpStatus.OK);
    }

    @GetMapping("piesek/{id}")
    public  ResponseEntity <Piesek> getById(@PathVariable int id) {
        return new ResponseEntity<>(this.piesekService.getById(id), HttpStatus.OK);
    }

    @GetMapping("piesek/name/{name}")
    public ResponseEntity <List<Piesek>> getByName(@PathVariable String name) {
        return new ResponseEntity<>(this.piesekService.getPiesekByName(name), HttpStatus.OK);
    }

    @GetMapping("piesek/{id}/identyfikator")
    public long  getIdentifier(@PathVariable int id) {
        Piesek piesek = this.piesekService.getById(id);
        return piesek.getIdentyfikator();
    }

    @PostMapping("/piesek/add")
    public ResponseEntity<Piesek> create(@RequestBody Piesek piesek) {
        this.piesekService.createPiesek(piesek);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/piesek/id/{id}")
    public ResponseEntity<Piesek> delete(@PathVariable int id) {
        this.piesekService.deletePiesekById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/piesek/name/{name}")
    public ResponseEntity<Piesek> delete(@PathVariable String name) {
        this.piesekService.removePiesekByName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("piesek/update/{id}")
    public ResponseEntity<Piesek> update(@PathVariable int id, @RequestBody Piesek piesek) {
        this.piesekService.updatePiesek(id, piesek);
return new ResponseEntity<>(HttpStatus.OK);

}

}
