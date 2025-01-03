package pl.edu.pjatk.MPR_Projekt.selenium;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        String pageSource = webDriver.getPageSource();
        assertTrue(pageSource.contains("innaNazwa"), "Nowa nazwa pieska nie została poprawnie zapisana.");
        assertTrue(pageSource.contains("innyKolor"), "Nowy kolor pieska nie został poprawnie zapisany.");
    }
}
