package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonsPage {
    @FindBy(xpath="//*[@id='item-4']/span")
    WebElement buttons;

    @FindBy(id="doubleClick")
    WebElement doubleClick;

    @FindBy(id="rightClickBtn")
    WebElement rightClick;

    @FindBy(id="COGXw")
    WebElement click;
    WebDriverWait wait;
    WebDriver driver;

    public ButtonsPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    public boolean isat(){
        wait=new WebDriverWait(driver,15);
        return wait.until((d)-> doubleClick.isDisplayed());
    }

    public void clickingButton(){
        buttons.click();
    }
    public void DoubleClick(){
        doubleClick.click();
    }

    public void RightClick() {
        rightClick.click();
    }
    public void clickme(){
        clickme();
    }
    public void closethewindow(){
        driver.close();

    }
}
