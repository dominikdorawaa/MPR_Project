package pl.edu.pjatk.MPR_Projekt.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteFormPage {
    WebDriver webDriver;


    @FindBy(id = "submit")
    WebElement submitButton;

    public DeleteFormPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public DeleteFormPage open(int id) {
        this.webDriver.get("http://localhost:8082/deleteForm/" + id);
        return this;
    }


    public DeleteFormPage submitForm() {
        this.submitButton.click();
        return this;
    }
}
