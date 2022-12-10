package exporters;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.OutputStream;
import java.util.List;

//import com.itextpdf.text.DocListener;
import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import datamodel.buildingblocks.Document;
import datamodel.buildingblocks.Document.DocumentRawType;

//import datamodel.buildingblocks.FormatEnum;
import datamodel.buildingblocks.LineBlock;

public class PdfExporter {


	private String outputfilename;

		Paragraph paragraph;
	private DocumentRawType doctype;
	private Document doc;
	com.itextpdf.text.Document document1;
	private int k;
	private List<LineBlock> lineblocks;

	
	public PdfExporter(Document document, String outputFileName) {
		document1=new com.itextpdf.text.Document();
		//this.doc=document1;
		
		this.doc=document;
		this.doctype=this.doc.getInputFileType();
		//this.docuMent=document;
		this.outputfilename=outputFileName;
		this.lineblocks=document.getLineblocks();
		this.k=0;
		
		
	}

	

	public int export(){
		
		try {
			
			PdfWriter.getInstance(document1,new FileOutputStream(this.outputfilename));
		//	PdfWriter.getInstance((, new FileOutputStream(this.outputfilename)));
			Font bold = FontFactory.getFont(FontFactory.TIMES_BOLD);
			Font italic=FontFactory.getFont(FontFactory.TIMES_ITALIC);
	
			document1.open();
	
			for(LineBlock e:this.lineblocks) {
			
			
	
				
				switch(e.getDetermineHeadingStatus()) {
				case OMITTED:
					continue;

				case H1:
					document1.add(new Paragraph(e.getLines().get(0),bold));
					document1.add(new Paragraph("\n"));
					this.k++;
					break;
				case H2:
					document1.add(new Paragraph(e.getLines().get(0)+"\n"));
					document1.add(new Paragraph("\n"));
					this.k++;
					
					break;
				case NORMAL:
					switch(e.getDetermineFormatStatus()) {
					case BOLD:
						document1.add(new Paragraph(e.getLines().get(0),bold));
						document1.add(new Paragraph("\n"));
						this.k++;
						break;
					case ITALICS:
						document1.add(new Paragraph(e.getLines().get(0),italic));
						document1.add(new Paragraph("\n"));
						this.k++;
						break;
					case REGULAR:
						document1.add(new Paragraph(e.getLines().get(0)));
						document1.add(new Paragraph("\n"));
						this.k++;
						break;
					default:
						break;
					
					}
					break;
				default:
					break;
				}
				
				
				
				
				
			}
			
			
			
			document1.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(this.k);
		return this.k; //K
	}
	
	public	Document getDoc() {
		//return this.doc;
		return this.doc;
	}

	public String getOutputfilename() {
		return this.outputfilename;
	}

	public DocumentRawType getDoctype() {
		//return DocumentRawType.RAW;
		return this.doctype;
	}
	

}
