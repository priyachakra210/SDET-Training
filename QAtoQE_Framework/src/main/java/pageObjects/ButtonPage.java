package pageObjects;

import base.baseMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonPage extends baseMethods
{
    WebDriver driver;
    WebDriverWait wait;

    //Page Objects Creation
    @FindBy(xpath = "//span[text()='Buttons']")
    WebElement btn_Buttons;

    @FindBy(id = "doubleClickBtn")
    WebElement btn_doubleClick;

    @FindBy(id = "rightClickBtn")
    WebElement btn_rightClick;

    //Constructor to Initialize the driver
    public ButtonPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickButtonOption()
    {
        this.btn_Buttons.click();
    }

    public void clickingButtons() throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(this.btn_doubleClick).doubleClick().perform();
        actions.moveToElement(this.btn_rightClick).contextClick().perform();
    }

    @Override
    public boolean isAt()
    {
        wait = new WebDriverWait(this.driver,15);
        return this.wait.until((d)->this.btn_doubleClick.isDisplayed());
    }
}
