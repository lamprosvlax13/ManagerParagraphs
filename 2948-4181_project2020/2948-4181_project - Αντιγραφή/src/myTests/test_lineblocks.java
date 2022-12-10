package myTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import datamodel.buildingblocks.FormatEnum;
import datamodel.buildingblocks.LineBlock;
import datamodel.buildingblocks.StyleEnum;





public class test_lineblocks {

	
	
	
	


	
		
		@Test
		public final void testLineBlock() {
		
			String lineblock="From \"Harvard Classics Volume 38\"\r\n"
					+ "Copyright 1910 by P.F. Collier and Son.";
			
				LineBlock paragraph= new LineBlock(lineblock);		
			
				String out=(paragraph.getStatsAsString());
				assertEquals("Lines: 2         Words: 12",out);
				
				int lines=paragraph.getnumoflines(lineblock);
				assertEquals(2,lines);
				
				Boolean x=paragraph.startsWith("haha");
				assertEquals(false,x);
				
				 x=paragraph.startsWith("From");
				assertEquals(true,x);
				
				String replace=paragraph.replaceFirst("From", "haha");
				
				assertEquals("haha \"Harvard Classics Volume 38\" Copyright 1910 by P.F. Collier and Son. ",replace);
				
				int numwords=paragraph.getNumWords();
				assertEquals(12,numwords);
				
				StyleEnum head=paragraph.getDetermineHeadingStatus();
				assertEquals(StyleEnum.NORMAL,head);

				FormatEnum format=paragraph.getDetermineFormatStatus();
				assertEquals(FormatEnum.REGULAR,format);
				
				paragraph.setFormat(FormatEnum.BOLD);
				FormatEnum y=	paragraph.getDetermineFormatStatus();
				assertEquals(FormatEnum.BOLD,y);
				
				ArrayList<String> list =paragraph.getLines();
				ArrayList<String> list1=new ArrayList<String>();
				
				list1.add("haha \"Harvard Classics Volume 38\" Copyright 1910 by P.F. Collier and Son. ");
				assertEquals(list1,list);
				
		}
	

	
	
	
	
	
	
	
}
