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

public class TestMethods {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test
    public void gettingCorrectCountedPrintedWords() {
				
		Map<String, Integer> occurrences =new HashMap<String, Integer>();
		occurrences.put("the", 3366);
		main.printOccurrences(occurrences);		
		assertTrue(outContent.toString().contains("the : 3366 Prime? : false"));
    }
	
	@Test
    public void isPrimeFunctionWorking() {
					
		Assert.assertEquals(true, main.isPrime(2));
		Assert.assertEquals(true, main.isPrime(3));
		Assert.assertEquals(true, main.isPrime(7));
		Assert.assertEquals(true, main.isPrime(11));
		Assert.assertEquals(false, main.isPrime(12));
		Assert.assertEquals(false, main.isPrime(15));
    }

}
