package uk.bl.wa.whois.record;

public class WhoisNameserver {
    private final String ipv4;
    private final String ipv6;
    private final String name;

    public WhoisNameserver(String ipv4, String ipv6, String name) {
        super();
        this.ipv4 = ipv4;
        this.ipv6 = ipv6;
        this.name = name;
    }

    @Override
    public final String toString() {
        return "WhoisNameserver [ipv4=" + ipv4 + ", ipv6=" + ipv6 + ", name="
                + name + "]";
    }

    public String getIpv4() {
        return ipv4;
    }

    public String getIpv6() {
        return ipv6;
    }

    public String getName() {
        return name;
    }

}
