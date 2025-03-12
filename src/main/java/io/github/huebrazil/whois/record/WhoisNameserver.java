package io.github.huebrazil.whois.record;

/**
 * The Class WhoisNameserver.
 */
// TODO: Auto-generated Javadoc
public class WhoisNameserver {
    private final String ipv4;
    private final String ipv6;
    private final String name;

    /**
     * Instantiates a new whois nameserver.
     *
     * @param ipv4 the ipv 4
     * @param ipv6 the ipv 6
     * @param name the name
     */
    public WhoisNameserver(String ipv4, String ipv6, String name) {
        super();
        this.ipv4 = ipv4;
        this.ipv6 = ipv6;
        this.name = name;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public final String toString() {
        return "WhoisNameserver [ipv4=" + ipv4 + ", ipv6=" + ipv6 + ", name="
                + name + "]";
    }

    /**
     * Gets the ipv 4.
     *
     * @return the ipv 4
     */
    public String getIpv4() {
        return ipv4;
    }

    /**
     * Gets the ipv 6.
     *
     * @return the ipv 6
     */
    public String getIpv6() {
        return ipv6;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

}
