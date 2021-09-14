package smoketests;

import base.DriverFactory;
import base.DriverType;
import base.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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
import java.util.concurrent.TimeUnit;

public class SmokeTest1
{
    //Calling WebDriver
    private WebDriver driver;

    //Creating TextPage object
    TextBoxPage textBoxPage;

    //Objects for Extent Reports
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;

    //Object for log4J
    Logger logger = Logger.getLogger(SmokeTest1.class);


    @BeforeTest
    public void setup()
    {
        PropertyConfigurator.configure("src/main/resources/properties/log4j.properties");

        // start reporters
        htmlReporter = new ExtentHtmlReporter("target/QAtoQE_Report.html");
        htmlReporter.setAppendExisting(true);

        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        //Log4J log
        logger.warn("Testing Texbox Module");
        test = extent.createTest("Smoke Test1", "Testing Texbox module");

        driver = DriverFactory.getDriver(DriverType.CHROME);

        logger.warn("Navigating to the URL");
        test.log(Status.INFO, "Navigating to the URL");
        driver.get("https://www.demoqa.com/elements");
    }

    @Test
    public void TC001() throws InterruptedException, IOException {

        // log(Status, details)
        test.log(Status.INFO, "Navigating to the Texbox module");

        textBoxPage = new TextBoxPage(driver);
        this.textBoxPage.clickTextButton();

        logger.info("User navigated to Textbox module successfully");
        test.log(Status.PASS, "User navigated to Textbox module successfully");

        Assert.assertTrue(this.textBoxPage.isAt());

        test.log(Status.INFO, "Entering details in text box module");
        textBoxPage.enterDetails();
        //textBoxPage.screenshot("textboxPageDetails",driver);
//        Assert.assertTrue(false);
        //test.log(Status.PASS, "User Enter details in Textbox module successfully");
        //textBoxPage.screenshot("textboxPageDetails",driver);
        extent.flush();
        driver.close();



    }


    @AfterMethod
    public void screenShot(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // To create reference of TakesScreenshot
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                // Call method to capture screenshot

                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destFile = new File ("target/" + result.getName()+".png");
                FileUtils.copyFile(src,destFile);

                String path = "/QAtoQE_Framework/target/"+result.getName()+".png";

                test.log(Status.FAIL,"<a href='"+path+ "'> <img src='"+path+ "' height='100' width='100'/> </a>");
                extent.flush();
                driver.close();
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }

//    @AfterMethod
//    public void tearDown(ITestResult result) throws IOException {
//       if(result.getStatus() == ITestResult.FAILURE)
//       {
//           String fileName = Utility.getScreenshot(this.driver);
//           test.fail("error message",MediaEntityBuilder.createScreenCaptureFromPath(fileName).build());
//       }
//
//       extent.flush();
//       driver.close();
//    }





}
