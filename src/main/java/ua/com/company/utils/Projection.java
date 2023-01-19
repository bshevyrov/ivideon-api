package ua.com.company.utils;

public class Projection {
    private int id;
    private int owner;
    private int owner_name;
    private int created_at;
    private int first_online;
    private int last_online;
    private int last_offline;
    private int connected;
    private int online;
    private int name;
    private int plugins;
    private int mac_address;
    private int software_version;
    private int available_updates;
    private int network_type;
    private int features;
    private int is_bridge;
    private int has_alert_inputs;
    private Camera cameras ;
    private int _misc;
    private int _others;

    private Projection(){}
    public static Projection.Builder newBuilder(){
        return new Projection().new Builder();
    }
    public class Builder {

        private Builder() {
        }

    public Builder setCamera(Camera camera){
            Projection.this.cameras = camera;
            return this;
    }
        public Projection build() {
            return Projection.this;
        }


    }

}
