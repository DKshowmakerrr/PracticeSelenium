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

    public void scrollPage(WebElement element) throws InterruptedException {
        if (driver != null) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", element);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            js.executeScript("arguments[0].click();", element);
        }
    }


    public void clickElement(WebElement element) {
        if (element.isEnabled()) {
            element.click();
        }
    }

    public void enterText(String locator, String text) {
        if (driver != null) {
            driver.findElement(By.xpath(locator)).sendKeys(text);
        }
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
