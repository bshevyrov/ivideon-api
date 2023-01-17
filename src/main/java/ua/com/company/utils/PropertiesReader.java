package ua.com.company.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static final Properties prop = readProperties();

    /**
     * Read properties from file
     * @return Property object
     */
    private static Properties readProperties() {
        Properties prop = new Properties();
        try (InputStream inputStream = new FileInputStream("src/main/resources/telegram.properties")) {
            prop.load(inputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**
     *
     * @return String value of "bot.token" from property
     */
    public static String getToken() {
        return prop.getProperty("bot.token");
    }

    /**
     *
     * @return String value of "bot.name" from property
     */
    public static String getName() {
        return prop.getProperty("bot.name");
    }

    /**
     * Explicit reading from properties file
     */
    public static void refreshProperties() {
        readProperties();
    }
}
