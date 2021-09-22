package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class RadioButtons {
@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[1]")
WebElement lable;
@FindBy(xpath="//*[@id=\"app\"]/div/div/div[1]/div")
WebElement header;
    @FindBy(xpath="//*[@id='item-2']/span")
    WebElement radioButtons;
    @FindBy(xpath="//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[2]/label")
    WebElement yesRadiobutton;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/label")
    WebElement impressiveRadiobutton;
    @FindBy(xpath="//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[4]/label")
    WebElement noRadiobutton;
    //calling webdriver
    public RadioButtons(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    //finding radio buttonpage objects
    public void clickingradioBtton(){
        radioButtons.click();
    }
    public  void yesRadio(){
        yesRadiobutton.click();
    }
    public void impressivebutton(){
        impressiveRadiobutton.click();
    }
    public void noradio(){
        noRadiobutton.click();

    }
    public String text(){
        return lable.getText();
    }
    public String header(){
        return header.getText();
    }


}
