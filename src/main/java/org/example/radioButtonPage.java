package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class radioButtonPage extends baseTest {

    //element của các radio button
    @FindBy(xpath = "//input[@id='yes']")
    public WebElement yesRadioButton;



    // thiet lap page factory
    public void elementPageFactory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
