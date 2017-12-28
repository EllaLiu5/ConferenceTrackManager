package ella.conference_track_manager.helper;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class DataReaderTest {
	@Test
	public void testReadFile() {
		List<String> output = DataReader.readFile("src/main/resources/input.txt");
		assertEquals("Writing Fast Tests Against Enterprise Rails 60min",output.get(0));
		assertEquals("User Interface CSS in Rails Apps 30min",output.get(output.size() - 1));
	}
}
