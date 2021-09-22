package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {
    //using map
    public static final Map<Driverstype, Supplier<WebDriver>> driverMap=new HashMap<>();

    //chrome driver supplier
    public static  final Supplier<WebDriver> chromDriverSupplier=()->{
        System.setProperty("WebDriver.chrome.driver","\\src\\main\\resources\\chromedriver.exe");
        return new ChromeDriver();
    };
    //Firefox driver supplier
   /* public static  final Supplier<WebDriver> geckodriverDriverSupplier=()->{
        System.setProperty("WebDriver.chrome.driver","\\src\\main\\resources\\geckodriver.exe");
        return new GeckoDriver();*/
    static {
        driverMap.put(Driverstype.CHROME,chromDriverSupplier);
    }
    //method to get driverr
    public static final WebDriver getDriver(Driverstype type){
        return driverMap.get(type).get();
    }
}




