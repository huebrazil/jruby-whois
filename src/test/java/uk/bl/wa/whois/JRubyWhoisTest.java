/**
 * 
 */
package uk.bl.wa.whois;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Andrew Jackson <Andrew.Jackson@bl.uk>
 *
 */
public class JRubyWhoisTest {

	private JRubyWhois w;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		w = new JRubyWhois();
	}

	@Test
	public void testLookup() {
		WhoisResult r = w.lookup("bbc.co.uk");
		assertEquals(true, r.isUKRegistrant());
		
		r = w.lookup("marksandspencer.com");
		assertEquals(true, r.isUKRegistrant());
		
		
		r = w.lookup("goolge.com");
		assertEquals(false, r.isUKRegistrant());
		System.out.println("SAMPLE:"+r.getRecord().substring(0, 300).replace("\n\n", "\n")+"...");
		
	}

}
