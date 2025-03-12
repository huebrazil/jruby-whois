package com.github.huebrazil.whois.record;

public class WhoisRegistrar {
    private final String id;

    private final String name;

    private final String organization;

    private final String url;

    public WhoisRegistrar(String id, String name, String organization, String url) {
        super();
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOrganization() {
        return organization;
    }

    public String getUrl() {
        return url;
    }

}
