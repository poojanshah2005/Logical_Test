import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetDictionary {

	public String[] readLines(String filename) {
		try{
			String filePath = new File(filename).getAbsolutePath();
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			List<String> lines = new ArrayList<String>();
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
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
