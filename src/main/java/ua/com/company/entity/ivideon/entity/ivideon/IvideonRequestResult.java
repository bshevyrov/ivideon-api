package ua.com.company.entity.ivideon.entity.ivideon;

public class IvideonRequestResult {
    private Boolean success;
    private IvideonServer result;

    private IvideonRequestResult() {
    }

    public IvideonServer getResult() {
        return result;
    }
}
