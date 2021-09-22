import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.TextBoxPage;

public class SmokeTest1 {
    ChromeDriver  driver;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void init() {
        //start reports
        htmlReporter=new ExtentHtmlReporter("target/QA_to_QE_Report.html");
        htmlReporter.setAppendExisting(true);
        extent=new ExtentReports();
        extent.attachReporter(htmlReporter);
        test=extent.createTest("SmokeTest1","TextBoxPage");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\chakr\\IdeaProjects\\QA_to_QE" +
                "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        test.log(Status.INFO,"Navigating to the URL");
        driver.get("https://www.demoqa.com/elements");
    }

    @Test
    public void fillingForm() {
        TextBoxPage page = new TextBoxPage(driver);
        test.log(Status.INFO,"clicking on the textBox button");
        page.clickTextButton();
        test.log(Status.PASS,"entering all the details to the textfeilds");
        page.enterDetails();
        test.log(Status.INFO,"clicking on the submmit button");
        page.clickSubmit();
    }
    @AfterTest
    public void teardown(){
        extent.flush();
        driver.close();
    }


}
