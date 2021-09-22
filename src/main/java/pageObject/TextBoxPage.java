package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BaseAbstract {
    //Page Objects Creation
    @FindBy(xpath="//*[@id='item-0']/span")
    WebElement btn_textBox;

    //page object creation
    @FindBy(id = "userName")
    WebElement txt_userName;

    @FindBy(id = "userEmail")
    WebElement txt_Email;

    @FindBy(id = "currentAddress")
    WebElement txt_CurrentAddress;

    @FindBy(id = "permanentAddress")
    WebElement txt_PermanentAddress;

    @FindBy(id = "submmit")
    WebElement txt_Submmit;

    WebDriver driver;

    public TextBoxPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickTextButton()
    {
        btn_textBox.click();
    }

    public void enterDetails() {
        txt_userName.sendKeys("Priya");
        txt_Email.sendKeys("Priya@gmail.com");
        txt_CurrentAddress.sendKeys("my adress");
        txt_PermanentAddress.sendKeys("pamAdress");
    }

    public void clickSubmit() {
        Actions actions=new Actions(driver);
        actions.moveToElement(txt_Submmit).click().perform();

    }
    public void closingwindow(){
        driver.close();
    }

}
