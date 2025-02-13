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

    @Test //tat ca main checkbox, sub checkbox, last checkbox deu la non-selected
    public void checkNonSelected() {
        checkNonSelected(elementCheckBoxPage.mainCheckBoxes);
        checkNonSelected(elementCheckBoxPage.subCheckBoxes);
        checkNonSelected(elementCheckBoxPage.lastCheckBoxes);
    }

    @Test //khi click vao main checkbox, tat ca cac checkbox con cua no deu duoc chon
    public void checkSelectMain() throws InterruptedException {
        for (WebElement elementCheckBoxMain : elementCheckBoxPage.mainCheckBoxes) {
            scrollAndClick(elementCheckBoxMain);
        }
        checkSelected(elementCheckBoxPage.mainCheckBoxes);
        checkSelected(elementCheckBoxPage.subCheckBoxes);
        checkSelected(elementCheckBoxPage.lastCheckBoxes);
    }

    @Test //khi click vao main checkbox again, tat ca cac checkbox con cua no deu duoc bo chon
    public void checkUnselectMain() throws InterruptedException {
        for (WebElement elementCheckBoxMain : elementCheckBoxPage.mainCheckBoxes) {
            scrollAndClick(elementCheckBoxMain);
        }
        checkNonSelected(elementCheckBoxPage.mainCheckBoxes);
        checkNonSelected(elementCheckBoxPage.subCheckBoxes);
        checkNonSelected(elementCheckBoxPage.lastCheckBoxes);
    }

    @Test //khi click vao sub checkbox, tat ca checkbox con cua no deu duoc chon
    public void checkSelectSub() throws InterruptedException {
        for (WebElement elementCheckBoxSub : elementCheckBoxPage.subCheckBoxes) {
            scrollAndClick(elementCheckBoxSub);
        }
        checkSelected(elementCheckBoxPage.mainCheckBoxes);
        checkSelected(elementCheckBoxPage.subCheckBoxes);
        checkSelected(elementCheckBoxPage.lastCheckBoxes);
    }

    @Test //khi click vao sub checkbox again, tat ca checkbox con cua no deu duoc bo chon
    public void checkUnSelectSub() throws InterruptedException {
        for (WebElement elementCheckBoxSub : elementCheckBoxPage.subCheckBoxes) {
            scrollAndClick(elementCheckBoxSub);
        }
        checkNonSelected(elementCheckBoxPage.mainCheckBoxes);
        checkNonSelected(elementCheckBoxPage.subCheckBoxes);
        checkNonSelected(elementCheckBoxPage.lastCheckBoxes);
    }

    @Test //khi click vao last checkbox, tat ca cac checkbox main va sub deu duoc chon
    public void checkSelectLast() throws InterruptedException {
        for (WebElement elementCheckBoxLast : elementCheckBoxPage.lastCheckBoxes) {
            scrollAndClick(elementCheckBoxLast);
        }
        checkSelected(elementCheckBoxPage.mainCheckBoxes);
        checkSelected(elementCheckBoxPage.subCheckBoxes);
        checkSelected(elementCheckBoxPage.lastCheckBoxes);
    }

    @Test //khi click vao last checkbox again, tat ca cac checkbox main va sub deu duoc bo chon
    public void checkUnselectLast() throws InterruptedException {
        WebElement elementCheckBoxLast = elementCheckBoxPage.lastCheckBoxes.get(0);
        scrollAndClick(elementCheckBoxLast);
        Assert.assertFalse(elementCheckBoxPage.mainCheckBoxes.get(0).isSelected());
        Assert.assertFalse(elementCheckBoxPage.subCheckBoxes.get(0).isSelected());
    }

}