import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Helper Class to load file and to get words
 * @author shahp
 *
 */
public class GetFile {

	/**
	 * Helper Method to load words
	 * @param filename
	 * @return
	 */
	public String[] readWords(String filename) {
		try{
			String filePath = new File(filename).getAbsolutePath();
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			List<String> lines = new ArrayList<String>();
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				String[] words = line.split("[\\p{Punct}\\s]+");
				for(String word:words){
					lines.add(word.toLowerCase());
				}
//				lines.add(line.split("\\s+"));
			}
			bufferedReader.close();
			return lines.toArray(new String[lines.size()]);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return null;

	}
}
