package datamodel.buildingblocks;

//import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.StringTokenizer;



//import com.itextpdf.text.Font;



public class LineBlock {
	
	
 
	private String lineblock;
	private int numWords;
	private ArrayList<String> lineblocks;

	private int lines;
	private StyleEnum determineHeadingStatus;
	private FormatEnum determineFormatStatus;
	



		
	public LineBlock() {
	this.lineblocks= new ArrayList<String>();
	lineblock =new String("");
	lineblocks.add(this.lineblock);
	this.numWords=0;
	this.lines=0;
	 this.determineHeadingStatus =StyleEnum.NORMAL;
		// this.determineFormatStatus=FormatEnum.REGULAR;
		 this.determineFormatStatus=FormatEnum.REGULAR;
	// lineblocks.add(lineblock);
	// this.numwords=0;
	
	
	}
	
	
	public LineBlock(String lineblock) {
		this.lineblock= Union(lineblock);
		lineblocks= new ArrayList<String>();
		
		lineblocks.add(this.lineblock);
		 this.numWords= countWordsUsingStringTokenizer( this.lineblock);
		 this.lines=getnumoflines(lineblock);
		 this.determineHeadingStatus =StyleEnum.NORMAL;
	
		 this.determineFormatStatus=FormatEnum.REGULAR;
	}


	public String getStatsAsString() {
		
			
		return "Lines: "+this.lines  +"         " +"Words: " +this.numWords;
		
	
	}
	

	
  public int getnumoflines(String lineblock) {
	  
	  String[] lines = lineblock.split("\r\n|\r|\n");
	
	  return lines.length;
  }
	

	public ArrayList<String> getLines() {
		
	
			return this.lineblocks;
		}
	
	

	


	public boolean startsWith(String prefix) {
		String [] words = lineblock.split(" ");
		
		if(words[0].equals(prefix)) {
			return true;
		}
		return false;
	}

	
	//LineBlock
	public String replaceFirst(String prefix, String string) {
		
		//System.out.println("prefix no First word");
	if(lineblock.startsWith(prefix)) {
		
		lineblock=lineblock.replaceAll(prefix, string);
		
		lineblocks.remove(0);
		lineblocks.add(lineblock);
		
		return  lineblocks.get(0);
		
	}

	return lineblock;
	}
	
	
	private static int countWordsUsingStringTokenizer(String lineblock) { 
		 if (lineblock == null || lineblock.isEmpty()) { 
			 return 0; }
		 StringTokenizer tokens = new StringTokenizer(lineblock);
		// System.out.println(tokens.nextToken());
		 return tokens.countTokens();
		 }

	

	 public int getNumWords() {
			
		
         return this.numWords;
		 
		}

	

	public StyleEnum getDetermineHeadingStatus() {
		return this.determineHeadingStatus;
	}


	public FormatEnum getDetermineFormatStatus() {
		return this.determineFormatStatus;
	}


	public void setStyle(StyleEnum determineHeadingStatus) {
		
		this.determineHeadingStatus = determineHeadingStatus;
		
	}


	public void setFormat(FormatEnum determineFormatStatus) {
		
		this.determineFormatStatus=determineFormatStatus;
	}

	

private String Union(String lineblock) {
	
	
	

	lineblock= lineblock.replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
	
	String[] lines = lineblock.split("\r\n|\r|\n");	
	String l ="";
		for(int i=0; i<lines.length; i++) {
			
			l+=lines[i]+" ";
		}
		return l;
			
	
}




	

}
