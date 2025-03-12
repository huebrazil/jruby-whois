package io.github.huebrazil.whois.record;

/**
 * The Class WhoisPart.
 */
// TODO: Auto-generated Javadoc
public class WhoisPart {
    private final String body;
    private final String host;

    /**
     * Instantiates a new whois part.
     *
     * @param body the body
     * @param host the host
     */
    public WhoisPart(String body, String host) {
        super();
        this.body = body;
        this.host = host;
    }

    /**
     * Gets the body.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Gets the host.
     *
     * @return the host
     */
    public String getHost() {
        return host;
    }

}
