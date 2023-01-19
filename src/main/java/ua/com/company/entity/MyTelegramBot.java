package ua.com.company.entity;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.com.company.utils.IvideonConnection;
import ua.com.company.utils.property.IvideonPropertiesReader;
import ua.com.company.utils.property.TelegramPropertiesReader;

import java.io.IOException;

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
                    String response = ivideonConnection.connectToApi();
                    String[] responses = new String[20];
                    if (response.length() >= 4096) {
                        for (int i = 0; i < response.length() % 4096; i++) {
                            responses[i] = response.substring(0, 4096);
                            break;
                        }
                    }

                    message.setText(responses[0]);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
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
