package pageTest;

import org.example.baseTest;
import org.example.elementPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testElementPage extends baseTest {
    private WebDriver driver;
    elementPage elementPage = new elementPage();

    @BeforeClass
    public void setDriver() {
        elementPage.openPage();
        driver = getDriver();
    }

    @AfterClass
    public void closeDriver() {
        closeBrowser();
    }

    @Test
    public void getTitle() {
        Assert.assertEquals(driver.getTitle(), "DemoQA");
    }

    @Test
    public void clickBookStoreApplication() throws InterruptedException {
        clickElement(elementPage.bookStoreApplication);
    }
}
