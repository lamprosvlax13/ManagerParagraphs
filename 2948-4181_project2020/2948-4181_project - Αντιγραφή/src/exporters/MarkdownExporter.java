package exporters;

//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.PrintWriter;
import java.util.List;

///import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;

import datamodel.buildingblocks.Document;
import datamodel.buildingblocks.LineBlock;
import datamodel.buildingblocks.Document.DocumentRawType;

public class MarkdownExporter {
	
	
	
	private String outputfilename;
	

	Paragraph paragraph;

	com.itextpdf.text.Document document1;

	private List<LineBlock> lineblocks;
	
	

	private Document doc;
	
	
	private int k;


	private DocumentRawType doctype;

	public MarkdownExporter(Document document, String outputFileName) {
		
		document1=new com.itextpdf.text.Document();
		//this.doc=document1;
		
		this.doc=document;
		this.doctype=document.getInputFileType();
		//this.docuMent=document;
		this.outputfilename=outputFileName;
		this.lineblocks=document.getLineblocks();
		//this.paragraph=new Paragraph();
		this.k=0;
		
	}

	public int export() {
	
		try {
		      FileWriter myWriter = new FileWriter(this.outputfilename);
		 
		      for(LineBlock e:this.lineblocks) {
		    	  
		    	  switch (e.getDetermineHeadingStatus()){
					case OMITTED :
					
						continue;
						
					case H1:
						
						myWriter.write("#"+(e.getLines().get(0)+"\n"));
						myWriter.write("\n");
					this.k++;
					break;
				case H2:
					
					
					myWriter.write("##"+(e.getLines().get(0)+"\n"));
					myWriter.write("\n");
					this.k++;
					break;
				case NORMAL:
					switch(e.getDetermineFormatStatus()) {
					case BOLD:
						
						myWriter.write("**"+(e.getLines().get(0)+"**"+"\n"));
						myWriter.write("\n");
						this.k++;
						break;
					case ITALICS:
						myWriter.write("_"+e.getLines().get(0)+"_"+"\n");
						myWriter.write("\n");
						this.k++;
						break;
					case REGULAR:
						myWriter.write((e.getLines().get(0)+"\n"));
						myWriter.write("\n");
						this.k++;
						break;
					default:
						break;
					
					}
						break;
					
					
					
		    	  }
		    	 
		    	 
		      }
		      
		      
		      myWriter.close();
		     
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return this.k;

	
	}
	
	



public Document getDoc() {
	return doc;
}

public String getOutputfilename() {
	return outputfilename;
}

public DocumentRawType getDoctype() {
	return doctype;
}

}