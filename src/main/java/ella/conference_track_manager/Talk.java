package ella.conference_track_manager;

public class Talk {
	private String name;
	private int time;
	
	public Talk(String name, int time) {
		this.name = name;
		this.time = time;
	}
	
	public Talk(Talk t) {
		this.name = t.name;
		this.time = t.time;
	}
	
	public void output(String startTime) {
		System.out.println(startTime+this.name+" "+timeConverter(this.time));
	}
	
	public String timeConverter(int time) {
		if(time==5)
			return "lightning";
		return Integer.toString(time)+"min";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
