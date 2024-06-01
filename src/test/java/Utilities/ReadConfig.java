package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties properties;
    String path = "C:\\Users\\Harsh\\IdeaProjects\\MyStore\\ConfigurationFiles\\config.properties";

    public ReadConfig() {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBaseUrl() {
        String url = properties.getProperty("url");
        if (url!=null){
            return url;
        }else {
            throw new RuntimeException("url not found");
        }
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser!=null){
            return browser;
        }else {
            throw new RuntimeException("browser not found");
        }
    }



}
