package stepDefinitions;

import Base.DriverFactory;
import Base.DriverType;
import PageObjects.TextBoxPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class MyStepdefs {
    //Calling the webdriver
    private WebDriver driver;

    //Creating textbox object
    TextBoxPage textBoxPage;

    @Given("Navigating to textbox application")
    public void navigatingToTextboxApplication() throws IOException {
        driver = DriverFactory.getdriver(DriverType.CHROME);
        textBoxPage= new TextBoxPage(this.driver);
        String Url= textBoxPage.getProperties("url");
        driver.get(Url);
    }

    @When("I clickon textbox option")
    public void iClickonTextboxOption() {
        textBoxPage= new TextBoxPage(driver);
        this.textBoxPage.clickTextButton();
    }

    @And("I enter all the user details")
    public void iEnterAllTheUserDetails() throws InterruptedException {
        Assert.assertTrue(this.textBoxPage.isAt());
        textBoxPage.enterdetails();
    }

    @Then("I submit the details and exit the application")
    public void iSubmitTheDetailsAndExitTheApplication() {
        driver.quit();
    }
}
