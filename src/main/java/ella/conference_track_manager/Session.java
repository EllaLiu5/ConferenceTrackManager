package ella.conference_track_manager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class Session {
	protected String type;
	protected int startTime;
	protected int endTime;
	protected int actualEndTime;
	
	public Session(String type, int startTime, int endTime) {
		super();
		this.type = type;
		this.startTime = timeConverter(startTime);
		this.endTime = timeConverter(endTime);
	}
	
	//passed
	public static int timeConverter(int time) {
		Date date = null;
		try {
			date = new SimpleDateFormat("HHmm").parse(String.format("%04d",time));
		} catch(Exception e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);	
	}
	
	public static String formatTime(int time) {
		int hour = time/60;
		String timeSuffix;
		if(hour<12) {
			timeSuffix = "AM";
		}
		else {
			timeSuffix = "PM";
			hour-=12;
		}
		return String.format("%02d:%02d%s ", hour, (time % 60), timeSuffix);
	}
	
	public abstract void processTalks(List<Talk> talks);
	
	public abstract int calculateActualEndTime();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	public abstract void printWithPrevSessionTime(int prevSessionTime);

	
}
