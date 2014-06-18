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

    @Test
    public void testMassiveLookup() throws IOException {
        InputStream inputStream = getClass()
                .getResourceAsStream("/domainNames");
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                inputStream));
        String domain;
        w.lookup("salomonshoes.com.au");
        while ((domain = reader.readLine()) != null) {
            try {
                WhoisResult r = w.lookup(domain, 5);
                for (WhoisContact contact : r.getRegistrantContacts()) {
                    System.out.println(contact.getEmail() + " "
                            + contact.getOrganization());
                }
            } catch (Exception e) {
                System.err.println(domain);
            }
        }
    }

}
