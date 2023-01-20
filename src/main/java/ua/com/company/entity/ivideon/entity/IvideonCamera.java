package ua.com.company.entity.ivideon.entity;

public class IvideonCamera {

    private String id;
    private String server;
    private String name;
    private String created_at;
    private String first_online;
    private String last_online;
    private String last_offline;
    private boolean connected;
    private boolean online;
    private int width;
    private int height;
    private String rotation;
    private boolean sound_enabled;
    private String mode;
    private String[] features;
    private String timezone;
    private String[] permissions;
    private String web_player;
    // List of objects???? private String       services;
    private double[] geo;
    private String grantee_count;
    private String is_cross_line_counter;
    private String analytics_info;
    private String prepaid_plan;
    private String uin;
    private String serial_number;
    private String device_model;
    private String vendor;
    private String subscriptions;
    // Object with inner class ???? private String       _misc;
    // private String       _others:0;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
