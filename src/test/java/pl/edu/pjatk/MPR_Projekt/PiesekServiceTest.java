package pl.edu.pjatk.MPR_Projekt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.io.ByteArrayResource;
import pl.edu.pjatk.MPR_Projekt.Model.Piesek;
import pl.edu.pjatk.MPR_Projekt.Repository.PiesekRepository;
import pl.edu.pjatk.MPR_Projekt.Service.PiesekService;
import pl.edu.pjatk.MPR_Projekt.Service.StringUtilsService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


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
        verify(stringUtilsService, times(1)).upper(any());
        verify(piesekRepository, times(1)).save(any());
    }


    @Test
    public void testGetPiesekByName(){
        when(piesekRepository.findByName("Max")).thenReturn(List.of(new Piesek("brown","Max" , 1)));

        List<Piesek> pieski = piesekService.getPiesekByName("Max");

        assertEquals(1, pieski.size());
        assertEquals("Max", pieski.get(0).getName());
    }

    @Test
    public void testGetPiesekList(){
        when(piesekRepository.findAll()).thenReturn(List.of(new Piesek("brown", "Spike", 1)));

        List<Piesek> pieski = piesekService.getPiesekList();

        assertEquals(1,pieski.size());
    }


    @Test
    public void testCreatePiesek(){
        Piesek piesek = new Piesek("brown","Bobby",1);

        when(stringUtilsService.lower(any())).thenReturn("bobby");
        when(stringUtilsService.upper(any())).thenReturn("BOBBY");

        piesekService.createPiesek(piesek);

        verify(stringUtilsService, times(1)).lower("bobby");
        verify(stringUtilsService, times(1)).upper("BOBBY");
        verify(piesekRepository, times(1)).save(any(Piesek.class));
    }

    @Test
    public void testDeletePiesekById(){
        Piesek piesek = new Piesek("brown", "Max", 1);
        when(piesekRepository.findById(1)).thenReturn(Optional.of(piesek));
        piesekService.deletePiesekById(1);
        verify(piesekRepository, times(1)).deleteById(1);
    }

    @Test
    public void testGetById() {
        Piesek piesek = new Piesek("brown", "Max", 1);
        when(piesekRepository.findById(1)).thenReturn(Optional.of(piesek));
        when(stringUtilsService.lower(any())).thenReturn("max");

        Piesek foundPiesek = piesekService.getById(1);

     assertNotNull(foundPiesek);
        assertEquals("Max", foundPiesek.getName());
        verify(stringUtilsService, times(1)).lower(any());
    }

    @Test
    public void testUpdatePiesek() {
        Piesek existingPiesek = new Piesek("brown", "Spike", 1);
        Piesek updatedPiesek = new Piesek("white", "Spike", 1);
        when(piesekRepository.findById(1)).thenReturn(Optional.of(existingPiesek));

        piesekService.updatePiesek(1, updatedPiesek);

        verify(piesekRepository, times(1)).save(existingPiesek);
        assertEquals("white", existingPiesek.getColor());
    }

@Test
    public void testGeneratePdf() throws IOException {
    Piesek piesek = new Piesek("brown", "Max", 1 );
    ByteArrayResource pdf = piesekService.generatePdf(piesek);

    assertNotNull(pdf);
    assertTrue(pdf.contentLength() > 0);
}
}
