package myTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import engine.Engine;
import engine.IPlainTextDocumentEngine;

public class test_with_ruleset {
	private static List<String> omList; 
	private static List<String> h1List; 
	private static List<String> h2List; 

	private static List<String> italicsList;
	private static List<List<String>> inputSpec;
	private static IPlainTextDocumentEngine engine;
	
	private static List<String> boldList;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	private static String setupProfileGhost() {
		inputSpec = new ArrayList<List<String>>();
		
		omList = new ArrayList<String>(); inputSpec.add(omList);
		omList.add("OMIT");omList.add("POSITIONS");omList.add("0,1,2");	
		
		italicsList = new ArrayList<String>(); inputSpec.add(italicsList);
		italicsList.add("<I>");italicsList.add("POSITIONS"); italicsList.add("3,4,5,6");
		
		String referenceResult = "inputRuleSet2" + "\n" + 
				"OMIT:  IN_POS " + "\n" + 
		"ITALICS:  IN_POS "; 

		return referenceResult;
	
}

	
	private static void  setupProfileHTLM() {
		inputSpec = new ArrayList<List<String>>();
		h1List = new ArrayList<String>(); inputSpec.add(h1List);
		h1List.add("H1");h1List.add("STARTS_WITH"); h1List.add("<H1>");
		h2List = new ArrayList<String>(); inputSpec.add(h2List);
		h2List.add("H2");h2List.add("STARTS_WITH"); h2List.add("<H2>");
		italicsList = new ArrayList<String>(); inputSpec.add(italicsList);
		italicsList.add("<I>");italicsList.add("STARTS_WITH"); italicsList.add("<i>");
		boldList = new ArrayList<String>(); inputSpec.add(boldList);
		boldList.add("<B>");boldList.add("STARTS_WITH"); boldList.add("<b>");

		
	
	}

	
	
	
	
	
	
	@Test
	public final void testLoadProcessWritePdfGhost() {
		String inputFileName = "Resources/SampleDocs/ghost_mt.txt";
		engine = new Engine(inputFileName, "RAW", "ghost");
		setupProfileGhost();
		engine.registerInputRuleSetForPlainFiles(inputSpec);
	
		String outputFileName = "Resources//Outputs//ghost_mt.pdf";

		int outputParagraphs = engine.exportPdf(outputFileName);
		assertEquals(6,outputParagraphs);
		
	}
	
	
	
	@Test
	public final void testLoadProcessWriteMdGhost() {
		String inputFileName = "Resources/SampleDocs/ghost_mt.txt";
		engine = new Engine(inputFileName, "RAW", "ghost");
		setupProfileGhost();
		engine.registerInputRuleSetForPlainFiles(inputSpec);
		engine.loadFileAndCharacterizeBlocks();
		String outputFileName = "Resources//Outputs//ghost_mt.md";

		int outputParagraphs = engine.exportMarkDown(outputFileName);
		assertEquals(6,outputParagraphs);
		
	}
	
	

	@Test
	public final void testLoadProcessWritePdfGhostWithNoRules() {
		String inputFileName = "Resources/SampleDocs/ghost_mt.txt";
		engine = new Engine(inputFileName, "RAW", "ghost");

		String outputFileName = "Resources//Outputs//ghost_mt1.pdf";

		int outputParagraphs = engine.exportPdf(outputFileName);
		assertEquals(9,outputParagraphs);
		
	}
	
	@Test
	public final void testLoadProcessWriteMdGhostWithNoRules() {
		String inputFileName = "Resources/SampleDocs/ghost_mt.txt";
		engine = new Engine(inputFileName, "RAW", "ghost");

		String outputFileName = "Resources//Outputs//ghost_mt1.md";

		int outputParagraphs = engine.exportMarkDown(outputFileName);
		assertEquals(9,outputParagraphs);
		
	}
	
	
	@Test
	public final void testANNOTATED_Md() {
		String inputFileName = "Resources/SampleDocs/test.html";
		engine = new Engine(inputFileName, "ANNOTATED", "gost");
		setupProfileHTLM();
		List<String> prefixes = new ArrayList<String>(); 
		prefixes.add("<H1>");prefixes.add("<H2>");prefixes.add("<i>");prefixes.add("<b>");prefixes.add("<p>");
		
		engine.registerInputRuleSetForAnnotatedFiles(inputSpec, prefixes);
		engine.loadFileAndCharacterizeBlocks();
		String outputFileName = "Resources//Outputs//ghost_annotated.md";

		int outputParagraphs = engine.exportMarkDown(outputFileName);
		assertEquals(8,outputParagraphs);
		
	}
	
	
	@Test
	public final void testANNOTATED_pdf() {
		String inputFileName = "Resources/SampleDocs/test.html";
		engine = new Engine(inputFileName, "ANNOTATED", "gost");
		setupProfileHTLM();
		List<String> prefixes = new ArrayList<String>(); 
		prefixes.add("<H1>");prefixes.add("<H2>");prefixes.add("<i>");prefixes.add("<b>");prefixes.add("<p>");
		
		engine.registerInputRuleSetForAnnotatedFiles(inputSpec, prefixes);
		
		String outputFileName = "Resources//Outputs//ghost_annotated.pdf";

		int outputParagraphs = engine.exportPdf(outputFileName);
		assertEquals(8,outputParagraphs);
		
	}
	
	
	
	
	
	
	
}
