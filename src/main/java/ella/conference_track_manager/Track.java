package ella.conference_track_manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Track {
	List<Session> sessions;
	
	public Track() {
		super();
		sessions = new ArrayList<Session>();
	}
	
	public void addSession(Session session) {
		sessions.add(session);
	}
	
	//passed
	public void output() {
		Iterator<Session> iter = sessions.iterator();
		int currentSessionEndTime = 0;
		int prevSessionEndTime = 0;
		while(iter.hasNext()) {
			Session se = iter.next();
			currentSessionEndTime = se.calculateActualEndTime();
			se.printWithPrevSessionTime(prevSessionEndTime);
			prevSessionEndTime = currentSessionEndTime;
		}
	}


}
