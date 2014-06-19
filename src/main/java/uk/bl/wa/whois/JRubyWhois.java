package uk.bl.wa.whois;

import org.jruby.embed.LocalContextScope;
import org.jruby.embed.ScriptingContainer;

import uk.bl.wa.whois.record.WhoisResult;

/**
 * @author Andrew Jackson <Andrew.Jackson@bl.uk>
 * 
 */
public class JRubyWhois {

    ScriptingContainer container = new ScriptingContainer(
            LocalContextScope.SINGLETON);

    /**
     * 
     * Uses the Ruby Whois gem to perform a whois lookup.
     * 
     * Also checks if the registrant appears to be in the UK.
     * 
     * @param domain
     * @return
     */
    public WhoisResult lookup(String domain) {

        return lookup(domain, 30);

    }

    public WhoisResult lookup(String domain, int timeout) {

        container.put("domain", domain);
        container.put("timeout_param", timeout);
        return (WhoisResult) container.runScriptlet(
                JRubyWhois.class.getResourceAsStream("jruby-whois.rb"),
                "jruby-whois.rb");

    }

    public boolean hasParserForWhoisHost(String whoisHost) {
        container.put("host", whoisHost);
        return (boolean) container.runScriptlet(
                JRubyWhois.class.getResourceAsStream("jruby-has-parser.rb"),
                "jruby-has-parser.rb");
    }
}
