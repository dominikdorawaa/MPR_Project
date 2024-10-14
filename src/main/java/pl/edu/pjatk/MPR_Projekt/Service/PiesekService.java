package pl.edu.pjatk.MPR_Projekt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pjatk.MPR_Projekt.Model.Piesek;
import pl.edu.pjatk.MPR_Projekt.Repository.PiesekRepository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PiesekService {
private PiesekRepository piesekRepository;

    List<Piesek> piesekList = new ArrayList<>();

@Autowired
    public PiesekService(PiesekRepository repository) {
    this.piesekRepository = repository;

        piesekList.add(new Piesek("brown", "Spike", 1));
        piesekList.add(new Piesek("red", "Doggy", 2));
        piesekList.add(new Piesek("orange", "Leo", 3));
    }

    public List<Piesek> getPiesekByName (String name) {
    return piesekRepository.findByName(name);
    }


    public List<Piesek> getPiesekList() {
        return piesekList;
    }

    public void createPiesek(Piesek piesek) {
        piesekList.add(piesek);
    }

    public void removePiesekById(int id) {
        piesekList.removeIf(piesek -> piesek.getId() == id);
    }

    public Piesek get(int id) {
        return piesekList.stream()
                .filter(piesek -> piesek.getId() == id)
                .findFirst()
                .orElse(null);
    }

public Optional<Piesek> getItemById(int id) {
    return this.piesekRepository.findById(id);
}


    public void updatePiesek(Piesek piesek) {
        for (int i = 0; i < piesekList.size(); i++) {
            if (piesekList.get(i).getId() == piesek.getId()) {
                piesekList.get(i).setColor(piesek.getColor());
                piesekList.get(i).setName(piesek.getName());
                return;
            }


        }
    }
}

