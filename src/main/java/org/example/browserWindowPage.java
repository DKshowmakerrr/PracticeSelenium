package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class browserWindowPage extends baseTest {

    //element cua cac button
    @FindBy(xpath = "//button[Text()='New Tab']")
    public WebElement newTabButton;

    @FindBy(xpath = "//button[Text()='New Window']")
    public WebElement newWindowButton;

    @FindBy(xpath = "//button[Text()='New Window Message']")
    public WebElement newWMButton;


    // thiet lap page factory
    public void elementPageFactory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
