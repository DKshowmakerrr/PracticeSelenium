package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class radioButtonPage extends baseTest {

    //element của các radio button
    @FindBy(xpath = "//input[@type='radio' and @onclick='show2();']")
    public WebElement yesButton;

    @FindBy(xpath = "//input[@type='radio' and @onclick='show3();']")
    public WebElement impressiveButton;

    @FindBy(xpath = "// input[@type='radio' and @name='inlineRadioOptions']")
    public WebElement noButton;


    // thiet lap page factory
    public void elementPageFactory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
