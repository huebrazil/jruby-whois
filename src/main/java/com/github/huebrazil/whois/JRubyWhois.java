package com.github.huebrazil.whois;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.jruby.embed.EvalFailedException;
import org.jruby.embed.LocalContextScope;
import org.jruby.embed.ScriptingContainer;

import com.github.huebrazil.whois.exceptions.ServerNotFoundException;
import com.github.huebrazil.whois.exceptions.WebInterfaceErrorException;
import com.github.huebrazil.whois.record.WhoisResult;

public class JRubyWhois {

	ScriptingContainer container = new ScriptingContainer(LocalContextScope.CONCURRENT);

	public JRubyWhois() {
		this(false);
	}

	/**
	 * @param debug Set to false to disable ruby stderr/stdout
	 */
	public JRubyWhois(boolean debug) {
		if (!debug) {
			PrintStream printStream = new PrintStream(new OutputStream() {
				@Override
				public void write(int b) throws IOException {
				}
			});
			container.setError(printStream);
			container.setOutput(printStream);
		}
	}

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
	 * @param domain  domain name to lookup
	 * @param timeout timeout in seconds
	 * @return
	 */
	public WhoisResult lookup(String domain, int timeout) {
		container.put("domain", domain);
		container.put("timeout_param", timeout);
		try {
			return (WhoisResult) container.runScriptlet(JRubyWhois.class.getResourceAsStream("jruby-whois.rb"),
					"jruby-whois.rb");
		} catch (EvalFailedException e) {
			if (e.getMessage().startsWith("(ServerNotFound)")) {
				throw new ServerNotFoundException(e);
			}
			if (e.getMessage().startsWith("(WebInterfaceError")) {
				throw new WebInterfaceErrorException(e);
			}
			throw e;
		}
	}
	
	/**
	 * Uses the Ruby Whois gem to perform a whois lookup
	 * 
	 * @param domain  domain name to lookup
	 * @param timeout timeout in seconds
	 * @return
	 */
	public WhoisResult parseResult(String server, String rawData) {
		container.put("server", server);
		container.put("data", rawData);
		try {
			return (WhoisResult) container.runScriptlet(JRubyWhois.class.getResourceAsStream("jruby-parse-raw.rb"),
					"jruby-parse-raw.rb");
		} catch (EvalFailedException e) {
			if (e.getMessage().startsWith("(ServerNotFound)")) {
				throw new ServerNotFoundException(e);
			}
			if (e.getMessage().startsWith("(WebInterfaceError")) {
				throw new WebInterfaceErrorException(e);
			}
			throw e;
		}
	}

	/**
	 * Check if Ruby Whois gem has a parser for a specific registrar
	 * 
	 * @param whoisHost whois server to check
	 * @return
	 */
	public boolean hasParserForWhoisHost(String whoisHost) {
		container.put("host", whoisHost);
		return (Boolean) container.runScriptlet(JRubyWhois.class.getResourceAsStream("jruby-has-parser.rb"),
				"jruby-has-parser.rb");
	}
}
