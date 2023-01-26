package ua.com.company.utils;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.com.company.entity.ivideon.builder.AuthIvideonRequestBuilder;
import ua.com.company.entity.ivideon.builder.Director;
import ua.com.company.entity.ivideon.builder.MethodIvideonRequestBuilder;
import ua.com.company.entity.ivideon.entity.response.Camera;
import ua.com.company.entity.ivideon.entity.response.Root;
import ua.com.company.utils.property.IvideonPropertiesReader;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedList;
import java.util.List;

public class IvideonConnection {
    private final Logger log = LogManager.getLogger(this);
    private final IvideonPropertiesReader ivideonPropertiesReader;

    public IvideonConnection(IvideonPropertiesReader ivideonPropertiesReader) {
        this.ivideonPropertiesReader = ivideonPropertiesReader;
    }

    public HttpResponse<String> makeAuthRequest() {

        Director director = new Director();
        AuthIvideonRequestBuilder authIvideonRequestBuilder = new AuthIvideonRequestBuilder();
        director.createAuthRequest(authIvideonRequestBuilder, ivideonPropertiesReader);
        HttpRequest request = authIvideonRequestBuilder.getResult();
        HttpResponse<String> response = null;
        try {
            response = authIvideonRequestBuilder.getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            log.error("Make Auth send error",e);
        }
        return response;

    }

    public List<Camera> makeMethodRequest() {
        Director director = new Director();
        MethodIvideonRequestBuilder methodIvideonRequestBuilder = new MethodIvideonRequestBuilder();
        director.createMethodRequest(methodIvideonRequestBuilder, ivideonPropertiesReader);
        HttpRequest request = methodIvideonRequestBuilder.getResult();
        HttpResponse<String> response = null;
        try {
            response = methodIvideonRequestBuilder.getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
log.error("Make method send error",e);        }
        Gson gson = new Gson();
        Root root = gson.fromJson(StringEscapeUtils.unescapeJava(response.body()), Root.class);

        List<Camera> cameras = new LinkedList<>();
        root.getResult().getItems().stream()
                .parallel()
                .forEach(item ->
                        cameras.addAll(
                                item.getCameras()));
        return cameras;

    }


}
