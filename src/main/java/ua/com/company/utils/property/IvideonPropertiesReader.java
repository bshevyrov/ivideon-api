package ua.com.company.utils.property;

public class IvideonPropertiesReader extends PropertiesReader{

    public IvideonPropertiesReader(String path) {
        super(path);
    }

    /**
     * @return String value of "ivideon.login" from property
     */
    public String getIvideonLogin() {
        return super.prop.getProperty("ivideon.login");
    }

    /**
     * @return String value of "ivideon.password" from property
     */
    public String getIvideonPassword() {
        return super.prop.getProperty("ivideon.password");
    }

}
