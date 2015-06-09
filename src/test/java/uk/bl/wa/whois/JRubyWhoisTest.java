/**
 * 
 */
package uk.bl.wa.whois;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import uk.bl.wa.whois.exceptions.ServerNotFoundException;
import uk.bl.wa.whois.exceptions.WebInterfaceErrorException;
import uk.bl.wa.whois.record.WhoisResult;

public class JRubyWhoisTest {

    private JRubyWhois w;

    @Before
    public void setUp() throws Exception {
        w = new JRubyWhois(true);
    }

    @Test
    public void testMassiveLookup() throws IOException, ParseException {
        String domain = "google.fr";
        WhoisResult r = w.lookup(domain, 60);
        assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2000-07-27"), r.getCreatedOn());
    }

    @Test
    public void testHasNoParser() {
        assertFalse(w.hasParserForWhoisHost("whois.corehub.net"));
    }

    @Test
    public void testHasParser() {
        assertTrue(w.hasParserForWhoisHost("whois.verisign-grs.com"));
    }

    @Test
    public void testHasNoParserWhenNull() {
        assertFalse(w.hasParserForWhoisHost(null));
    }

    @Test
    public void testHasNoParserWhenEmpty() {
        assertFalse(w.hasParserForWhoisHost(""));
    }

    @Test(expected = ServerNotFoundException.class)
    public void testServerNotFoundException() {
        w.lookup("google.unexistantTLD");
    }

    @Test(expected = WebInterfaceErrorException.class)
    public void testWebInterfaceError() {
        w.lookup("google.mt");
    }

}
