package pl.edu.pjatk.MPR_Projekt.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditFormPage {
    WebDriver webDriver;

    @FindBy(id = "name")
    WebElement nameInput;

    @FindBy(id = "color")
    WebElement colorInput;
    @FindBy(id = "submit")
    WebElement submitButton;

    public EditFormPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public EditFormPage open(int id) {
        this.webDriver.get("http://localhost:8082/editForm/" + id);
        return this;
    }

    public EditFormPage editName(String string) {
        this.nameInput.clear();
        this.nameInput.sendKeys(string);
        return this;
    }

    public EditFormPage editColor(String string) {
        this.colorInput.clear();
        this.colorInput.sendKeys(string);
        return this;
    }

    public EditFormPage submitForm() {
        this.submitButton.click();
        return this;
    }
}
