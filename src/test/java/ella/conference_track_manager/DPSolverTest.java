package ella.conference_track_manager;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import ella.conference_track_manager.helper.DataReader;

import org.junit.Test;

public class DPSolverTest {
	@Test
	public void testProcess() throws IOException {
		DPSolver solver = new DPSolver();
		List<String> talks = DataReader.readFile("src/main/resources/input.txt");
		ConferenceScheduler.addValideTalks(talks);
		List<Talk> talkList = ConferenceScheduler.getTalksList();
		boolean[] selectTalks;
		ListIterator<Talk> iter;
		int totalTime = 0;
		int i=1;
		int[] expectedTime = new int[]{180,240,180,185};
		for(int time:expectedTime) {
			selectTalks = solver.process(time, talkList);
			iter = talkList.listIterator();
			totalTime = 0;
			i=1;
			while(iter.hasNext()) {
				Talk talk = iter.next();
				if(selectTalks[i]) {
					totalTime+=talk.getTime();
					iter.remove();
				}
				i++;
			}
			assertEquals(time, totalTime);
		}
	}
}
