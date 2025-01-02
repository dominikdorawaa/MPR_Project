package pl.edu.pjatk.MPR_Projekt.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAllPage {
    private WebDriver webDriver;


    @FindBy(id = "h1")
    private WebElement header;


    public ViewAllPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getHeaderText() {
        return this.header.getText();
    }

    public ViewAllPage open() {
        this.webDriver.get("http://localhost:8082/view/all");
        return this;
    }

    }



