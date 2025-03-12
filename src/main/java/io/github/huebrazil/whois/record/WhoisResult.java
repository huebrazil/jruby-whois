package io.github.huebrazil.whois.record;

import java.util.Date;
import java.util.List;

/**
 * The Class WhoisResult.
 */
// TODO: Auto-generated Javadoc
public class WhoisResult {

    private final String disclaimer;
    private final String domain;
    private final String domainId;
    private final List<String> status;
    private final boolean registered;
    private final boolean available;
    private final Date createdOn;
    private final Date updatedOn;
    private final Date expiresOn;
    private final WhoisRegistrar registrar;
    private final List<WhoisContact> registrantContacts;
    private final List<WhoisContact> adminContacts;
    private final List<WhoisContact> technicalContacts;
    private final List<WhoisNameserver> nameservers;
    private final List<WhoisPart> parts;

    /**
     * Instantiates a new whois result.
     *
     * @param disclaimer the disclaimer
     * @param domain the domain
     * @param domainId the domain id
     * @param status the status
     * @param registered the registered
     * @param available the available
     * @param createdOn the created on
     * @param updatedOn the updated on
     * @param expiresOn the expires on
     * @param registrar the registrar
     * @param registrantContacts the registrant contacts
     * @param adminContacts the admin contacts
     * @param technicalContacts the technical contacts
     * @param nameservers the nameservers
     * @param parts the parts
     */
    public WhoisResult(String disclaimer, String domain, String domainId,
            List<String> status, boolean registered, boolean available,
            Date createdOn, Date updatedOn, Date expiresOn,
            WhoisRegistrar registrar, List<WhoisContact> registrantContacts,
            List<WhoisContact> adminContacts,
            List<WhoisContact> technicalContacts,
            List<WhoisNameserver> nameservers, List<WhoisPart> parts) {
        super();
        this.disclaimer = disclaimer;
        this.domain = domain;
        this.domainId = domainId;
        this.status = status;
        this.registered = registered;
        this.available = available;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.expiresOn = expiresOn;
        this.registrar = registrar;
        this.registrantContacts = registrantContacts;
        this.adminContacts = adminContacts;
        this.technicalContacts = technicalContacts;
        this.nameservers = nameservers;
        this.parts = parts;
    }

    /**
     * Gets the disclaimer.
     *
     * @return the disclaimer
     */
    public String getDisclaimer() {
        return disclaimer;
    }

    /**
     * Gets the domain.
     *
     * @return the domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Gets the domain id.
     *
     * @return the domain id
     */
    public String getDomainId() {
        return domainId;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public List<String> getStatus() {
        return status;
    }

    /**
     * Checks if is registered.
     *
     * @return true, if is registered
     */
    public boolean isRegistered() {
        return registered;
    }

    /**
     * Checks if is available.
     *
     * @return true, if is available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Gets the created on.
     *
     * @return the created on
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * Gets the updated on.
     *
     * @return the updated on
     */
    public Date getUpdatedOn() {
        return updatedOn;
    }

    /**
     * Gets the expires on.
     *
     * @return the expires on
     */
    public Date getExpiresOn() {
        return expiresOn;
    }

    /**
     * Gets the registrar.
     *
     * @return the registrar
     */
    public WhoisRegistrar getRegistrar() {
        return registrar;
    }

    /**
     * Gets the registrant contacts.
     *
     * @return the registrant contacts
     */
    public List<WhoisContact> getRegistrantContacts() {
        return registrantContacts;
    }

    /**
     * Gets the admin contacts.
     *
     * @return the admin contacts
     */
    public List<WhoisContact> getAdminContacts() {
        return adminContacts;
    }

    /**
     * Gets the technical contacts.
     *
     * @return the technical contacts
     */
    public List<WhoisContact> getTechnicalContacts() {
        return technicalContacts;
    }

    /**
     * Gets the nameservers.
     *
     * @return the nameservers
     */
    public List<WhoisNameserver> getNameservers() {
        return nameservers;
    }

    /**
     * Gets the parts.
     *
     * @return the parts
     */
    public List<WhoisPart> getParts() {
        return parts;
    }

}
