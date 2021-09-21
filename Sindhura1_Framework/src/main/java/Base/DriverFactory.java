package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory
{
     //Creating driver map
        private static final Map<DriverType,Supplier<WebDriver>> drivermap = new HashMap<>();

    //chrome driver supplier
    public static final Supplier<WebDriver> chromedriversupplier = ()-> {
       System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver/chromedriver.exe");
       return new ChromeDriver();
   };

    //Adding all the drivers into a map
    static
    {
        drivermap.put(DriverType.CHROME,chromedriversupplier);
    }

    //Method to get driver
    public static final WebDriver getdriver(DriverType type)
    {
        return drivermap.get(type).get();
    }
}
