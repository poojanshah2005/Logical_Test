import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class main {

	public static void main(String[] args) {
		GetDictionary getDictionary = new GetDictionary();
		
		String[] splitWords = getDictionary.readLines("Railway-Children-by-E-Nesbit.txt");
		
//		for(String s:splitWords){
//			System.out.println(s);
//		}
		
		Map<String, Integer> occurrences = new HashMap<String, Integer>();
		
		for ( String word : splitWords ) {
			   Integer oldCount = occurrences.get(word);
			   if ( oldCount == null ) {
			      oldCount = 0;
			   }
			   occurrences.put(word, oldCount + 1);
			}
		
		for ( String word : occurrences.keySet() ) {
			if(isPrime(occurrences.get(word)))
			System.out.println(word + " : " + occurrences.get(word));
			
			}
	}
	
	private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
}

}
