package pageTest;

import org.example.baseTest;
import org.example.textBoxPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testTextBoxPage extends baseTest {
    textBoxPage elementPage = new textBoxPage();
    public WebDriver driver;

    @BeforeClass
    public void openPage() {
        setBrowser("chrome", "https://www.tutorialspoint.com/selenium/practice/text-box.php");
        driver = getDriver();
        elementPage.elementPageFactory(driver);
        //cookieButton.click();
    }

    @AfterClass
    public void closeDriver() {
        closeBrowser();
    }

    @Test
    public void getTitle() {
        Assert.assertEquals(driver.getTitle(),
                "Selenium Practice - Text Box");
    }

    @Test
    public void verifyLabels() {
        labelIsDisplayed(elementPage.fullNameLabel);
        labelIsDisplayed(elementPage.emailLabel);
        labelIsDisplayed(elementPage.currentAddressLabel);
        labelIsDisplayed(elementPage.passwordLabel);
    }

    @Test
    public void inputText() {
        enterText(elementPage.fullNameInput, "John Doe");
        enterText(elementPage.emailInput, "johndoe@example.com");
        enterText(elementPage.currentAddressInput, "123 Main St");
        enterText(elementPage.passwordInput, "Password123");
    }

    /*@Test
    public void clickBookStoreApplication() throws InterruptedException {
        clickElement(elementPage.bookStoreApplication);
    }*/
}