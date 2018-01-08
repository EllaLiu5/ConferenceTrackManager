package ella.conference_track_manager;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import ella.conference_track_manager.helper.DataReader;

public class ConferenceSchedulerTest {

	@Test
	public void testAddValideTalks() throws IOException {
		//Data Reader and getTalkTime
		ConferenceScheduler conf = new ConferenceScheduler();
		List<String> talks = DataReader.readFile();
		conf.addValideTalks(talks);
		assertEquals("Writing Fast Tests Against Enterprise Rails", conf.getTalksList().get(0).getName());
		assertEquals(60, conf.getTalksList().get(0).getTime());
		assertEquals("Rails for Python Developers", conf.getTalksList().get(1).getName());
		assertEquals(5, conf.getTalksList().get(1).getTime());
	}
	
}
