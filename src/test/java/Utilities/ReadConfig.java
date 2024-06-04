package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties properties;
    String fileName = "C:\\Users\\Harsh\\IdeaProjects\\MyStore\\ConfigurationFiles\\config.properties";

    public ReadConfig() {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(fileName);
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


    public String getEmail() {
        String email = properties.getProperty("Email");
        if (email!=null){
            return email;
        }else {
            throw new RuntimeException("email not found");
        }
    }
     public String getPassword() {
        String password = properties.getProperty("Password");
        if (password!=null){
            return password;
        }else {
            throw new RuntimeException("password not found");
        }
    }



}
