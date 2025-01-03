package pl.edu.pjatk.MPR_Projekt.selenium;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.edu.pjatk.MPR_Projekt.Model.Piesek;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class DeleteFormTest {

    WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        this.webDriver = new ChromeDriver();
    }


    @Test
    public void testDeleteForm() {
        DeleteFormPage deleteFormPage = new DeleteFormPage(webDriver);
        int idToDelete = 1;
        deleteFormPage
                .open(idToDelete)
                .submitForm();


        String pageSource = webDriver.getPageSource();
        assertFalse(pageSource.contains("ID: " + idToDelete), "Usunięty piesek nadal istnieje na stronie.");
    }
}
