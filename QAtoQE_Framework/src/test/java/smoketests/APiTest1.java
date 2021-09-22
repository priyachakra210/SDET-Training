package smoketests;

import base.DriverFactory;
import base.DriverType;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class APiTest1
{
    public static void insertRecord(String val2) throws FilloException {
        Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection("src/main/resources/testdata/Compnay_TestData.xlsx");
        String strQuery="INSERT INTO sheet1(CompanyName,Email) VALUES('1','"+val2+"')";

        connection.executeUpdate(strQuery);

        connection.close();
    }
    //Calling WebDriver
    private WebDriver driver;
    @Test(priority = 0)
    public void getCall() throws InterruptedException, FilloException {
        driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://projectredcap.org/partners/");
        Thread.sleep(4000);

        driver.findElement(By.linkText("View All")).click();

        WebElement table = driver.findElement(By.id("partners"));

        int tblrows = table.findElements(By.tagName("tr")).size();
        System.out.println("No of rows in table: "+tblrows);

        for(int i =2; i<=tblrows; i++)
        {
            WebElement institutionName = driver.findElement(By.xpath("//*[@id='partners']/tr["+i+"]/td"));
            String insName = institutionName.getText();

            System.out.println(insName);

            /*WebElement email = driver.findElement(By.xpath("//*[@id='partners']/tr["+i+"]/td//following::a[2]"));
            String emailTxt = email.getAttribute("href");
            System.out.println(emailTxt);*/

            //insertRecord(emailTxt);
            //System.out.println(rowvalue);
        }
    }
}
