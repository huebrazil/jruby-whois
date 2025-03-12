package io.github.huebrazil.whois.record;

/**
 * The Class WhoisRegistrar.
 */
// TODO: Auto-generated Javadoc
public class WhoisRegistrar {
    private final String id;

    private final String name;

    private final String organization;

    private final String url;

    /**
     * Instantiates a new whois registrar.
     *
     * @param id the id
     * @param name the name
     * @param organization the organization
     * @param url the url
     */
    public WhoisRegistrar(String id, String name, String organization, String url) {
        super();
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.url = url;
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
     * Gets the url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

}
