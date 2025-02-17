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

    @Test (priority = 0) //default la nonselect
    public void checkdefault() {
        waitForElement(elementPageRadio.yesButton);
        Assert.assertFalse(elementPageRadio.yesButton.isSelected());

        waitForElement(elementPageRadio.impressiveButton);
        Assert.assertFalse(elementPageRadio.impressiveButton.isSelected());

        waitForElement(elementPageRadio.noButton);
        Assert.assertFalse(elementPageRadio.noButton.isEnabled());
    }

    @Test (priority = 1) //chon yes
    public void checkYes() throws InterruptedException {
        scrollAndClick(elementPageRadio.yesButton);
        Assert.assertTrue(elementPageRadio.yesButton.isSelected());
        Assert.assertFalse(elementPageRadio.impressiveButton.isSelected());
        Assert.assertFalse(elementPageRadio.noButton.isSelected());
    }

    @Test (priority = 2) //chon impressive
    public void checkImpressive() throws InterruptedException {
        scrollAndClick(elementPageRadio.impressiveButton);
        Assert.assertFalse(elementPageRadio.yesButton.isSelected());
        Assert.assertTrue(elementPageRadio.impressiveButton.isSelected());
        Assert.assertFalse(elementPageRadio.noButton.isSelected());
    }

}