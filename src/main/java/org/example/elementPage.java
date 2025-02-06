package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class elementPage extends baseTest {
    public WebDriver driver;

    //element của các label
    @FindBy(xpath ="//label[text()='Full Name :']")
    public WebElement fullNameLabel;

    @FindBy(xpath ="//label[text()='Email :']")
    public WebElement emailLabel;

    @FindBy(xpath ="//label[text()='Current Address :']")
    public WebElement currentAddressLabel;

    @FindBy(xpath ="//label[text()='Password']")
    public WebElement passwordLabel;

    /*cookie
    @FindBy(xpath ="//button[@class='cookie-consent__accept-button']")
    public WebElement cookieButton;*/

    // thiet lap page factory
    public void elementPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @BeforeClass
    public void openPage() {
        setBrowser("chrome", "https://www.tutorialspoint.com/selenium/practice/text-box.php");
        driver = getDriver();
        elementPageFactory(driver);
        //cookieButton.click();
    }

    @AfterClass
    public void closeHomePage() {
        closeBrowser();
    }
}
