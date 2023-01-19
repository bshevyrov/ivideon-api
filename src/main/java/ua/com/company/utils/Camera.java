package ua.com.company.utils;

public class Camera {
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

    private Camera() {
    }

    public static Builder newBuilder() {
        return new Camera().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Camera.Builder setUser(int id) {
            Camera.this.id = id;
            return this;
        }

        public Camera.Builder setName(int name) {
            Camera.this.name = name;
            return this;
        }


        public Camera.Builder setCameraOnline(int id) {
            Camera.this.online = id;
            return this;
        }

        public Camera.Builder setCameraConnected(int id) {
            Camera.this.connected = id;
            return this;
        }

        public Camera.Builder setCameraMode(int id) {
            Camera.this.mode = id;
            return this;
        }

        public Camera build() {
            return Camera.this;
        }


    }
}
