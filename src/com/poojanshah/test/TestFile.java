package com.poojanshah.test;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.poojanshah.GetFile;
import com.poojanshah.main;

public class TestFile {
	
	@Test
    public void gettingWords() {
		
		GetFile getFile = new GetFile();

		String[] splitWords = getFile.readWords("Railway-Children-by-E-Nesbit.txt");
		
		Assert.assertEquals(66101, splitWords.length);
    }
	
	
	@Test
    public void gettingCountedWords() {
		
		GetFile getFile = new GetFile();

		String[] splitWords = getFile.readWords("Railway-Children-by-E-Nesbit.txt");
		
		Map<String, Integer> occurrences = main.getOccurrences(splitWords);
		
		Assert.assertEquals(4705, occurrences.size());
    }
	
	@Test
    public void gettingCorrectCountedWords() {
		
		GetFile getFile = new GetFile();

		String[] splitWords = getFile.readWords("Railway-Children-by-E-Nesbit.txt");
		
		Map<String, Integer> occurrences = main.getOccurrences(splitWords);
		
		Assert.assertEquals(4705, occurrences.size());
		
		Assert.assertEquals(3366, occurrences.get("the").intValue());
		Assert.assertEquals(2473, occurrences.get("and").intValue());
		Assert.assertEquals(1181, occurrences.get("a").intValue());
		Assert.assertEquals(1161, occurrences.get("it").intValue());
		
		
		
    }


}
