package pageTest;

import org.example.alertPage;
import org.example.baseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class testAlertPage extends baseTest {
    alertPage elementAlert = new alertPage();
    public WebDriver driver;

    @BeforeClass
    public void openPage() {
        setBrowser("chrome", "https://www.tutorialspoint.com/selenium/practice/alerts.php");
        driver = getDriver();
        elementAlert.elementPageFactory(driver);
        //cookieButton.click();
    }

    @AfterClass
    public void closeDriver() {
        closeBrowser();
    }

    @Test //click vao alert thu 1 va dong lai
    public void clickAlert1() throws InterruptedException {
        scrollAndClick(elementAlert.alertButton);
        driver.switchTo().alert().accept();
    }

    @Test //nhap vao prompt thu 4 nhap data va dong lai
    public void click4Me() throws InterruptedException {
        scrollAndClick(elementAlert.click4MeButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert4 = driver.switchTo().alert();
        alert4.sendKeys("Hello");
        alert4.dismiss();
    }




}