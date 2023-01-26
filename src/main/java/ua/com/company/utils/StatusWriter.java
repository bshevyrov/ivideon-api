package ua.com.company.utils;

import org.apache.commons.io.FileUtils;
import ua.com.company.entity.ivideon.entity.response.Camera;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class StatusWriter {
    private final static String PATH_TO_FILES = "src/main/resources/response/";

    static public void writeToFile(List<Camera> data)  {

        try {
            FileUtils.deleteDirectory(new File(PATH_TO_FILES));
            new File(PATH_TO_FILES).mkdir();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Camera camera : data) {
            try {
                new File(PATH_TO_FILES + camera.getName()).createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (Writer writer = new BufferedWriter(new FileWriter(PATH_TO_FILES + camera.getName()))) {

                writer.write(String.valueOf(camera.isOnline()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
