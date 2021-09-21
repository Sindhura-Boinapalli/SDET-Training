package SmokeTests;

import Base.DriverFactory;
import Base.DriverType;
import PageObjects.ButtonsPage;
import PageObjects.TextBoxPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmokeTest1
{
    //Calling the webdriver
    private WebDriver driver;

    //Creating textbox object
    TextBoxPage textBoxPage;

    //Creating objects for extent reports
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;

    //Creating object for log4J
    Logger logger = Logger.getLogger(SmokeTest1.class);

    @BeforeTest
    public void setup()
    {
        PropertyConfigurator.configure("src/main/resources/properties/log4j.properties");
        // start reporters
        htmlReporter = new ExtentHtmlReporter("target/Sindhura1_Report.html");

        //append the report
        htmlReporter.setAppendExisting(true);


        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        logger.warn("TextBox application");
        test = extent.createTest("Smoketest1", "TextBox Application");

        driver = DriverFactory.getdriver(DriverType.CHROME);
        driver.get("https://demoqa.com/elements");

    }

    @Test
    public void TC001() throws InterruptedException {
        // log(Status, details)
        test.log(Status.INFO, "Navigating to Text box url");

        textBoxPage= new TextBoxPage(driver);
        this.textBoxPage.clickTextButton();

        logger.warn("Navigating to URL");

        test.log(Status.PASS, "Successfully navigated to URL");

        Assert.assertTrue(this.textBoxPage.isAt());
        textBoxPage.enterdetails();
        test.log(Status.PASS, "User entered details successfully");
        logger.warn("Successfully entered details");

    }

    @AfterTest
    public void teardown()
    {
        extent.flush();
        driver.close();
        //driver.quit();
    }
}
