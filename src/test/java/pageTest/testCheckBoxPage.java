package pageTest;

import org.example.baseTest;
import org.example.checkBoxPage;
import org.example.textBoxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

    @BeforeMethod
    public void clickOnPlus() throws Exception {
        for (WebElement elementPlus : elementCheckBoxPage.plusIcons) {
            scrollAndClick(elementPlus);
        }
    }

    //check cac checkbox la non-selected
    @Test //main checkbox la non-selected
    public void checkNonSelectedMain() {
        for (WebElement elementCheckBoxMain : elementCheckBoxPage.mainCheckBoxes) {
            Assert.assertFalse(elementCheckBoxMain.isSelected());
        }
    }

    @Test //sub checkbox la non-selected
    public void checkNonSelectedSub() {
        for (WebElement elementCheckBoxSub : elementCheckBoxPage.subCheckBoxes) {
            Assert.assertFalse(elementCheckBoxSub.isSelected());
        }
    }

    @Test //main checkbox la non-selected
    public void checkNonSelectedLast() {
        for (WebElement elementCheckBoxLast : elementCheckBoxPage.lastCheckBoxes) {
            Assert.assertFalse(elementCheckBoxLast.isSelected());
        }
    }

    @Test
    public void checkSelectedMain() throws InterruptedException {
        checkNonSelectedMain();
    }
}