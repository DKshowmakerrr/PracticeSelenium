package pageTest;

import org.example.baseTest;
import org.example.radioButtonPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testRadioButtonPage extends baseTest {
    radioButtonPage elementPageRadio = new radioButtonPage();
    public WebDriver driver;

    @BeforeClass
    public void openPage() {
        setBrowser("chrome", "https://www.tutorialspoint.com/selenium/practice/radio-button.php");
        driver = getDriver();
        elementPageRadio.elementPageFactory(driver);
        //cookieButton.click();
    }

    @AfterClass
    public void closeDriver() {
        closeBrowser();
    }

    @Test

}