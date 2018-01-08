package ella.conference_track_manager;

import java.io.IOException;
import java.util.List;
import org.junit.Test;
import ella.conference_track_manager.helper.DataReader;
import java.util.logging.Logger;

public class MainTest {
	private static Logger log;
	static {
		String path = Main.class.getClassLoader()
	                                  .getResource("logging.properties")
	                                  .getFile();
		System.setProperty("java.util.logging.config.file", path);
		log = Logger.getLogger("myApp");
	  }

	@Test
	public void testMain() throws IOException {
		log.warning("warnign here in maintest");
		List<String> talks = DataReader.readFile();
		List<Track> tracks = ConferenceScheduler.scheduleTalks(talks);
		Main m = new Main();
		m.output(tracks);
	}

}
