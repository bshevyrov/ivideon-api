package ua.com.company.entity.ivideon.entity.ivideon;

public class IvideonServer {

//    private String id;
//    private Long owner;
//    private String owner_name;
//    private Boolean connected;
//    private Boolean online;
//    private String name;
//    private Double created_at;
//    private Double first_online;
//    private Double last_online;
//    private Double last_offline;
    private IvideonCamera[] cameras;

    private IvideonServer() {
    }

    public IvideonCamera[] getCameras() {
        return cameras;
    }
}
