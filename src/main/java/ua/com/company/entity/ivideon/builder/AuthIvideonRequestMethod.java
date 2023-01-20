package ua.com.company.entity.ivideon.builder;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AuthIvideonRequestMethod implements IvideonRequestBuilder {
    private HttpRequest.BodyPublisher body;
    private URI uri;
    //    private Map<String, String> headers;
    private String[] stringRepresentationOfheaders;

    @Override
    public void setPostData(HttpRequest.BodyPublisher body) {
        this.body = body;
    }

    @Override
    public void setUri(URI uri) {
        this.uri = uri;

    }

    @Override
    public void setHeader(Map<String, String> headers) {
        String[] headerStr = new String[headers.size()];
        AtomicInteger i = new AtomicInteger();
       headers.entrySet().forEach(stringStringEntry -> {
           headerStr[i.getAndIncrement()]=stringStringEntry.getKey();
           headerStr[i.getAndIncrement()]=stringStringEntry.getValue();});

        this.stringRepresentationOfheaders = headerStr;
    }

    public HttpRequest getResult() {
        return HttpRequest.newBuilder()
                .POST(body)
                .uri(uri)
                .headers(stringRepresentationOfheaders)//wrap
                .build();
    }
}
