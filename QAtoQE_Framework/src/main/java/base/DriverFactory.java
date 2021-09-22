package base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory
{
    //Creating Driver Map
    private static final Map<DriverType,Supplier<WebDriver>> driverMap = new HashMap<>();

    //Chrome driver Supplier
    public static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver");
        return new ChromeDriver();
    };

    //Firefox driver Supplier
    public static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/geckodriver");
        return new FirefoxDriver();
    };

    //Adding all the drivers into a map
    static
    {
        driverMap.put(DriverType.CHROME,chromeDriverSupplier);
        driverMap.put(DriverType.FIREFOX,firefoxDriverSupplier);
    }

    //Method to get Driver
    public static final WebDriver getDriver(DriverType type)
    {
        return driverMap.get(type).get();
    }

}
