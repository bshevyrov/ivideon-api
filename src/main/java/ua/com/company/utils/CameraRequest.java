package ua.com.company.utils;

public class CameraRequest {
    private int id;
    private int server;
    private int name;
    private int created_at;
    private int first_online;
    private int last_online;
    private int last_offline;
    private int connected;
    private int online;
    private int width;
    private int height;
    private int rotation;
    private int sound_enabled;
    private int mode;
    private int features;
    private int timezone;
    private int permissions;
    private int web_player;
    private int services;
    private int geo;
    private int grantee_count;
    private int is_cross_line_counter;
    private int analytics_info;
    private int prepaid_plan;
    private int uin;
    private int serial_number;
    private int device_model;
    private int vendor;
    private int subscriptions;
    private int _misc;
    private int _others;

    private CameraRequest() {
    }

    public static Builder newBuilder() {
        return new CameraRequest().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public CameraRequest.Builder setUser(int id) {
            CameraRequest.this.id = id;
            return this;
        }

        public CameraRequest.Builder setName(int name) {
            CameraRequest.this.name = name;
            return this;
        }


        public CameraRequest.Builder setCameraOnline(int id) {
            CameraRequest.this.online = id;
            return this;
        }

        public CameraRequest.Builder setCameraConnected(int id) {
            CameraRequest.this.connected = id;
            return this;
        }

        public CameraRequest.Builder setCameraMode(int id) {
            CameraRequest.this.mode = id;
            return this;
        }

        public CameraRequest build() {
            return CameraRequest.this;
        }


    }
}
