package ua.com.company.utils.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    protected final Properties prop;
    private final String path;

    public PropertiesReader(String path) {
        this.path = path;
        prop = readProperties(path);
    }

    /**
     * Read properties from file
     *
     * @param path Path to property file
     * @return Property object
     */
    private static Properties readProperties(String path) {
        Properties prop = new Properties();
        try (InputStream inputStream = new FileInputStream(path)) {
            prop.load(inputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
