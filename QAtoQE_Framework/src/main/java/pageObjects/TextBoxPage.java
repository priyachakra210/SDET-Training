package pageObjects;

import base.baseMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage extends baseMethods
{
    WebDriver driver;
    WebDriverWait wait;

    //Page Objects Creation
    @FindBy(xpath = "//span[text()='Text Box']")
    WebElement btn_textBox;

    @FindBy(id = "userName")
    WebElement txt_userName;

    @FindBy(id = "userEmail")
    WebElement txt_email;

    @FindBy(id = "currentAddress")
    WebElement txt_currentAddress;

    @FindBy(id = "permanentAddress")
    WebElement txt_permanentAddress;

    @FindBy(id = "submit")
    WebElement btn_submit;


    //Constructor to Initialize the driver
    public TextBoxPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickTextButton()
    {
        this.btn_textBox.click();
    }

    //Method to enter details
    public void enterDetails() throws InterruptedException {
        //Click textbox button
        this.txt_userName.sendKeys("test");
        this.txt_email.sendKeys("test@gmail.com");
        this.txt_currentAddress.sendKeys("test address");
        this.txt_permanentAddress.sendKeys("perm address");
    }

    @Override
    public boolean isAt()
    {
        wait = new WebDriverWait(this.driver,15);
        return this.wait.until((d)->this.txt_userName.isDisplayed());
    }
}
