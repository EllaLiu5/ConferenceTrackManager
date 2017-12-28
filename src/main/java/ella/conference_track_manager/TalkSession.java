package ella.conference_track_manager;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TalkSession extends Session{
	private List<Talk> talks;

	public TalkSession(String type, int startTime, int endTime) {
		super(type, startTime, endTime);
		talks = new ArrayList<Talk>();
		// TODO Auto-generated constructor stub
	}
	
	public void addTalk(Talk talk) {
		talks.add(new Talk(talk));
	}
	
	//passed
	public void processTalks(List<Talk> talks) {
		DPSolver solver = new DPSolver();
		int sessionTime = endTime - startTime;
		boolean[] selectTalks = solver.process(sessionTime, talks);
		ListIterator<Talk> iter = talks.listIterator();
		int i=1;
		while(iter.hasNext()) {
			Talk talk = iter.next();
			if(selectTalks[i]) {
				this.addTalk(talk);
				iter.remove();
			}
			i++;
		}
	}
	
	//passed
	@Override
	public int calculateActualEndTime() {
		int sumTime = 0;
		for(Talk talk:this.talks) {
			sumTime+=talk.getTime();
		}
		return sumTime+this.startTime;
	}
	
	@Override
	public void printWithPrevSessionTime(int prevSessionTime) {
		int currentTime = this.startTime;
		for(Talk talk: this.talks) {
			String s = Session.formatTime(currentTime);
			talk.output(s);
			currentTime+=talk.getTime();
		}
	}
}
