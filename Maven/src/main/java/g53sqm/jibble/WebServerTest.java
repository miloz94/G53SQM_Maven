package g53sqm.jibble;

import static org.junit.Assert.*;

import org.junit.Test;

public class WebServerTest {

	@Test
	public void testWebServer() {
		String rootDir = "webfile";
		int port = 8088;
		
		assertEquals(8088,port);
		assertEquals("webfiles",rootDir);

	}

}
