package pageTest;

import org.example.alertPage;
import org.example.baseTest;
import org.example.iFramePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class testiFramePage extends baseTest {
    iFramePage elementFrame = new iFramePage();
    public WebDriver driver;

    @BeforeClass
    public void openPage() {
        setBrowser("chrome", "https://www.tutorialspoint.com/selenium/practice/frames.php");
        driver = getDriver();
        elementFrame.elementPageFactory(driver);
        //cookieButton.click();
    }

    @AfterClass
    public void closeDriver() {
        closeBrowser();
    }

    @Test //switch to frame1 va click vao button
    public void switchToFrame1() throws InterruptedException {
        driver.switchTo().frame(0);
        WebElement button = driver.findElement(By.xpath("//a[@href='/selenium/index.htm']"));
        scrollAndClick(button);
    }


}