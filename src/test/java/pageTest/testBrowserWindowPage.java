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

    @AfterClass
    public void closeDriver() {
        closeBrowser();
    }

    @Test (priority = 0) //click vao button new tab va xac dinh no mo 1 tab moi va chuyen qua tab moi
    public void testBrowserWindow () throws InterruptedException {
        Set<String> beforeWindows = driver.getWindowHandles();
        int beforeSize = beforeWindows.size();

        scrollAndClick(elementBrowserWindow.newTabButton);
        Set<String> afterWindows = driver.getWindowHandles();
        int afterSize = afterWindows.size();

        Assert.assertEquals(afterSize, beforeSize + 1);
        for(String handle: afterWindows) {
            if (!beforeWindows.contains(handle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    @Test (priority = 1) //dong tab moi
    public void closeNewTab() throws InterruptedException {
        driver.close();
    }


}