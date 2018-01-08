package ella.conference_track_manager;

import java.util.List;

/**
 * @author liu
 * session without talks
 */
public class IntervalSession extends Session{

	public IntervalSession(String type, int startTime, int endTime) {
		super(type, startTime, endTime);
	}
	
	public void processTalks(List<Talk> talks) {
		return;
	}
	
	@Override
	public void printWithPrevSessionTime(int prevSessionTime) {
		if(type=="lunch") {
			System.out.println("12:00PM Lunch");
		}
		else {
			if(prevSessionTime<this.startTime-60) {
				System.out.println("04:00PM Networking Event");
			}
			else {
				System.out.println("05:00PM Networking Event");
			}
		}
			
	}

	@Override
	public int calculateActualEndTime() {
		return endTime;
	}

}
