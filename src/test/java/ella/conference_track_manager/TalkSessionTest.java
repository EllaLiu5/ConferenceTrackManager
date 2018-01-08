package ella.conference_track_manager;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import ella.conference_track_manager.helper.DataReader;

public class TalkSessionTest {

	@Test
	public void testTimeConverter() {
		assertEquals(180, Session.timeConverter(1200)-Session.timeConverter(900));
		assertEquals(420, Session.timeConverter(1800)-Session.timeConverter(1100));
	}
	
	@Test
	public void testProcessTalks() throws IOException {
		List<String> talks = DataReader.readFile("src/main/resources/input.txt");
		ConferenceScheduler.addValideTalks(talks);
		List<Talk> talkList = ConferenceScheduler.getTalksList();
		assertEquals(180, testProcessTalksHelper("morning", 900, 1200, talkList));
		assertEquals(240, testProcessTalksHelper("afternoon",1300,1700, talkList));
		assertEquals(180, testProcessTalksHelper("morning",900,1200, talkList));
		assertEquals(185, testProcessTalksHelper("afternoon",1300,1700, talkList));
		assertEquals(0,talkList.size());
	}
	
	public int testProcessTalksHelper(String type, int start, int end, List<Talk> talkList) {
		Session testTalkSess = new TalkSession(type,start,end);
		testTalkSess.processTalks(talkList);
		return testTalkSess.calculateActualEndTime()-testTalkSess.getStartTime();
	}
}
