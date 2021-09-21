package SmokeTests;

import Base.DriverFactory;
import Base.DriverType;
import PageObjects.ButtonsPage;
import PageObjects.TextBoxPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoQATest1
{
    //Calling the webdriver
    private WebDriver driver;

    //Creating textbox and Buttons object
    TextBoxPage textBoxPage;
    ButtonsPage buttonsPage;

    @BeforeTest
    public void setup()
    {
        driver = DriverFactory.getdriver(DriverType.CHROME);
        driver.get("https://demoqa.com/elements");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void TC001() throws InterruptedException {
        textBoxPage= new TextBoxPage(driver);
        this.textBoxPage.clickTextButton();
        Assert.assertTrue(this.textBoxPage.isAt());
        textBoxPage.enterdetails();

    }

    //@Test(dependsOnMethods = "TC001")
    @Test(priority = 0)
    public void TC002() throws InterruptedException {
        driver.get("https://demoqa.com/elements");
        buttonsPage = new ButtonsPage(driver);
        this.buttonsPage.clickButtonOption();
        Assert.assertTrue(this.buttonsPage.isAt());
        buttonsPage.clickingbuttons();

    }

    @AfterTest
    public void teardown()
    {
            driver.close();
        //driver.quit();
    }


}
