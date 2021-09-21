package PageObjects;

import Base.BaseMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class ButtonsPage extends BaseMethods
{
    WebDriver driver;
    WebDriverWait wait;

    //Page object creation
    @FindBy(xpath = "//span[text()='Buttons']")
    WebElement btn_buttons;

    @FindBy(id = "doubleClickBtn")
    WebElement btn_doubleclick;

    @FindBy(id = "rightClickBtn")
    WebElement btn_rightclick;

    //Constructor to Initialize the driver
    public ButtonsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickButtonOption()
    {
        this.btn_buttons.click();
    }



    public void clickingbuttons()
    {
        this.btn_buttons.click();

        Actions actions = new Actions(driver);
       actions.moveToElement(this.btn_doubleclick).doubleClick();
       actions.moveToElement(this.btn_rightclick).contextClick();
       //this.btn_clickme.click();
    }

    @Override
    public boolean isAt()
    {
        wait = new WebDriverWait(this.driver, 15);
        return this.wait.until((d) ->this.btn_doubleclick.isDisplayed());

    }
}
