package myTests;

import static org.junit.Assert.*;
import engine.Engine;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;



public class test_dataload {

	
	
	@Test
	public final void testLoadProcessGhost() {
		String inputFileName = "Resources/SampleDocs/ghost_mt.txt";
		Engine engine = new Engine(inputFileName, "RAW", "ghost");
		
		
	
		
		int inputBlocks = engine.loadFileAndCharacterizeBlocks();
		assertEquals(9,inputBlocks);
	
		
		List<String> report = engine.reportWithStats();
		
		assertEquals("Total number of paragraphs: 9", report.get(0).strip());
		assertEquals("Total number of words: 649", report.get(1).strip());
	
	}
	@Test
	public final void testReport() {
		String inputFileName = "Resources/SampleDocs/myfile";
		Engine engine = new Engine(inputFileName, "RAW", "myfile");
		
	
		
		List<String> report = engine.reportWithStats();
		
		
		
		assertEquals("\nTotal number of paragraphs: 4", report.get(0));
		assertEquals("Total number of words: 32", report.get(1).strip());
		assertEquals("Lines: 1         Words: 4", report.get(2).strip());
		assertEquals("Lines: 1         Words: 6", report.get(3).strip());
		assertEquals("Lines: 2         Words: 19", report.get(4).strip());
		assertEquals("Lines: 2         Words: 3", report.get(5).strip());
	
	}

}