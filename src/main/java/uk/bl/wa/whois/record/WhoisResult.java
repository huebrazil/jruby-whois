package uk.bl.wa.whois.record;

import java.util.Date;
import java.util.List;

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

    public String getDisclaimer() {
        return disclaimer;
    }

    public String getDomain() {
        return domain;
    }

    public String getDomainId() {
        return domainId;
    }

    public List<String> getStatus() {
        return status;
    }

    public boolean isRegistered() {
        return registered;
    }

    public boolean isAvailable() {
        return available;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public Date getExpiresOn() {
        return expiresOn;
    }

    public WhoisRegistrar getRegistrar() {
        return registrar;
    }

    public List<WhoisContact> getRegistrantContacts() {
        return registrantContacts;
    }

    public List<WhoisContact> getAdminContacts() {
        return adminContacts;
    }

    public List<WhoisContact> getTechnicalContacts() {
        return technicalContacts;
    }

    public List<WhoisNameserver> getNameservers() {
        return nameservers;
    }

    public List<WhoisPart> getParts() {
        return parts;
    }

}
