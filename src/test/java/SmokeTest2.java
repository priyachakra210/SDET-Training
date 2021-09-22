import base.DriverFactory;
import base.Driverstype;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.ButtonsPage;

public class SmokeTest2 {
    WebDriver driver ;

    @BeforeTest
    public void init() {
        driver = DriverFactory.getDriver(Driverstype.CHROME);
        driver.get("https://www.demoqa.com/buttons");
    }

    @Test
    public void clickingButtons(){
        ButtonsPage page=new ButtonsPage(driver) ;
        page.clickingButton();
        page.DoubleClick();
        page.RightClick();
        page.clickme();

    }

}

