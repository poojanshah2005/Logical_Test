package com.poojanshah.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.poojanshah.GetFile;
import com.poojanshah.main;

public class TestFile {
	
	GetFile getFile;
	String[] splitWords;
	
	@Before
	public void setup(){
		getFile = new GetFile();
		splitWords = getFile.readWords("Railway-Children-by-E-Nesbit.txt");
		
	}
	
	@After
	public void cleanUp() {
		
	}
	
	@Test
    public void gettingWordsFromFile() {
		
		Assert.assertEquals(66101, splitWords.length);
    }
	
	
	@Test
    public void CountingWords() {		
		Map<String, Integer> occurrences = main.getOccurrences(splitWords);
		
		Assert.assertEquals(4705, occurrences.size());
    }
	
	@Test
    public void gettingCorrectCountedWords() {
				
		Map<String, Integer> occurrences = main.getOccurrences(splitWords);
		
		Assert.assertEquals(4705, occurrences.size());
		
		Assert.assertEquals(3366, occurrences.get("the").intValue());
		Assert.assertEquals(2473, occurrences.get("and").intValue());
		Assert.assertEquals(1181, occurrences.get("a").intValue());
		Assert.assertEquals(1161, occurrences.get("it").intValue());
    }
	
	
	


}
