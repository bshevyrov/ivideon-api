package ua.com.company.entity.ivideon.builder;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodIvideonRequestBuilder implements IvideonRequestBuilder {
    private HttpRequest.BodyPublisher body;
    private URI uri;
    //    private Map<String, String> headers;
    private String[] stringRepresentationOfHeaders;

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
        String[] headerStr = new String[headers.size()*2];
        List<Map.Entry<String,String>> list = new ArrayList<>(headers.entrySet());
        int x =0;
        for (int i = 0; i < list.size(); i++) {
            headerStr[x++]=list.get(i).getKey();
            headerStr[x++]=list.get(i).getValue();
        }
        this.stringRepresentationOfHeaders = headerStr;
    }

    public HttpRequest getResult() {
        return HttpRequest.newBuilder()
                .POST(body)
                .uri(uri)
                .headers(stringRepresentationOfHeaders)//wrap
                .build();
    }
}
