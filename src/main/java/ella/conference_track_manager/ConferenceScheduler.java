package ella.conference_track_manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConferenceScheduler {
	private static List<Talk> talksList;
	private static int maxTalkTime = 240;//meaning of private static
	private static int minTalkTime = 1;
	private static int lightningTime = 5;
	private static final Logger log = LogManager.getRootLogger();
	
	public static List<Track> scheduleTalks(List<String> talks){
		List<Track> tracks = new ArrayList<Track>();
		addValideTalks(talks);//add to talksList
		//create session list
		List<String> sessionList = new ArrayList<String>();
		sessionList.add("morning");
		sessionList.add("lunch");
		sessionList.add("afternoon");
		sessionList.add("networking");
		while(talksList.size()>0) {
			Iterator<String> sessionIter = sessionList.iterator();
			Track track = new Track();
			tracks.add(track);
			while(sessionIter.hasNext()){
				Session session = null;
				switch(sessionIter.next()) {
					case "morning": 
						session = new TalkSession("morning", 900, 1200);
						break;
					case "lunch":
						session = new IntervalSession("lunch", 1200, 1300);
						break;
					case "afternoon":
						session = new TalkSession("afternoon", 1300, 1700);
						break;
					case "networking":
						session = new IntervalSession("networking", 1700, 1800);
						break;
				}
				track.addSession(session);//add config
				//fill in this session
				session.processTalks(talksList);
			}
		}
		return tracks;		
	}
	
	//passed test
	public static void addValideTalks(List<String> talks){
		int talkTime = 0;
		if (talks==null || talks.isEmpty()){
			log.error("Input file is empty, please check.");
			return;
		}
		talksList = new ArrayList<Talk>();
		
		for(String talk : talks) {
			Pattern pa = Pattern.compile("(.*)(\\s)+([0-9]*[0-9]{1}min|lightning)\\b");
			Matcher matcher = pa.matcher(talk);
			if(!matcher.matches()) {
				log.error("Talk has invalid format. Talk: "+talk);
				continue;
			}
			talkTime = getTalkTime(matcher.group(3));
			if(talkTime<=maxTalkTime && talkTime>=minTalkTime){
				talksList.add(new Talk(matcher.group(1), talkTime));
			}else {
				log.error("Talk time is out of range. Talk: "+talk);
			}	
		}
	}
	
	public static List<Talk> getTalksList() {
		return talksList;
	}

	public static void setTalksList(List<Talk> talksList) {
		ConferenceScheduler.talksList = talksList;
	}

	private static int getTalkTime(String timeString){
		int talkTime = 0;
		try {
			if(timeString.endsWith("min")) {
				talkTime = Integer.parseInt(timeString.substring(0, timeString.indexOf("min")));
			}else {
				talkTime = lightningTime;//change this magic number
			}
		} catch (NumberFormatException e){
			e.printStackTrace();//catch if cannot convert to int
		}
		return talkTime;
	}
}
