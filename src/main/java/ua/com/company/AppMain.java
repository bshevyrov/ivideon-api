package ua.com.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ua.com.company.entity.MyTelegramBot;
import ua.com.company.utils.property.TelegramPropertiesReader;

public class AppMain {
    static Logger log = LogManager.getLogger(AppMain.class);
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new MyTelegramBot(new TelegramPropertiesReader("src/main/resources/telegram.properties")));
            log.info("Connected");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
