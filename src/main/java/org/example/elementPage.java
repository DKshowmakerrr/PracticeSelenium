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
    private WebDriver driver;

    @FindBy(xpath ="//a[@href='/shop']")
    public WebElement bookStoreApplication;

    public void elementPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @BeforeClass
    public void openPage() {
        setBrowser("chrome", "https://shop.mercatus.com");
        driver = getDriver();
        elementPageFactory(driver);
    }

   /* @BeforeMethod
    public void waitForElement() {
        scrollPage();
    }*/

    @Test
    public void getTitle() {
        Assert.assertEquals(driver.getTitle(), "DemoQA");
    }

    @Test
    public void clickBookStoreApplication() throws InterruptedException {
        clickElement(bookStoreApplication);
    }



    @AfterClass
    public void closeHomePage() {
        closeBrowser();
    }
}
