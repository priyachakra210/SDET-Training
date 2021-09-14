package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class baseMethods
{
    WebDriver driver;

    public abstract boolean isAt();

    public void screenshot(String fileName, WebDriver driver) throws IOException
    {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("target/"+fileName+".png"));
    }

    public String getProperties(String keyvalue) throws IOException {

        //Created File objects
        File file = new File("src/main/resources/properties/data.properties");
        FileInputStream fileInputStream = new FileInputStream(file);

        //Create Properties Object
        Properties properties = new Properties();

        properties.load(fileInputStream);

        return properties.getProperty(keyvalue);


    }



}
