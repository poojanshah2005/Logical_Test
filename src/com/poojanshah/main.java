package com.poojanshah;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class main {
	
	private static Map<String, Integer> occurrences;
	private static String[] splitWords;

	public static String[] getSplitWords() {
		return splitWords;
	}

	public static void setSplitWords(String[] splitWords) {
		main.splitWords = splitWords;
	}

	public static Map<String, Integer> getOccurrences() {
		return occurrences;
	}
	/**
	 * 1. Getting words from file
	 * 2. counting words
	 * 3. sorting list by count
	 * 4. displaying Results
	 * @param args command line args
	 */
	public static void main(String[] args) {
		GetFile getFile = new GetFile();

		splitWords = getFile.readWords("Railway-Children-by-E-Nesbit.txt");

		occurrences = getOccurrences(splitWords);

		occurrences = sortList(occurrences);
		
		printOccurrences(occurrences);
	}

	/**
	 * Getting list of words with number of occurrences
	 * @param splitWords List of words
	 * @return List by word by number of occurrences
	 */
	public static Map<String, Integer> getOccurrences(String[] splitWords){
		Map<String, Integer> occurrences = new HashMap<String, Integer>();
		for ( String word : splitWords ) {
			Integer oldCount = occurrences.get(word);
			if ( oldCount == null ) {
				oldCount = 0;
			}
			occurrences.put(word, oldCount + 1);
		}		
		return occurrences;	
	}

	/**
	 * Sorting List by number of occurrences
	 * @param occurrences List by words
	 * @return List by word by number of occurrences
	 */
	private static Map<String, Integer>sortList(Map<String, Integer> occurrences){
		return occurrences.entrySet().stream()
				.sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));
	}

	/**
	 * Displaying Occurrences 
	 * @param occurrences List of Words along with number of occurrences in the book
	 */
	public static void printOccurrences(Map<String, Integer> occurrences){
		for ( String word : occurrences.keySet() ) {
				System.out.println(word + " : " + occurrences.get(word) + " Prime? : " + isPrime(occurrences.get(word)));			
		}
	}
	
	/**
	 * Is this number a prime number
	 * @param num the number to check
	 * @return true or false
	 */
	public static boolean isPrime(int num) {
		if (num < 2) return false;
		if (num == 2) return true;
		if (num % 2 == 0) return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0) return false;
		return true;
	}

}
