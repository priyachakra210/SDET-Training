package smoketests;

import base.DriverFactory;
import base.DriverType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ButtonPage;
import pageObjects.TextBoxPage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SmokeTest2 {
    //Calling WebDriver
    private WebDriver driver;

    //Creating TextPage object
    ButtonPage buttonPage;

    @BeforeTest
    public void setup() throws MalformedURLException {
        //driver = DriverFactory.getDriver(DriverType.CHROME);
        //Configuring Remote WebDriver
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Mac");
        driver = new RemoteWebDriver(new URL("http://192.168.1.68:4444/wd/hub"), chromeOptions);
        driver.get("https://www.demoqa.com/elements");
    }


    @Test
    public void TC002() throws InterruptedException, IOException {
        buttonPage = new ButtonPage(driver);
        buttonPage.clickButtonOption();
        Assert.assertTrue(this.buttonPage.isAt());
        buttonPage.clickingButtons();
        buttonPage.screenshot("buttonPagescreenshot", driver);
    }

    @AfterMethod //AfterMethod annotation - This method executes after every test execution
    public void screenShot(ITestResult result) {
        //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // To create reference of TakesScreenshot
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                // Call method to capture screenshot
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                // Copy files to specific location
                // result.getName() will return name of test case so that screenshot name will be same as test case name
                FileUtils.copyFile(src, new File("target\\" + result.getName() + ".png"));
                System.out.println("Successfully captured a screenshot");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }


//    @AfterTest
//    public void tearDown()
//    {
//        driver.close();
//    }

}
