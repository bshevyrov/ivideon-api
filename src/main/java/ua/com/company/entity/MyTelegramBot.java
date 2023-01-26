package ua.com.company.entity;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.com.company.entity.ivideon.entity.response.Camera;
import ua.com.company.utils.IvideonConnection;
import ua.com.company.utils.property.IvideonPropertiesReader;
import ua.com.company.utils.property.TelegramPropertiesReader;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyTelegramBot extends TelegramLongPollingBot {
    private final TelegramPropertiesReader telegramPropertiesReader;

    public MyTelegramBot(TelegramPropertiesReader telegramPropertiesReader) {
        this.telegramPropertiesReader = telegramPropertiesReader;
    }

    @Override
    public String getBotUsername() {
        return telegramPropertiesReader.getBotName();
    }

    @Override
    public String getBotToken() {
        return telegramPropertiesReader.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            if (update.getMessage().getText().equals("/login")) {
                IvideonConnection ivideonConnection = new IvideonConnection(
                        new IvideonPropertiesReader("src/main/resources/ivideon.properties"));
                try {
                    List<Camera> response = ivideonConnection.makeMethodRequest().stream()
                            .parallel()
                            .filter(camera ->
                                    camera.getMode().equalsIgnoreCase("on"))
                            .filter(camera -> !camera.isOnline())

                            .collect(Collectors.toList());

                    message.setText(response.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
