package pageTest;

import org.example.baseTest;
import org.example.browserWindowPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class testBrowserWindowPage extends baseTest {
    browserWindowPage elementBrowserWindow = new browserWindowPage();
    public WebDriver driver;

    @BeforeClass
    public void openPage() {
        setBrowser("chrome", "https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
        driver = getDriver();
        elementBrowserWindow.elementPageFactory(driver);
        //cookieButton.click();
    }
    Set<String> beforeWindows = driver.getWindowHandles();
    int beforeSize = beforeWindows.size();

    @AfterClass
    public void closeDriver() {
        closeBrowser();
    }

    @Test //click vao button new tab va xac dinh no mo 1 tab moi
    public void testBrowserWindow () throws InterruptedException {
        scrollAndClick(elementBrowserWindow.newTabButton);
        Set<String> afterWindows = driver.getWindowHandles();
        int afterSize = afterWindows.size();
        Assert.assertEquals(afterSize, beforeSize + 1); //kiem tra so luong tab sau khi click
    }



}