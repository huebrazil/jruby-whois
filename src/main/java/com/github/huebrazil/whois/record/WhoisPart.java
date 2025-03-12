package com.github.huebrazil.whois.record;

public class WhoisPart {
    private final String body;
    private final String host;

    public WhoisPart(String body, String host) {
        super();
        this.body = body;
        this.host = host;
    }

    public String getBody() {
        return body;
    }

    public String getHost() {
        return host;
    }

}
