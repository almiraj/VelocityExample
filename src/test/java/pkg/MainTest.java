package pkg;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class MainTest {

	@Test
	public void test() throws Exception {
		byte[] allBytes = Files.readAllBytes(Paths.get(new File("templates/dir1/JUnitAssertionFile.vm").getAbsolutePath()));
		String expected = new String(allBytes, Charset.forName("UTF-8"));
		assertEquals(expected, Main.merge());
	}

}
