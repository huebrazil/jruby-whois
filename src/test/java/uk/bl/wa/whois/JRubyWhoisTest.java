/**
 * 
 */
package uk.bl.wa.whois;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Before;
import org.junit.Test;

import uk.bl.wa.whois.record.WhoisContact;
import uk.bl.wa.whois.record.WhoisPart;
import uk.bl.wa.whois.record.WhoisResult;

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

//    @Test
    public void testMassiveLookup() throws IOException {
        InputStream inputStream = getClass()
                .getResourceAsStream("/domainNames");
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                inputStream));
        String domain = "salomon.com";
//        while ((domain = reader.readLine()) != null) {
            try {
                WhoisResult r = w.lookup(domain, 5);
                boolean printPart = true;
                System.out.println(r.getRegistrantContacts().size());
                System.out.println(r.getAdminContacts().size());
                System.out.println(r.getTechnicalContacts().size());
                for (WhoisContact contact : r.getRegistrantContacts()) {
                    if (contact.getEmail() == null) {
                        System.out.println(contact.getEmail());
                    } else {
                        printPart = false;
                        System.out.println(contact.getEmail());
                    }
                }
                if (printPart) {
                    for (WhoisPart part : r.getParts()) {
                        System.err.println(part.getHost());
                        System.err.println(part.getBody());
                    }
                }
            } catch (Exception e) {
                System.err.println(domain);
            }
//        }
    }
    
    @Test
    public void testHasNoParser() {
        assertFalse(w.hasParserFor("whois.corehub.net"));
    }
    
    @Test
    public void testHasParser() {
        assertTrue(w.hasParserFor("whois.verisign-grs.com"));
    }

}
