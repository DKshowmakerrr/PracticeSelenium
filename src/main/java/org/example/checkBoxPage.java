package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class checkBoxPage extends baseTest {

    //element của các +label
    @FindAll(@FindBy(xpath ="//span[@class='plus']"))
    public List<WebElement> plusIcons;

    //element của các checkbox main level
    @FindAll(@FindBy(xpath ="//input[@type='checkbox' and starts-with(@id,'c_bs')]"))
    public List<WebElement> mainCheckBoxes;

    //element của các checkbox sub level
    @FindAll(@FindBy(xpath ="//input[@type='checkbox' and starts-with(@id,'c_bf')]"))
    public List<WebElement> subCheckBoxes;

    //element của các checkbox last level
    @FindAll(@FindBy(xpath ="//input[@type='checkbox' and starts-with(@id,'c_io')]"))
    public List<WebElement> lastCheckBoxes;


    // thiet lap page factory
    public void elementPageFactory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
