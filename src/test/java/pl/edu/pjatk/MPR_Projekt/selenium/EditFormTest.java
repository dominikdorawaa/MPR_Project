package pl.edu.pjatk.MPR_Projekt.selenium;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditFormTest {

    WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        this.webDriver = new ChromeDriver();
    }


    @Test
    public void testEditForm() {
        EditFormPage editFormPage = new EditFormPage(webDriver);
        int idToUpdate = 3;
        editFormPage
                .open(idToUpdate)
                .editName("innaNazwa")
                .editColor("innyKolor")
                .submitForm();
    }
}
