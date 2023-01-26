package ua.com.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.com.company.entity.ivideon.entity.ivideon.IvideonAccount;
import ua.com.company.entity.ivideon.entity.response.Camera;
import ua.com.company.utils.IvideonConnection;
import ua.com.company.utils.StatusWriter;
import ua.com.company.utils.property.IvideonPropertiesReader;

import java.util.List;
import java.util.stream.Collectors;

public class AppMain {
    static Logger log = LogManager.getLogger(AppMain.class);

    public static void main(String[] args) {
//        try {
//            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
//            botsApi.registerBot(new MyTelegramBot(new TelegramPropertiesReader("src/main/resources/telegram.properties")));
//            log.info("Connected");
        while (true) {
            log.info("app start");
            IvideonAccount.createFromHttpResponse(new IvideonConnection(new IvideonPropertiesReader("src/main/resources/ivideon.properties")).makeAuthRequest());

            IvideonConnection ivideonConnection = new IvideonConnection(
                    new IvideonPropertiesReader("src/main/resources/ivideon.properties"));

            List<Camera> response = ivideonConnection.makeMethodRequest().stream()
                    .parallel()
                    .filter(camera ->
                            camera.getMode().equalsIgnoreCase("on"))
//                        .filter(camera -> !camera.isOnline())

                    .collect(Collectors.toList());
            log.info("Start write new status");
            StatusWriter.writeToFile(response);
            log.info("Sleep....");
            try {
                Thread.sleep((long) Integer.parseInt(args[0]) * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }

    }
}
