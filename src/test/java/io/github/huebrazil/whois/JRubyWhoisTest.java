/**
 * 
 */
package io.github.huebrazil.whois;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import io.github.huebrazil.whois.JRubyWhois;
import io.github.huebrazil.whois.exceptions.ServerNotFoundException;
import io.github.huebrazil.whois.exceptions.WebInterfaceErrorException;
import io.github.huebrazil.whois.record.WhoisResult;

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
        assertEquals("2000-07-26", new SimpleDateFormat("yyyy-MM-dd").format(r.getCreatedOn()));
    }

    @Test
    public void testHasNoParser() {
        assertFalse(w.hasParserForWhoisHost("whois.corehub.net"));
    }

    @Test
    public void testHasParser() {
        assertTrue(w.hasParserForWhoisHost("whois.jprs.jp"));
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
