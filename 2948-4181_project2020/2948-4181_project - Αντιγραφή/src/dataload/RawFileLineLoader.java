package dataload;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;



//import com.itextpdf.text.pdf.parser.Line;

import java.io.*; 

import datamodel.buildingblocks.LineBlock;



public class RawFileLineLoader {

	private String filePath;

	private ArrayList<LineBlock> lineblocks;
	
	private int size;
	String lineblock;
	LineBlock paragraph;

	


	public RawFileLineLoader() {
		//default constructor
	this.filePath="";
	this.lineblocks=new ArrayList<LineBlock>();
	this.lineblock=new String();
	this.paragraph=new LineBlock();
	this.size=lineblocks.size();
	}

	
	public RawFileLineLoader(String filePath,List<LineBlock> lineblocks) {
	
		this.lineblock=new String();
	
		this.filePath=filePath;
		this.lineblocks=new ArrayList<LineBlock>();
		this.size=lineblocks.size();
	
		
	}

	public void load(String filePath, List<LineBlock> lineblocks)  {
		
		
		this.filePath=filePath;
		
		 try {
			 
			             File file1 = new File(filePath);
			            
						FileInputStream fileStream = new FileInputStream(file1);
			           
			             Scanner sc = new Scanner(new FileReader(file1));
			 
			   
			 
			             byte[] byteArray = new byte[(int)file1.length()];
			   	 
						fileStream.read(byteArray);
			   	      String data = new String(byteArray);
			   	      
			  	       String[] paragraphs = data.toString().split("\r\n\r\n");

			   	    
			   	     
			   	      for(String a:paragraphs) {
			   	    	  //LineBlock paragraph =new LineBlock();
			   	    	this.paragraph=new LineBlock(a);
			   	    	 //this.paragraph.setLineblock(a);
			   	    		if(this.paragraph.getnumoflines(a)!=0 && this.paragraph.getNumWords()!=0) {
			   	    			this.lineblocks.add(this.paragraph);
			   	    		}
			   	
			   	    	
			   	    	
			   	      }
			   	      
			   	      
			   	   this.size=this.lineblocks.size();  
			             sc.close();
			             fileStream.close();
			             
			           
			      
			          
			         } catch (IOException e) {
		
			             System.out.println("Προβλημα στο ανοιγμα αρχειου\n");
		
			         }
		 
	}

		

	

	
	public String getFilePath() {
		return this.filePath;
	}

	
		         

	public ArrayList<LineBlock> getLineblocks() {
		
		
		return this.lineblocks;
}
	
	public int getsize() {
		
		return this.size;
	}

	


	
	
}