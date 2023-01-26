package ua.com.company.entity.ivideon.entity.ivideon;


import com.google.gson.Gson;

import java.net.http.HttpResponse;

public class IvideonAccount {

    private static IvideonAccount instance;
//    private   static IvideonPropertiesReader ivideonPropertiesReader = new IvideonPropertiesReader("src/main/resources/ivideon.properties");



    public static IvideonAccount getInstance() {

        return instance;
    }

    public static void createFromHttpResponse (HttpResponse<String> response ) {
        instance = new Gson().fromJson(response.body(), IvideonAccount.class);
    }

    private IvideonAccount() {
//        IvideonConnection ivideonConnection = new IvideonConnection(ivideonPropertiesReader);
//        String authResponse =ivideonConnection.makeAuthRequest();
//        Gson gson = new Gson();
//        instance=gson.fromJson(authResponse, IvideonAccount.class);
    }
    
    private  String token_type;
    private  String access_token;
    private  Long owner_id;
    private  String hmac_secret;
    private  String public_id;
    private  String api_host;
    private  String api5_host;
    private  String api4_host;
    private  String api_ws_host;
    private  String scope;
    private  int expires_in;
    private  String client_type;
    private  String device_instance_id;
    private  String client_version;
    private  String refresh_token;

//    public IvideonAccount(String token_type, String access_token, Long owner_id, String hmac_secret, String public_id, String api_host, String api5_host, String api4_host, String api_ws_host, String scope, int expires_in, String client_type, String device_instance_id, String client_version, String refresh_token) {
//        this.token_type = token_type;
//        this.access_token = access_token;
//        this.owner_id = owner_id;
//        this.hmac_secret = hmac_secret;
//        this.public_id = public_id;
//        this.api_host = api_host;
//        this.api5_host = api5_host;
//        this.api4_host = api4_host;
//        this.api_ws_host = api_ws_host;
//        this.scope = scope;
//        this.expires_in = expires_in;
//        this.client_type = client_type;
//        this.device_instance_id = device_instance_id;
//        this.client_version = client_version;
//        this.refresh_token = refresh_token;
//    }

    @Override
    public String toString() {
        return "IvideonAccount{" +
                "token_type='" + token_type + '\'' +
                ", access_token='" + access_token + '\'' +
                ", owner_id=" + owner_id +
                ", hmac_secret='" + hmac_secret + '\'' +
                ", public_id='" + public_id + '\'' +
                ", api_host='" + api_host + '\'' +
                ", api5_host='" + api5_host + '\'' +
                ", api4_host='" + api4_host + '\'' +
                ", api_ws_host='" + api_ws_host + '\'' +
                ", scope='" + scope + '\'' +
                ", expires_in=" + expires_in +
                ", client_type='" + client_type + '\'' +
                ", device_instance_id='" + device_instance_id + '\'' +
                ", client_version='" + client_version + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                '}';
    }

    public String getAccess_token() {
        return access_token;
    }

    public Long getOwner_id() {
        return owner_id;
    }
}
