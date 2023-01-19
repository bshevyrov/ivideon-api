package ua.com.company.entity.ivideon;

public class IvideonAccount {
    private final String token_type;
    private final String access_token;
    private final Long owner_id;
    private final String hmac_secret;
    private final String public_id;
    private final String api_host;
    private final String api5_host;
    private final String api4_host;
    private final String api_ws_host;
    private final String scope;
    private final int expires_in;
    private final String client_type;
    private final String device_instance_id;
    private final String client_version;
    private final String refresh_token;

    public IvideonAccount(String token_type, String access_token, Long owner_id, String hmac_secret, String public_id, String api_host, String api5_host, String api4_host, String api_ws_host, String scope, int expires_in, String client_type, String device_instance_id, String client_version, String refresh_token) {
        this.token_type = token_type;
        this.access_token = access_token;
        this.owner_id = owner_id;
        this.hmac_secret = hmac_secret;
        this.public_id = public_id;
        this.api_host = api_host;
        this.api5_host = api5_host;
        this.api4_host = api4_host;
        this.api_ws_host = api_ws_host;
        this.scope = scope;
        this.expires_in = expires_in;
        this.client_type = client_type;
        this.device_instance_id = device_instance_id;
        this.client_version = client_version;
        this.refresh_token = refresh_token;
    }

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
