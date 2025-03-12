package com.github.huebrazil.whois;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.jruby.embed.LocalContextScope;
import org.jruby.embed.ScriptingContainer;
import org.junit.Before;
import org.junit.Test;

import com.github.huebrazil.whois.record.WhoisContact;
import com.github.huebrazil.whois.record.WhoisResult;

public class GoDaddyTest {

    ScriptingContainer container = new ScriptingContainer(LocalContextScope.CONCURRENT);
    
    private JRubyWhois w;

    @Before
    public void setUp() throws Exception {
        w = new JRubyWhois(true);
    }

    @Test
    public void coucou() throws IOException {
        InputStream resourceAsStream = GoDaddyTest.class.getResourceAsStream("/status_registered_bis_spec.rb");
        assertFalse(resourceAsStream == null);
        container.put("content", readInputStreamAsString(GoDaddyTest.class
                .getResourceAsStream("/fixtures/responses/whois.godaddy.com/status_registered_bis.txt")));
        WhoisContact res = (WhoisContact) container.runScriptlet(resourceAsStream, "status_registered_bis_spec.rb");
        assertEquals("allan.hull@bcbsne.com", res.getEmail());
    }
    
    @Test
    public void toctoc() throws IOException {
        
        String rawData = readInputStreamAsString(GoDaddyTest.class
                .getResourceAsStream("/fixtures/responses/whois.godaddy.com/status_registered_bis.txt"));
        WhoisResult res = w.parseResult("whois.godaddy.com", rawData);
        assertEquals("allan.hull@bcbsne.com", res.getTechnicalContacts().get(0).getEmail());
    }

    public static String readInputStreamAsString(InputStream in) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(in);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int result = bis.read();
        while (result != -1) {
            byte b = (byte) result;
            buf.write(b);
            result = bis.read();
        }
        return buf.toString();
    }
}
