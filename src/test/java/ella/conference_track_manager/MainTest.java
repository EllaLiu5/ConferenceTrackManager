package ella.conference_track_manager;

import java.util.List;

import org.junit.Test;

import ella.conference_track_manager.helper.DataReader;

public class MainTest {

	@Test
	public void testMain() {
		List<String> talks = DataReader.readFile();
		List<Track> tracks = ConferenceScheduler.scheduleTalks(talks);
		Main m = new Main();
		m.output(tracks);
	}

}
