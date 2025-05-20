package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    public static Properties loadProperties(String propertiesFileName) {
        Properties properties = new Properties();

        try (InputStream input = PropertyLoader.class.getClassLoader()
                .getResourceAsStream(propertiesFileName)) {
            if (input == null) {
                throw new RuntimeException(propertiesFileName + " file not found in classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load " + propertiesFileName, e);
        }

        return properties;
    }
}
