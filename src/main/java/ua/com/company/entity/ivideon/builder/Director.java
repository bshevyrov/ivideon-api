package ua.com.company.entity.ivideon.builder;

import com.google.gson.Gson;
import ua.com.company.entity.ivideon.entity.ivideon.IvideonAccount;
import ua.com.company.utils.CameraRequest;
import ua.com.company.utils.IvideonRequest;
import ua.com.company.utils.Projection;
import ua.com.company.utils.property.IvideonPropertiesReader;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Director {
    private final String IVIDEON_API_URL = "https://openapi-alpha.ivideon.com";
    private final String IVIDEON_AUTH_METHOD_PATH = "/auth/oauth/token";
    private final String IVIDEON_FIND_METHOD_PATH = "/servers?op=FIND";

    public void createAuthRequest(IvideonRequestBuilder builder, IvideonPropertiesReader property) {
        builder.setHeader(createIvideonAuthHeader());
        builder.setUri(URI.create(IVIDEON_API_URL + IVIDEON_AUTH_METHOD_PATH));
        builder.setPostData(ofFormData(
                createBodyAuthRequest(property)));

    }

    public void createMethodRequest(IvideonRequestBuilder builder, IvideonPropertiesReader property) {
        builder.setHeader(createIvideonMethodHeader());
        builder.setUri(URI.create(IVIDEON_API_URL + IVIDEON_FIND_METHOD_PATH));
        builder.setPostData(HttpRequest.BodyPublishers.ofString(createBodyMethodRequest()));
    }

    private String createBodyMethodRequest() {
        Gson gson = new Gson();
        CameraRequest camera = CameraRequest.newBuilder()
                .setName(1)
                .setCameraConnected(1)
                .setCameraMode(1)
                .setCameraOnline(1)
                .build();
        Projection projection = Projection.newBuilder()
                .setCamera(camera)
                .build();
        IvideonRequest ivideonRequest = IvideonRequest.newBuilder()
                .setProjection(projection)
                .setUser(IvideonAccount.getInstance().getOwner_id())
                .build();
        return gson.toJson(ivideonRequest);

    }

    private Map<String, String> createIvideonAuthHeader() {
        Map<String, String> authHeaders = new LinkedHashMap<>();
        authHeaders.put("Content-Type", "application/x-www-form-urlencoded");
        authHeaders.put("Authorization", "Basic d2ViLWNsaWVudA==");// base 64 encode
        return authHeaders;
    }


    private Map<String, String> createIvideonMethodHeader() {
        Map<String, String> methodHeaders = new LinkedHashMap<>();
        methodHeaders.put("Content-Type", "application/json");
        methodHeaders.put("Authorization", "Bearer " + IvideonAccount.getInstance().getAccess_token());// base 64 encode
        return methodHeaders;
    }

    private HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }

    public Map<Object, Object> createBodyAuthRequest(IvideonPropertiesReader ivideonPropertiesReader) {
        Map<Object, Object> data = new HashMap<>();
        data.put("grant_type", "password");//required
        data.put("client_version", "54.2.1");
        data.put("device_type", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/109.0");//required
        data.put("device_instance_id", "dCPO2lh9C3QbbqHr");
        data.put("username", ivideonPropertiesReader.getIvideonLogin());//required
        data.put("password", ivideonPropertiesReader.getIvideonPassword());//required
        data.put("trusted_device", "true");
        return data;
    }


}


