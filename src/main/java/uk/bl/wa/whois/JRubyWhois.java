package uk.bl.wa.whois;

import org.jruby.embed.LocalContextScope;
import org.jruby.embed.ScriptingContainer;

import uk.bl.wa.whois.record.WhoisResult;

public class JRubyWhois {

    ScriptingContainer container = new ScriptingContainer(
            LocalContextScope.CONCURRENT);

    /**
     * 
     * Uses the Ruby Whois gem to perform a whois lookup.
     * 
     * @param domain domain name to lookup
     * @return
     */
    public WhoisResult lookup(String domain) {
        return lookup(domain, 30);
    }

    /**
     * Uses the Ruby Whois gem to perform a whois lookup
     * 
     * @param domain domain name to lookup
     * @param timeout timeout in seconds
     * @return
     */
    public WhoisResult lookup(String domain, int timeout) {
        container.put("domain", domain);
        container.put("timeout_param", timeout);
        return (WhoisResult) container.runScriptlet(
                JRubyWhois.class.getResourceAsStream("jruby-whois.rb"),
                "jruby-whois.rb");

    }

    /**
     * Check if Ruby Whois gem has a parser for a specific registrar
     * 
     * @param whoisHost whois server to check
     * @return 
     */
    public boolean hasParserForWhoisHost(String whoisHost) {
        container.put("host", whoisHost);
        return (boolean) container.runScriptlet(
                JRubyWhois.class.getResourceAsStream("jruby-has-parser.rb"),
                "jruby-has-parser.rb");
    }
}
