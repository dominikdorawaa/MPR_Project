package pl.edu.pjatk.MPR_Projekt.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import pl.edu.pjatk.MPR_Projekt.Model.Piesek;
import pl.edu.pjatk.MPR_Projekt.exception.PiesekAlreadyExistException;
import pl.edu.pjatk.MPR_Projekt.exception.PiesekNotFoundException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class PiesekService {

    private final RestClient restClient;


    public PiesekService() {

        this.restClient = RestClient.create("http://localhost:8081/");
    }


    public List<Piesek> getPiesekList() {
        try{
        List<Piesek> piesekList = restClient.get()
                .uri("piesek/all")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
            if (piesekList == null || piesekList.isEmpty()) {
                System.out.println("baza jest pusta");
            }
            return piesekList;
        } catch (Exception e) {
            throw new PiesekNotFoundException();
        }
    }



    public List<Piesek> getPiesekByName(String name) {
        try {
        List<Piesek>  piesekList = restClient.get()
                .uri("piesek/name/" + name)
                .retrieve()
                .body(new ParameterizedTypeReference<List<Piesek>>() {
                });
        if (piesekList == null || piesekList.isEmpty()) {
            throw new PiesekNotFoundException();
        }
        return piesekList;
        } catch (Exception e) {
            throw new PiesekNotFoundException();
        }
    }


    //to do: poprawic metode create(dodawnie) i update(edytowanie)
    public void createPiesek(Piesek piesek) {
        try {
            System.out.println("Wysyłanie JSON-a: " + new ObjectMapper().writeValueAsString(piesek));
            restClient.post()
                    .uri("/piesek/add")
                    .contentType(APPLICATION_JSON)
                    .body(piesek)
                    .retrieve()
                    .toBodilessEntity();
        } catch (Exception e) {
            System.out.println("Błąd przy dodawaniu pieska: " + e.getMessage());
            e.printStackTrace();
            throw new PiesekAlreadyExistException();
        }
    }


    public void updatePiesek(String name, Piesek updatedPiesek) {
        try {
            restClient.put()
                    .uri("/piesek/update/" + name)
                    .body(updatedPiesek)
                    .retrieve()
                    .toBodilessEntity();
        } catch (Exception e) {
            throw new PiesekNotFoundException();
        }
    }

    public void deletePiesekById(int id) {
        try {
            restClient.delete()
                    .uri("/piesek/id/{id}", id)
                    .retrieve()
                    .toBodilessEntity();
        } catch (Exception e) {
            throw new PiesekNotFoundException();
        }
    }

    public ByteArrayResource generatePdf(Piesek piesek) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.setLeading(14.5f);

        contentStream.beginText();

        contentStream.newLineAtOffset(50, 750);

        contentStream.showText("Name: " + piesek.getName());
        contentStream.newLine();

        contentStream.showText("Color: " + piesek.getColor());
        contentStream.newLine();

        contentStream.endText();
        contentStream.close();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        document.save(byteArrayOutputStream);
        document.close();

        return new ByteArrayResource(byteArrayOutputStream.toByteArray());
    }


}

