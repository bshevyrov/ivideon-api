package ua.com.company.utils;

public class IvideonRequest {

    private long user;
    private int limit = 300;
    private int skip;
    private boolean include_all;

    private Projection projection;

    private IvideonRequest() {
    }

    public static IvideonRequest.Builder newBuilder() {
        return new IvideonRequest().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setUser(Long user) {
            IvideonRequest.this.user = user;
            return this;
        }

        public Builder setProjection(Projection projection) {
            IvideonRequest.this.projection = projection;
            return this;
        }

        public IvideonRequest build() {
            return IvideonRequest.this;
        }
    }
}



