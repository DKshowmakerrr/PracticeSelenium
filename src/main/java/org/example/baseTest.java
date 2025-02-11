package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class baseTest {
    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }
    public void setBrowser(String browser, String url) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        if (driver != null) {
            driver.manage().window().maximize();
            driver.get(url);
        }
    }
    public void waitForPageLoad() {
        if (driver!= null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public void scrollAndClick(WebElement element) throws InterruptedException {
        if (driver != null && element.isEnabled()) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", element);
            js.executeScript("arguments[0].click();", element);
            Thread.sleep(3000);
        }
    }
    //check xem label có hiển thị hay không
    public void labelIsDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            System.out.println("Label is displayed");
        } else {
            System.out.println("Label is not displayed");
        }
    }
    /*public void clickElement(WebElement element) throws Exception {
        if (element.isEnabled()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            Thread.sleep(3000);
        }
    }*/

    public void enterText(WebElement element, String text) {
        if (driver != null) {
            element.sendKeys(text);
        }
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
