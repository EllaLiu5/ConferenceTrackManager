package ella.conference_track_manager.helper;



import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
	public static List<String> readFile() {
		String filename = "src/main/resources/input2.txt";
		List<String> input = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				input.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return input;
	}
	
	public static List<String> readFile(String filename) {
		List<String> input = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				input.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return input;
	}
}
