package pl.edu.pjatk.MPR_Projekt.Service;

import org.springframework.stereotype.Component;
import pl.edu.pjatk.MPR_Projekt.Model.Piesek;

import java.util.ArrayList;
import java.util.List;

@Component
public class PiesekService {

    List<Piesek> piesekList = new ArrayList<>();

    public PiesekService() {
        piesekList.add(new Piesek("brown", "Spike"));
        piesekList.add(new Piesek("red", "Doggy"));
        piesekList.add(new Piesek("orange", "Leo"));
    }

    public List<Piesek> getPiesekList() {
        return piesekList;
    }
public void createPiesek(Piesek piesek) {
        piesekList.add(piesek);
}



}
