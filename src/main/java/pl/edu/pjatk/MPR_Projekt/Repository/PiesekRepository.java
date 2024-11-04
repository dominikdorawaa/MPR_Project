package pl.edu.pjatk.MPR_Projekt.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjatk.MPR_Projekt.Model.Piesek;

import java.util.List;


@Repository
public interface PiesekRepository extends CrudRepository<Piesek, Integer> {
    public List<Piesek> findByName(String name);


}
