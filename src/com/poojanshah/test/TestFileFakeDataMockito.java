package com.poojanshah.test;

import java.util.Map;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.poojanshah.GetFile;
import com.poojanshah.main;
/**
 * Testing the getting values and to check if it has correct values 
 * @author shahp
 *
 */
public class TestFileFakeDataMockito {
	
	GetFile getFile;
	
	String[] splitWords;
	
	/**
	 * Setting up before each test, to remove duplicate code.
	 */
	@Before
	public void setup(){
		
//		getFile = new GetFile();
		
		getFile = mock(GetFile.class);
		when(getFile.readWords(null)).thenReturn(new String[]{"the","Car","the", "and", "and", "and","out", "test"});
		
		splitWords = getFile.readWords(null);
		
	}
	
	/**
	 * Cleaning up on method
	 */
	@After
	public void cleanUp() {
		
	}
	
	/**
	 * Ensure correct number of words in file
	 */
	@Test
    public void gettingWordsFromFile() {
		
		Assert.assertEquals(8, splitWords.length);
    }
	
	/**
	 * Ensure correct number unique of words in file
	 */
	@Test
    public void CountingWords() {		
		Map<String, Integer> occurrences = main.getOccurrences(splitWords);
		
		Assert.assertEquals(5, occurrences.size());
    }
	/**
	 * Ensure correct number unique of words in file and count
	 */
	@Test
    public void gettingCorrectCountedWords() {
				
		Map<String, Integer> occurrences = main.getOccurrences(splitWords);
		
		Assert.assertEquals(5, occurrences.size());
		
		Assert.assertEquals(2, occurrences.get("the").intValue());
		Assert.assertEquals(3, occurrences.get("and").intValue());
		Assert.assertEquals(1, occurrences.get("Car").intValue());
		Assert.assertEquals(1, occurrences.get("test").intValue());
		Assert.assertEquals(1, occurrences.get("out").intValue());
    }
	
	
	


}
