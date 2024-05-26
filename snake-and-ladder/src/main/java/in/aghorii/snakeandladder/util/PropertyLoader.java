package in.aghorii.snakeandladder.util;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    private final Properties properties;

    public PropertyLoader(String propertyFileName) {
        properties = new Properties();
        try(InputStream input = getClass().getClassLoader().getResourceAsStream(propertyFileName)) {
            if (input == null) {
                System.out.println("Property file not found: " + propertyFileName);
                return;
            }
            properties.load(input);
        } catch(IOException ex) {
            System.out.println("Could not load property file: " + propertyFileName);
        }
    }

    public String getProperty(String propertyName){
        return properties.getProperty(propertyName);
    }
}
