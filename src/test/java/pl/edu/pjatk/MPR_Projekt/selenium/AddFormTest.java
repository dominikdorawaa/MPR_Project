package pl.edu.pjatk.MPR_Projekt.selenium;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddFormTest {

    WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        this.webDriver = new ChromeDriver();
    }

    @Test
    public void testAddForm() {
        AddFormPage addFormPage = new AddFormPage(webDriver);
        addFormPage
                .open()
                .fillName("TestPiesek")
                .fillColor("blue")
                .submitForm();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        assertTrue(webDriver.getPageSource().contains("TestPiesek"), "Dodany piesek nie został znaleziony na stronie.");
    }


}
