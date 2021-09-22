import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.RadioButtons;

public class Smoketest3 {
    WebDriver driver;
    @BeforeTest
    public  void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chakr\\IdeaProjects\\" +
                "QA_to_QE\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.demoqa.com/radio-button");
    }
    @Test(priority = 1)
    public void radioButtonspage(){
        RadioButtons radioButtons1=new RadioButtons(driver);
        radioButtons1.clickingradioBtton();
        radioButtons1.yesRadio();
        radioButtons1.impressivebutton();
        radioButtons1.noradio();
        radioButtons1.header();
        Assert.assertEquals(radioButtons1.text(), "Do you like the site?");

    }

}



