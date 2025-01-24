package com.automation.utils;

import com.github.fge.msgsimple.source.PropertiesMessageSource;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;
    public static void initiateProperties(){
        properties=new Properties();

        try {
            properties.load(new FileInputStream("src/test/resources/config/configData.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void setConfigProperty(String key, String value){
        properties.setProperty(key,value);

        try(FileOutputStream output=new FileOutputStream("src/test/resources/config/configData.properties")){
            properties.store(output,null);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String getConfigProperty(String key){
        return properties.getProperty(key);
    }
}
