package uk.bl.wa.whois.record;

import java.util.Date;

public class WhoisContact {
    private final String address;

    private final String city;

    private final String country;

    private final String country_code;

    private final Date created_on;

    private final String email;

    private final String fax;

    private final String id;

    private final String name;

    private final String organization;

    private final String phone;

    private final String state;

    private final int type;

    private final Date updated_on;

    private final String url;

    private final String zip;

    public WhoisContact(String address, String city, String country,
            String country_code, Date created_on, String email, String fax,
            String id, String name, String organization, String phone,
            String state, int type, Date updated_on, String url, String zip) {
        super();
        this.address = address;
        this.city = city;
        this.country = country;
        this.country_code = country_code;
        this.created_on = created_on;
        this.email = email;
        this.fax = fax;
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.phone = phone;
        this.state = state;
        this.type = type;
        this.updated_on = updated_on;
        this.url = url;
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getCountry_code() {
        return country_code;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public String getEmail() {
        return email;
    }

    public String getFax() {
        return fax;
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

    public String getPhone() {
        return phone;
    }

    public String getState() {
        return state;
    }

    public int getType() {
        return type;
    }

    public Date getUpdated_on() {
        return updated_on;
    }

    public String getUrl() {
        return url;
    }

    public String getZip() {
        return zip;
    }
}
