package smoketests;

import base.DriverFactory;
import base.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ButtonPage;
import pageObjects.TextBoxPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SmokeTest1
{
    //Calling WebDriver
    private WebDriver driver;

    //Creating TextPage object
    TextBoxPage textBoxPage;

    @BeforeTest
    public void setup()
    {
        driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.get("https://www.demoqa.com/elements");
    }

    @Test
    public void TC001() throws InterruptedException, IOException {
        textBoxPage = new TextBoxPage(driver);
        this.textBoxPage.clickTextButton();
        Assert.assertTrue(this.textBoxPage.isAt());
        textBoxPage.enterDetails();
        textBoxPage.screenshot("textboxPageDetails",driver);
    }

    @AfterTest
    public void tearDown()
    {
        driver.close();
    }
}
