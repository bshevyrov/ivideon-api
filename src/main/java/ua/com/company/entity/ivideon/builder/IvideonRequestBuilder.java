package ua.com.company.entity.ivideon.builder;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.Map;

public interface IvideonRequestBuilder { //TODO or CLASS with extends
default HttpClient  getHttpClient(){
    return HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    }
    void setPostData(HttpRequest.BodyPublisher body);

    void setHeader(Map<String, String> headers);

    void setUri(URI uri);


}
