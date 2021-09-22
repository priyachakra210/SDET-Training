package pageObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;

public class BaseAbstract {
    public String getProperty(String key) throws IOException {
        File file=new File("src/main/resources/properties/Constants.properties");
        FileInputStream stream=new FileInputStream(file);
        Properties properties=new Properties();
        properties.load(stream);
      return   properties.getProperty(key);
    }

}
