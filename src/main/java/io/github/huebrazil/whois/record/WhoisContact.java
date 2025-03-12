package io.github.huebrazil.whois.record;

import java.util.Date;

/**
 * The Class WhoisContact.
 */
// TODO: Auto-generated Javadoc
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

    /**
     * Instantiates a new whois contact.
     *
     * @param address the address
     * @param city the city
     * @param country the country
     * @param country_code the country code
     * @param created_on the created on
     * @param email the email
     * @param fax the fax
     * @param id the id
     * @param name the name
     * @param organization the organization
     * @param phone the phone
     * @param state the state
     * @param type the type
     * @param updated_on the updated on
     * @param url the url
     * @param zip the zip
     */
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

    /**
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets the country code.
     *
     * @return the country code
     */
    public String getCountry_code() {
        return country_code;
    }

    /**
     * Gets the created on.
     *
     * @return the created on
     */
    public Date getCreated_on() {
        return created_on;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the fax.
     *
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the organization.
     *
     * @return the organization
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * Gets the phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * Gets the updated on.
     *
     * @return the updated on
     */
    public Date getUpdated_on() {
        return updated_on;
    }

    /**
     * Gets the url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Gets the zip.
     *
     * @return the zip
     */
    public String getZip() {
        return zip;
    }
}
