package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReaderManager
{

    public String getProperties(String value) throws IOException {
        File file = new File("src/main/resources/properties/data.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file

        prop.load(fileInput);
        return prop.getProperty(value);

    }

    public String getReportConfigPath() throws IOException {
        String reportConfigPath = getProperties("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }


}
