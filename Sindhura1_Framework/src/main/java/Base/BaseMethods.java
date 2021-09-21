package Base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseMethods
{
    WebDriver driver;

    //To check whether page is displayed or not
    public abstract boolean isAt();

    //To take screenshot of required page
    public void screenShot()
    {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

    }

    //To get properties file
    public String getProperties(String keyvalue) throws IOException {

        //Created file objects
        File file =new File("src/main/resources/properties/data.properties");
        FileInputStream fileInputStream = new FileInputStream(file);

        //Create properties object
        Properties properties = new Properties();
        properties.load(fileInputStream);

        return properties.getProperty(keyvalue);


    }
}
