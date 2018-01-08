package ella.conference_track_manager.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import ella.conference_track_manager.Main;

public class DataReader {
	private static Logger log;
	static {
		log = Logger.getLogger(Main.class.getName());
	}
	public static List<String> readFile() {
		String filename = "src/main/resources/input2.txt";
		List<String> input = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				input.add(line);
			}
		} catch (Exception e) {
			log.severe("Cannot read from input file: src/main/resources/input2.txt");
            System.exit(1);
		}
		return input;
	}
	
	public static List<String> readFile(String filename) {
		List<String> input = new ArrayList<String>();
		File inputFile = new File(filename);
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				input.add(line);
			}
		} catch (Exception e) {
			log.severe("Cannot read from input file: " + inputFile.getAbsolutePath());
            System.exit(1);
		}
		return input;
	}
}
