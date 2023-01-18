package ua.com.company.utils.property;

import ua.com.company.utils.property.PropertiesReader;

public class TelegramPropertiesReader extends PropertiesReader {

    public TelegramPropertiesReader(String path) {
        super(path);
    }

    /**
     * @return String value of "bot.token" from property
     */
    public String getBotToken() {
        return super.prop.getProperty("bot.token");
    }

    /**
     * @return String value of "bot.name" from property
     */
    public String getBotName() {
        return super.prop.getProperty("bot.name");
    }
}
