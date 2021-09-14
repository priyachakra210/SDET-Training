package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class sampletest
{
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/propertyFiles/data.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
            System.out.println(prop.getProperty("url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
