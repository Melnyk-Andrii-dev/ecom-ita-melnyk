package properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyLoader {
    private static String pathToPropertyFile ="src/application.properties";

    private static Properties getPropertyFile(String pathToPropertyFile){
       Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(pathToPropertyFile));
        } catch (java.io.IOException e){
            e.printStackTrace();
        }
        return properties;
    }
    public static String getProperty(String key){
        return getPropertyFile(pathToPropertyFile).getProperty(key);
    }
    public static void putProperty(String key, String value){
        Properties properties = new Properties();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(pathToPropertyFile);
            properties.setProperty(key, value);
            properties.store(fos, null);
        } catch (java.io.IOException e){
            e.printStackTrace();
        }
    }
}
