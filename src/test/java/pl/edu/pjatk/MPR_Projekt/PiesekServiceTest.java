package pl.edu.pjatk.MPR_Projekt;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.edu.pjatk.MPR_Projekt.Model.Piesek;
import pl.edu.pjatk.MPR_Projekt.Repository.PiesekRepository;
import pl.edu.pjatk.MPR_Projekt.Service.PiesekService;
import pl.edu.pjatk.MPR_Projekt.Service.StringUtilsService;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PiesekServiceTest {

    private PiesekService piesekService;
    private StringUtilsService stringUtilsService;
    private PiesekRepository piesekRepository;


    @BeforeEach
    public void setup() {
        this.stringUtilsService = Mockito.mock(StringUtilsService.class);
        this.piesekRepository = Mockito.mock(PiesekRepository.class);
        this.piesekService = new PiesekService(piesekRepository, stringUtilsService);
    }

    @Test
    public void createSetsPiesekToUpperCase() {
       Piesek piesek = new Piesek("brown","donii",213);


        this.piesekService.createPiesek(piesek);
        verify(stringUtilsService, times(2)).upper(any());
        verify(piesekRepository, times(1)).save(any());
    }


}
