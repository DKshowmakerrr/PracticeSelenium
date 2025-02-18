package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class alertPage extends baseTest {

    //element cua cac button
    @FindBy(xpath = "//button[@onclick='showAlert()']")
    public WebElement alertButton;

    @FindBy(xpath = "//button[@onclick='myPromp()']")
    public WebElement click4MeButton;


    // thiet lap page factory
    public void elementPageFactory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
