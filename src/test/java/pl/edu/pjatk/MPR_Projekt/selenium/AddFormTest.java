package pl.edu.pjatk.MPR_Projekt.selenium;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddFormTest {

    WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        this.webDriver = new ChromeDriver();
    }

    @Test
    public void testAddForm(){
    AddFormPage addFormPage = new AddFormPage(webDriver);
    addFormPage
            .open()
            .fillName("piesek")
            .fillColor("blue")
            .submitForm();
    }
}
