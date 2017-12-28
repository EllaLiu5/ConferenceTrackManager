package ella.conference_track_manager;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.core.util.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import ella.conference_track_manager.helper.DataReader;

public class TrackTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	
	@Test
	public void testOutput() throws IOException {
		List<String> talks = DataReader.readFile();
		ConferenceScheduler.addValideTalks(talks);
		List<Track> tracks = ConferenceScheduler.scheduleTalks(talks);
		tracks.get(0).output();
		assertEquals(readFile("src/test/resources/output_track1.txt", StandardCharsets.UTF_8), outContent.toString());
	}
	
	static String readFile(String path, Charset encoding) throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
}
