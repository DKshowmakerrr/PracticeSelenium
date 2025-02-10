package pageTest;

import org.example.baseTest;
import org.example.checkBoxPage;
import org.example.textBoxPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testCheckBoxPage extends baseTest {
    checkBoxPage elementCheckBoxPage = new checkBoxPage();
    public WebDriver driver;

    @BeforeClass
    public void openPage() {
        setBrowser("chrome", "https://www.tutorialspoint.com/selenium/practice/check-box.php");
        driver = getDriver();
        elementCheckBoxPage.elementPageFactory(driver);
        //cookieButton.click();
    }

    @AfterClass
    public void closeDriver() {
        closeBrowser();
    }

    @Test
    public void clickOnPlus() throws Exception {
        clickElement(elementCheckBoxPage.plusLabels);
    }


    /*@Test
    public void clickBookStoreApplication() throws InterruptedException {
        clickElement(elementPage.bookStoreApplication);
    }*/
}