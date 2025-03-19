package io.github.huebrazil.whois;

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

import io.github.huebrazil.whois.record.WhoisContact;

public class JprsTest {

	ScriptingContainer container = new ScriptingContainer(LocalContextScope.CONCURRENT);

	private JRubyWhois w;

	@Before
	public void setUp() throws Exception {
		w = new JRubyWhois(true);
	}

	@Test
	public void coucou() throws IOException {
		InputStream resourceAsStream = JprsTest.class.getResourceAsStream("/registrant_manga.rb");
		assertFalse(resourceAsStream == null);
		container.put("content", readInputStreamAsString(
				JprsTest.class.getResourceAsStream("/fixtures/responses/whois.jprs.jp/manga.txt")));
		WhoisContact res = (WhoisContact) container.runScriptlet(resourceAsStream, "registrant_manga.rb");
		assertEquals("yugengaisha atlas", res.getOrganization());
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
