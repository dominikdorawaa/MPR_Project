package pl.edu.pjatk.MPR_Projekt.Service;

import org.springframework.stereotype.Component;
import pl.edu.pjatk.MPR_Projekt.Model.Piesek;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PiesekService {

    List<Piesek> piesekList = new ArrayList<>();

    public PiesekService() {
        piesekList.add(new Piesek("brown", "Spike", 1));
        piesekList.add(new Piesek("red", "Doggy", 2));
        piesekList.add(new Piesek("orange", "Leo", 3));
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

