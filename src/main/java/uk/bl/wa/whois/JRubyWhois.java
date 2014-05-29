/**
 * 
 */
package uk.bl.wa.whois;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import org.jruby.embed.ScriptingContainer;

/**
 * @author Andrew Jackson <Andrew.Jackson@bl.uk>
 *
 */
public class JRubyWhois {

	ScriptingContainer container = new ScriptingContainer();
	
	public JRubyWhois() {
		/*
		ArrayList<String> paths = new ArrayList<String>();
		String path = JRubyWhois.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String decodedPath;
		try {
			decodedPath = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return;
		}
		paths.add(decodedPath+"!/gems/whois-3.4.2");
		container.setLoadPaths( paths );
		*/
	}
    
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
		
        container.put("domain", domain);
        return (WhoisResult) container.runScriptlet(JRubyWhois.class.getResourceAsStream("jruby-whois.rb"), "jruby-whois.rb");

	}

	public static void main( String argv[] ) {
		JRubyWhois w = new JRubyWhois();
		System.out.println("Whois: "+w.lookup("bbc.co.uk").isUKRegistrant());		
	}
}
