package PageObjects;

import Base.BaseMethods;
import io.cucumber.java.bs.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.events.Event;

public class TextBoxPage extends BaseMethods
{
    WebDriver driver;
    WebDriverWait wait;

    //Page object creation
    @FindBy(xpath = "//span[text()='Text Box']")
    WebElement btn_textbox;

    @FindBy(id = "userName")
    WebElement txt_username;

    @FindBy(id = "userEmail")
    WebElement txt_useremail;

    @FindBy(id = "currentAddress" )
    WebElement txt_curraddress;

    @FindBy(id = "permanentAddress")
    WebElement txt_permaddress;

    @FindBy(id = "submit")
    WebElement btn_submit;

    //Constructor to initialize the drive
    public TextBoxPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void clickTextButton()
    {
        this.btn_textbox.click();
    }

    public void enterdetails() throws InterruptedException {
        //Click textbox button
        this.btn_textbox.click();

        //Sending user details
        this.txt_username.sendKeys("Sindhura1");
        this.txt_useremail.sendKeys("abc@gmail.com");
        this.txt_curraddress.sendKeys("Irving,Texas");
        this.txt_permaddress.sendKeys("India");
  //Explicitly wait
        WebDriverWait wait = new WebDriverWait(driver, 20);

        //Thread.sleep(5000);
        //Explicitly wait
        //WebDriverWait wait = new WebDriverWait(driver, 30);

        //Click submit button
        Actions actions=new Actions(driver);
        actions.moveToElement(this.btn_submit).click().perform();
        //this.btn_submit.click();
    }

    @Override
    public boolean isAt()
    {
        wait = new WebDriverWait(this.driver, 15);
        return this.wait.until((d) ->this.txt_username.isDisplayed());

    }

}
