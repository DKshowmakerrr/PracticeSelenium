package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class textBoxPage extends baseTest {

    //element của các label
    @FindBy(xpath ="//label[text()='Full Name :']")
    public WebElement fullNameLabel;

    @FindBy(xpath ="//label[text()='Email :']")
    public WebElement emailLabel;

    @FindBy(xpath ="//label[text()='Current Address :']")
    public WebElement currentAddressLabel;

    @FindBy(xpath ="//label[text()='Password']")
    public WebElement passwordLabel;

    //element của các input
    @FindBy(id = "fullname")
    public WebElement fullNameInput;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "address")
    public WebElement currentAddressInput;

    @FindBy(id = "password")
    public WebElement passwordInput;


    // thiet lap page factory
    public void elementPageFactory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
