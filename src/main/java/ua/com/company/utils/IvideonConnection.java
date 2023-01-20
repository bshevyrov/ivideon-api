package ua.com.company.utils;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringEscapeUtils;
import ua.com.company.entity.ivideon.builder.AuthIvideonRequestMethod;
import ua.com.company.entity.ivideon.builder.Director;
import ua.com.company.entity.ivideon.entity.IvideonAccount;
import ua.com.company.utils.property.IvideonPropertiesReader;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class IvideonConnection {
    private final IvideonPropertiesReader ivideonPropertiesReader;
    private IvideonAccount ivideonAccount;
    private final String IVIDEON_API_URL = "https://openapi-alpha.ivideon.com";

    public IvideonConnection(IvideonPropertiesReader ivideonPropertiesReader) {
        this.ivideonPropertiesReader = ivideonPropertiesReader;
    }

//    public final HttpClient httpClient = HttpClient.newBuilder()
//            .version(HttpClient.Version.HTTP_1_1)
//            .connectTimeout(Duration.ofSeconds(10))
//            .build();

//    public Map<Object, Object> createBody() {
//        Map<Object, Object> data = new HashMap<>();
//        data.put("grant_type", "password");//required
//        data.put("client_version", "54.2.1");
//        data.put("device_type", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/109.0");//required
//        data.put("device_instance_id", "dCPO2lh9C3QbbqHr");
//        data.put("username", ivideonPropertiesReader.getIvideonLogin());//required
//        data.put("password", ivideonPropertiesReader.getIvideonPassword());//required
//        data.put("trusted_device", "true");
//        return data;
//    }

    public String connectToApi() throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .POST(ofFormData(createBody()))
//                .uri(URI.create(IVIDEON_API_URL + "/auth/oauth/token"))
//                .setHeader("Content-Type", "application/x-www-form-urlencoded")
//                .header("Authorization", "Basic d2ViLWNsaWVudA==")// base 64 encode "web-client"
//                .build();


        Director director = new Director();
        AuthIvideonRequestMethod authIvideonRequestMethod = new AuthIvideonRequestMethod();
        director.createAuthRequest(authIvideonRequestMethod, ivideonPropertiesReader);
        HttpRequest request = authIvideonRequestMethod.getResult();
        HttpResponse<String> response = authIvideonRequestMethod.getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
//        Gson gson = new Gson();
//        ivideonAccount = gson.fromJson(response.body(), IvideonAccount.class);
//        //todo builder
//        Camera camera = Camera.newBuilder()
//                .setName(1)
//                .setCameraConnected(1)
//                .setCameraMode(1)
//                .setCameraOnline(1)
//                .build();
//        Projection projection = Projection.newBuilder()
//                .setCamera(camera)
//                .build();
//        IvideonRequest ivideonRequest = IvideonRequest.newBuilder()
//                .setProjection(projection)
//                .setUser(ivideonAccount.getOwner_id())
//                .build();
//
//        return StringEscapeUtils.unescapeJava(getData(ivideonAccount,
//                gson.toJson(
//                        ivideonRequest)
//                , "FIND"));

    }

    /*public String getData(IvideonAccount ivideonAccount, String json, String method) throws IOException, InterruptedException {
        // add json header
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create(IVIDEON_API_URL + "/servers?op=" + method))
                .setHeader("Content-Type", "application/json")
                .header("Authorization", "Bearer " + ivideonAccount.getAccess_token())
                .build();
//        System.out.println(HttpResponse.BodyHandlers.ofString().toString());
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }*/

//    public static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
//        var builder = new StringBuilder();
//        for (Map.Entry<Object, Object> entry : data.entrySet()) {
//            if (builder.length() > 0) {
//                builder.append("&");
//            }
//            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
//            builder.append("=");
//            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
//        }
//        return HttpRequest.BodyPublishers.ofString(builder.toString());
//    }

//    private String getBasicAuthenticationHeader(String username, String password) {
//        String valueToEncode = username + ":" + password;
//        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
//    }


}
