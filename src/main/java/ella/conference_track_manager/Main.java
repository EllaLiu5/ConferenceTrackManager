package ella.conference_track_manager;

import java.util.List;

import ella.conference_track_manager.helper.DataReader;

public class Main {
	
	public static void main(String[] args) {
		List<String> talks = DataReader.readFile(args[0]);
		List<Track> tracks = ConferenceScheduler.scheduleTalks(talks);
		Main m = new Main();
		m.output(tracks);
	}
	
	public void output(List<Track> tracks) {
		int num = 1;
		for (Track t : tracks) {
			if(num!=1) System.out.println();
			System.out.println("Track " + num + ":");
			t.output();
			num++;
		}
	}
}
