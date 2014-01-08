/**
 * 
 */
package uk.bl.wa.whois;

import org.jruby.embed.ScriptingContainer;

/**
 * @author Andrew Jackson <Andrew.Jackson@bl.uk>
 *
 */
public class JRubyWhois {

	ScriptingContainer container = new ScriptingContainer();
	
	public JRubyWhois() {
	}
    
	/**
	 * 
	 * @param domain
	 * @return
	 */
	public WhoisResult lookup(String domain) {
		
        container.put("domain", domain);
        return (WhoisResult) container.runScriptlet(JRubyWhois.class.getResourceAsStream("jruby-whois.rb"), "jruby-whois.rb");

	}

}
