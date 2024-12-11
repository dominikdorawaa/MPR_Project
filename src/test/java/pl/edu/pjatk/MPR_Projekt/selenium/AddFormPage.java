package pl.edu.pjatk.MPR_Projekt.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddFormPage {
    WebDriver webDriver;


    @FindBy(id = "name")
    WebElement nameInput;

    @FindBy(id = "color")
    WebElement colorInput;

    @FindBy(id = "submit")
    WebElement submitButton;

    public AddFormPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public AddFormPage open() {
        this.webDriver.get("http://localhost:8080/addForm");
        return this;
    }

    public AddFormPage fillName(String string) {
        this.nameInput.sendKeys(string);
        return this;
    }

    public AddFormPage submitForm() {
        this.colorInput.click();
        return this;
    }

    public AddFormPage fillColor(String string) {
        this.colorInput.sendKeys(string);
        return this;
    }
}
