package datamodel.buildingblocks;

import java.util.ArrayList;


import dataload.RawFileLineLoader;


public class Document {

	public static DocumentRawType RAW= new DocumentRawType();

	public static DocumentRawType ANNOTATED=new DocumentRawType();

	private  DocumentRawType documentType;
	private ArrayList<LineBlock> lineblocks;
	private  String filepath;



	

	
	
	

	public Document(String pFilePath, DocumentRawType docType) {
		this.filepath=pFilePath;
	//	Document.documentType=docType;
		this.documentType=docType;
		lineblocks=new ArrayList<LineBlock>(); 
		RawFileLineLoader loaderfile;
		loaderfile=new RawFileLineLoader(this.filepath,lineblocks);
			loaderfile.load(this.filepath,lineblocks);
			this.lineblocks=loaderfile.getLineblocks();
	}

	

	
	public ArrayList<LineBlock> getLineblocks() {
	
		return this.lineblocks;
	}


	public DocumentRawType getInputFileType() {
		if ( this.documentType.equals(RAW)) {
			return this.documentType;
		}else {
			return getANNOTATED();
		}
		
		
	}

	

	public static  DocumentRawType getANNOTATED() {
		
			
			return Document.ANNOTATED;
	
	}
	
	
	

		public static  class DocumentRawType{
		
		public static   DocumentRawType  RAW=Document.RAW;;
		public static  DocumentRawType ANNOTATED=Document.ANNOTATED;
	
	
	
public DocumentRawType() {
	RAW=Document.RAW;
	ANNOTATED=Document.ANNOTATED;
	
}

}
}