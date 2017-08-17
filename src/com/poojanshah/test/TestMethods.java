package com.poojanshah.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
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
	Map<String, Integer> occurrences;
	Map<String, Boolean> results;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
		occurrences =new HashMap<String, Integer>();
		occurrences.put("the", 3366);
		occurrences.put("was",  840 );
		occurrences.put("i", 1019 );
		occurrences.put("you" , 1039 );
		occurrences.put("of", 1058 );
		occurrences.put("said", 1145 );
		occurrences.put("it", 1161);
		occurrences.put("a", 1181 );
		occurrences.put("to", 1553 );
		occurrences.put("and", 2473 );
		occurrences.put("the", 3366);
		
		results =new HashMap<String, Boolean>();
		results.put("was : 840 Prime? : false", false);
		results.put("i : 1019 Prime? : true",  false );
		results.put("you : 1039 Prime? : true", true );
		results.put("of : 1058 Prime? : false" , true );
		results.put("said : 1145 Prime? : false", false );
		results.put("it : 1161 Prime? : false", false );
		results.put("a : 1181 Prime? : true", false);
		results.put("to : 1553 Prime? : true", true );
		results.put("and : 2473 Prime? : true", true );
		results.put("the : 3366 Prime? : false", true );
			
				
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
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

	@Test
	public void gettingCorrectCountedPrintedWordsOne() {


		main.printOccurrences(occurrences);		
		assertTrue(outContent.toString().contains("the : 3366 Prime? : false"));
	}
	
	@Test
	public void gettingCorrectCountedPrintedWordsLoop() {


		main.printOccurrences(occurrences);
		Iterator it = results.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        assertTrue(outContent.toString().contains((CharSequence) pair.getKey()));
	        it.remove(); // avoids a ConcurrentModificationException
	    }
//		assertTrue(outContent.toString().contains("the : 3366 Prime? : false"));
	}



}
