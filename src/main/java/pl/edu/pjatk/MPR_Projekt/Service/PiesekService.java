package pl.edu.pjatk.MPR_Projekt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pjatk.MPR_Projekt.Model.Piesek;
import pl.edu.pjatk.MPR_Projekt.Repository.PiesekRepository;
import pl.edu.pjatk.MPR_Projekt.exception.PiesekAlreadyExistException;
import pl.edu.pjatk.MPR_Projekt.exception.PiesekNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PiesekService {
    private PiesekRepository piesekRepository;
    private StringUtilsService stringUtilsService;
    List<Piesek> piesekList = new ArrayList<>();

    @Autowired
    public PiesekService(PiesekRepository repository, StringUtilsService stringUtilsService) {
        this.piesekRepository = repository;

        piesekRepository.save(new Piesek("brown", "Spike", 1));
        piesekRepository.save(new Piesek("red", "Doggy", 2));
        piesekRepository.save(new Piesek("orange", "Leo", 3));
    }

    public List<Piesek> getPiesekByName(String name) {
        List<Piesek> piesek = this.piesekRepository.findByName(name);
        if (piesek.isEmpty()) {
            throw new PiesekNotFoundException();
        }
        return piesekRepository.findByName(name);
    }


    public List<Piesek> getPiesekList() {
        List<Piesek> piesek = (List<Piesek>) this.piesekRepository.findAll();
        if (piesek.isEmpty()) {
            throw new PiesekNotFoundException();
        }
        return (List<Piesek>) piesekRepository.findAll();
    }

    public void createPiesek(Piesek piesek) {
        piesek.obliczIdentyfikator();
        List<Piesek> pieski = this.piesekRepository.findByIdentyfikator(piesek.getIdentyfikator());
        if (!pieski.isEmpty()) {
            throw new PiesekAlreadyExistException();
        }
        //sprawdz czy pola sa nie puste
        piesekRepository.save(piesek);
    }

    public void deletePiesekById(int id) {
        Optional<Piesek> piesek = piesekRepository.findById(id);
        if (piesek.isEmpty()) {
            throw new PiesekNotFoundException();
        }
        piesekRepository.deleteById(id);
    }

//    Optional<Piesek> piesek = piesekRepository.findById(id);
//    if (piesek.isPresent()) {
//        piesekRepository.deleteById(id);
//    } else {
//        throw new IllegalArgumentException("Piesek o ID" + id + " nie istnieje");
//    }

    public void removePiesekByName(String name) {
        List<Piesek> pieski = piesekRepository.findByName(name);
        if (pieski.isEmpty()) {
            throw new PiesekNotFoundException();
        }
        for (Piesek piesek : pieski) {
            piesekRepository.delete(piesek);
        }
    }


    public Piesek getById(int id) {
        Optional<Piesek> piesek = this.piesekRepository.findById(id);
        if (piesek.isEmpty()) {
            throw new PiesekNotFoundException();
        }
        return piesek.get();
    }

//    public void updatePiesek(int id, piesek ) {
//       Optional<Piesek> existingPiesek = piesekRepository.findById(piesek.getId());
//       if(existingPiesek.isPresent()){
//        piesekRepository.save(piesek);
//        } else {
//           throw new IllegalArgumentException("Piesek o ID juz istnieje");
//       }
//    }


    public void updatePiesek(int id, Piesek updatedPiesek) {
        Optional<Piesek> existingPiesek = piesekRepository.findById(id);
        if (existingPiesek.isPresent()) {
            Piesek piesek = existingPiesek.get();
            piesek.setName(updatedPiesek.getName());
            piesek.setColor(updatedPiesek.getColor());
            piesekRepository.save(piesek);
        } else {
            throw new PiesekNotFoundException();
        }
    }

}

