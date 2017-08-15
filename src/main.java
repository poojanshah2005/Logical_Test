import java.util.logging.Logger;

public class main {

	public static void main(String[] args) {
		GetDictionary getDictionary = new GetDictionary();
		
		String[] words = getDictionary.readLines("Railway-Children-by-E-Nesbit.txt");
		
		for(String s:words){
			System.out.println(s);
		}
		
	}

}
