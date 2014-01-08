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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScriptingContainer container = new ScriptingContainer();
        container.runScriptlet("require 'rubygems'; require 'Whois';");

        container.runScriptlet("puts \"TEST\n\"");
        
        container.runScriptlet("w = Whois::Client.new; w.lookup(\"google.com\").registered?");
        
        container.put("domain", "bbc.co.uk");
        String country = (String)container.runScriptlet("Whois.lookup(domain).parser.registrant_contacts[0].country");
        System.out.println("Country "+country);

        container.put("domain", "bbc.co.uk");
        String country_code = (String)container.runScriptlet("Whois.lookup(domain).parser.registrant_contacts[0].country_code");
        System.out.println("Country Code "+country_code);

	}

}
