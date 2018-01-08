package ella.conference_track_manager;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import ella.conference_track_manager.helper.DataReader;

public class Main {
	private static Logger log;
	static {
		System.setProperty("java.util.logging.config.file",
	  "src/logging.properties");
		log = Logger.getLogger(Main.class.getName());
	}
	  
	public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            log.warning("Please give input file name.");
            System.exit(1);
        }
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
