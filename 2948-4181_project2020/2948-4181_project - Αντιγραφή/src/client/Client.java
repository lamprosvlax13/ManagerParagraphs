package client;




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import engine.EngineFactory;
import engine.IPlainTextDocumentEngine;


public class Client {
	private static List<String> omList; 
	private static List<String> h1List; 
	private static List<String> h2List; 
	private static List<String> boldList; 
	private static List<String> italicsList;
	private static List<List<String>> inputSpec;
//	private static IPlainTextDocumentEngine engine;
	private static List<String> prefixes;
	
	
	private Scanner reader;
	 
	
	 
	
	
	
	
	public Client() {
		reader = new Scanner(System.in);
	}
	
	
	public Scanner getReader(){
		return reader;
	}
	
	
	
	public int printMenu(){
		
	
		int user =0;
		while(user>3 || user<=0){
			System.out.println("Θέλετε να επεξεργαστείτε αρχείο ?");
			System.out.println("Choose(1-3)\n 1.YES\n 2.NO \n 3. Exit");
			user = reader.nextInt();
			if(user >3 || user <= 0)
				System.out.println("Wrong answer! Try again...");
			System.out.println(user);
		}
		
		return user;
	}

			
	public void closeReader(){
		reader.close();
	}
		
private int choseService2(String string) {
		
		int answer =0;
		while( answer > 4 || answer <= 0){
			System.out.println(string);
			answer = reader.nextInt();
			if(answer > 4 || answer <= 0)
				System.out.println("Wrong answer! Try again...");
		}
		return answer;
	}

	
	private int choseService(String string) {
		int answer =0;
		while( answer > 2 || answer <= 0){
			System.out.println(string);
			answer = reader.nextInt();
			if(answer > 2 || answer <= 0)
				System.out.println("Wrong answer! Try again...");
		}
		return answer;
	}
	
	private static void OMIT() {
		Client ap=new Client();
		int a= ap.choseService("Θέλετε να παραλήψετε παραγράφους οι οποιοι ακολουθούν ένα κανόνα?(πχ ALL_CAPS,H1,STARTWITH\n1.YES\n2. No");
		if(a==2){
			System.out.println("Δώστε παραφράφους που θα παραληφθούν. (με φορμάτ πχ 1,2,3");
			Scanner input = new Scanner(System.in); 
			omList = new ArrayList<String>(); inputSpec.add(omList);
			omList.add("OMIT");omList.add("POSITIONS");
			omList.add(input.nextLine());
		}else {
		
			int b=ap.choseService2("Δώστε  τον κανόνα το παραγράφων που θελετε να παραλφθουν\n1.ALL_CAPS\n2.STARTWITH\n3.H1\n4.H2");
			if(b==1) {
				
				omList = new ArrayList<String>(); inputSpec.add(omList);
				omList.add("OMIT");omList.add("ALL_CAPS");
			}else if(b==2) {
				System.out.println("Δώσε startwith παραγράφου");
				Scanner in =new Scanner(System.in);
			
				omList = new ArrayList<String>(); inputSpec.add(omList);
				omList.add("OMIT");omList.add("STARTS_WITH"); omList.add(in.nextLine());
			}else if(b==3) {
				omList = new ArrayList<String>(); inputSpec.add(omList);
				omList.add("OMIT");omList.add("H1"); 
			}else {
				omList = new ArrayList<String>(); inputSpec.add(omList);
				omList.add("OMIT");omList.add("H2"); 
			}
			
	
		}
		
		
		
		
	}
	


	private static void H1() {
		Client ap=new Client();
		int a= ap.choseService("Θέλετε να χαρακτηρίσετε  παραγράφους ως Η1 οι οποιοι ακολουθούν ένα κανόνα?(πχ ALL_CAPS,H1,STARTWITH\n1.YES\n2. No");
		if(a==2){
			System.out.println("Δώστε παραφράφους που θα χαρακτηριστούν ως Η1. (με φορμάτ πχ 1,2,3");
			Scanner input = new Scanner(System.in); 
			h1List = new ArrayList<String>(); inputSpec.add(h1List);
			h1List.add("H1");h1List.add("POSITIONS");
			h1List.add(input.nextLine());
		}else {
			
			
			int b=ap.choseService2("Δώστε  τον κανόνα το παραγράφων που θελετε να χαρακτηριστούν\n1.ALL_CAPS\n2.STARTWITH\n3.H2");
			if(b==1) {
				
				h1List = new ArrayList<String>(); inputSpec.add(h1List);
				h1List.add("H1");h1List.add("ALL_CAPS");
			}else if(b==2) {
				System.out.println("Δώσε startwith παραγράφου");
				Scanner in =new Scanner(System.in);
				
				h1List = new ArrayList<String>(); inputSpec.add(h1List);
				h1List.add("H1");h1List.add("STARTS_WITH"); h1List.add(in.nextLine());
			}else if(b==3) {
				h1List = new ArrayList<String>(); inputSpec.add(h1List);
				h1List.add("H1");h1List.add("H2");
			}
			
		//	omList.add(input.nextLine());
		}
		
		
	}
	private static void H2() {
		
		Client ap=new Client();
		int a= ap.choseService("Θέλετε να χαρακτηρίσετε  παραγράφους ως Η2 οι οποιοι ακολουθούν ένα κανόνα?(πχ ALL_CAPS,H1,STARTWITH\n1.YES\n2. No");
		if(a==2){
			System.out.println("Δώστε παραφράφους που θα χαρακτηριστούν ως Η2. (με φορμάτ πχ 1,2,3");
			Scanner input = new Scanner(System.in); 
			h2List = new ArrayList<String>(); inputSpec.add(h2List);
			h2List.add("H2");h2List.add("POSITIONS");
			h2List.add(input.nextLine());
		}else {
			
			
			int b=ap.choseService2("Δώστε  τον κανόνα το παραγράφων που θελετε να χαρακτηριστούν\n1.ALL_CAPS\n2.STARTWITH\n3.H1");
			if(b==1) {
				
				h2List = new ArrayList<String>(); inputSpec.add(h2List);
				h2List.add("H2");h2List.add("ALL_CAPS");
			}else if(b==2) {
				System.out.println("Δώσε startwith παραγράφου");
				Scanner in =new Scanner(System.in);
				in.nextLine();
				h2List = new ArrayList<String>(); inputSpec.add(h2List);
				h2List.add("H2");h2List.add("STARTS_WITH"); h2List.add(in.nextLine());
			}else if(b==3) {
				h2List = new ArrayList<String>(); inputSpec.add(h2List);
				h2List.add("H2");h2List.add("H1"); 
			}
			
		//	omList.add(input.nextLine());
		}
		
		
		
		
		
		
		
	}
	private static void BOLD() {
	
		Client ap=new Client();
		int a= ap.choseService("Θέλετε να χαρακτηρίσετε  παραγράφους ως BOLD οι οποιοι ακολουθούν ένα κανόνα?(πχ ALL_CAPS,H1,H2,STARTWITH\n1.YES\n2. No");
		if(a==2){
			System.out.println("Δώστε παραφράφους που θα χαρακτηριστούν ως BOLD. (με φορμάτ πχ 1,2,3");
			Scanner input = new Scanner(System.in); 
			boldList = new ArrayList<String>(); inputSpec.add(boldList);
			boldList.add("<B>");boldList.add("POSITIONS");
			boldList.add(input.nextLine());
		}else {
			
			
			int b=ap.choseService2("Δώστε  τον κανόνα το παραγράφων που θελετε να χαρακτηριστούν\n1.ALL_CAPS\n2.STARTWITH\n3.H1\n4.H2");
			if(b==1) {
				
				boldList = new ArrayList<String>(); inputSpec.add(boldList);
				boldList.add("<B>");boldList.add("ALL_CAPS");
			}else if(b==2) {
				System.out.println("Δώσε startwith παραγράφου");
				Scanner in =new Scanner(System.in);
				//in.nextLine();
				boldList = new ArrayList<String>(); inputSpec.add(boldList);
				boldList.add("<B>");boldList.add("STARTS_WITH"); boldList.add(in.nextLine());
			}else if(b==3) {
				boldList = new ArrayList<String>(); inputSpec.add(boldList);
				boldList.add("<B>");boldList.add("H1"); 
			}else {
				boldList = new ArrayList<String>(); inputSpec.add(boldList);
				boldList.add("<B>");boldList.add("H2"); 
			}
			
		//	omList.add(input.nextLine());
		}
	
	}
	private static void ITALIC() {
		Client ap=new Client();
		int a= ap.choseService("Θέλετε να χαρακτηρίσετε  παραγράφους ως ITALIC οι οποιοι ακολουθούν ένα κανόνα?(πχ ALL_CAPS,H1,H2,STARTWITH\n1.YES\n2. No");
		if(a==2){
			System.out.println("Δώστε παραφράφους που θα χαρακτηριστούν ως ITALIC. (με φορμάτ πχ 1,2,3");
			Scanner input = new Scanner(System.in); 
			italicsList = new ArrayList<String>(); inputSpec.add(italicsList);
			italicsList.add("<I>");italicsList.add("POSITIONS");
			italicsList.add(input.nextLine());
		}else {
			
			
			int b=ap.choseService2("Δώστε  τον κανόνα το παραγράφων που θελετε να χαρακτηριστούν\n1.ALL_CAPS\n2.STARTWITH\n3.H1\n4.H2");
			if(b==1) {
				
				italicsList = new ArrayList<String>(); inputSpec.add(italicsList);
				italicsList.add("<I>");italicsList.add("ALL_CAPS");
			}else if(b==2) {
				System.out.println("Δώσε startwith παραγράφου");
				Scanner in =new Scanner(System.in);
				
				italicsList = new ArrayList<String>(); inputSpec.add(italicsList);
				italicsList.add("<I>");italicsList.add("STARTS_WITH"); italicsList.add(in.nextLine());
			}else if(b==3) {
				italicsList = new ArrayList<String>(); inputSpec.add(italicsList);
				italicsList.add("<I>");italicsList.add("H1"); 
			}else {
				italicsList = new ArrayList<String>(); inputSpec.add(italicsList);
				italicsList.add("<I>");italicsList.add("H2"); 
			}
			
		//	omList.add(input.nextLine());
		}
		
		
	}
		
	private static void setRULESRAW() {
		Client app1 =new Client();
		inputSpec = new ArrayList<List<String>>();
		
		int service1=app1.choseService("θελετε να παραληφθουν παραγραφοι?\n1 YES\n2. NO");
		if(service1==1) {
			OMIT();
		}
		int service2=app1.choseService("θελετε να χαρακτηρισετε ως Η1?\n1 YES\n2. NO");
		if(service2==1) {
			H1();
		}
		int service3=app1.choseService("θελετε να χαρακτηρισετε ως Η2?\n1 YES\n2. NO");
		if(service3==1) {
			H2();
		}
		
		int service4=app1.choseService("θελετε να χαρακτηρισετε ως BOLD?\n1 YES\n2. NO");
		if(service4==1) {
			BOLD();
		}
		int service5 =app1.choseService("θελετε να χαρακτηρισετε ως ITALIC?\n1 YES\n2. NO");
		if(service5==1) {
			ITALIC();
			}
	
		
	}
	
private static void setRulesAnnotated() {
	
	Client app1 =new Client();
	inputSpec = new ArrayList<List<String>>();
	
	int service1=app1.choseService("θελετε να παραληφθουν παραγραφοι?\n1 YES\n2. NO");
	if(service1==1) {
		OMIT_2();
		
		//prefixes.add("");
	}
	int service2=app1.choseService("θελετε να χαρακτηρισετε ως Η1?\n1 YES\n2. NO");
	if(service2==1) {
		H1_2();
		prefixes.add("<H1>");
	}
	int service3=app1.choseService("θελετε να χαρακτηρισετε ως Η2?\n1 YES\n2. NO");
	if(service3==1) {
		H2_2();
		prefixes.add("<H2>");
	}
	
	int service4=app1.choseService("θελετε να χαρακτηρισετε ως BOLD?\n1 YES\n2. NO");
	if(service4==1) {
		BOLD_2();
		prefixes.add("<b>");
	}
	int service5 =app1.choseService("θελετε να χαρακτηρισετε ως ITALIC?\n1 YES\n2. NO");
	if(service5==1) {
		ITALIC_2();
		prefixes.add("<i>");
		}

	prefixes.add("<p>");
		
	}

	private static void ITALIC_2() {
	// TODO Auto-generated method stub
	
			italicsList = new ArrayList<String>(); inputSpec.add(italicsList);
			italicsList.add("<I>");italicsList.add("STARTS_WITH");
			italicsList.add("<i>");
		
}


	private static void BOLD_2() {
	
		boldList = new ArrayList<String>(); inputSpec.add(boldList);
		boldList.add("<B>");boldList.add("STARTS_WITH");
		boldList.add("<b>");

		
}


	private static void H2_2() {
	
		
			
			h2List = new ArrayList<String>(); inputSpec.add(h2List);
			h2List.add("H2");h2List.add("STARTS_WITH");
			h2List.add("<H2>");
	
			
	}


	private static void H1_2() {
	
		
			h1List = new ArrayList<String>(); inputSpec.add(h1List);
			h1List.add("H1");h1List.add("STARTS_WITH");
			h1List.add("<H1>");
		
		
		
}


	private static void OMIT_2() {
	
	
			System.out.println("Δώστε παραφράφους που θα παραληφθούν. (με φορμάτ πχ 1,2,3");
			Scanner input = new Scanner(System.in); 
			omList = new ArrayList<String>(); inputSpec.add(omList);
			omList.add("OMIT");omList.add("POSITIONS");
			omList.add(input.nextLine());
		
	
}


	public static void main(String[] args)  {
		EngineFactory myengine= new EngineFactory();
		Client app =new Client();
		while(true) {
			
			int answer=app.printMenu();
			if(answer==1) {
				System.out.println("Δωσε το παθ του αρχειου");
				String path=app.getReader().next();
				//System.out.println(path);
				System.out.println("Δωσε tυπο του αρχειου");
				int type =app.choseService("Διάλεξε τύπο αρχείο(1/2)\n"+
				"1. RAW\n2 ANNOTATED");
				
				System.out.println("Δωσε όνομα  αρχειου");
				String name =app.getReader().next();
				
				if(type==1) {
					
					final IPlainTextDocumentEngine myengi= myengine.createEngine(path, "RAW", name);
					
					int service =app.choseService("διαλεξε λειτουργια\n"+
					"1. reportwithstast\n2 setRUles");
					if(service==1) {
					System.out.println(	myengi.reportWithStats());
					}else if(service==2) {
						setRULESRAW();
						
							myengi.registerInputRuleSetForPlainFiles(inputSpec);
							
							int service2=app.choseService("διαλεξε λειτουργία\n"+
									"1. exportpdf/n2. exportmd");
							if(service2==1) {
								System.out.println("Δώσε path παραγόμενου αρχείου");
								String pathout=app.reader.next();
								myengi.exportPdf(pathout);
							}else {
								System.out.println("Δώσε path παραγόμενου αρχείου");
								String pathout=app.reader.next();
								myengi.loadFileAndCharacterizeBlocks();
								myengi.exportMarkDown(pathout);
							}
					}
						
				
					
				}else {
					final IPlainTextDocumentEngine myengi= myengine.createEngine(path, "ANNOTATED", name);
					//myengi.loadFileAndCharacterizeBlocks();
					int service =app.choseService("διαλεξε λειτουργια\n"+
							"1. reportwithstast\n2 setRUles");
							if(service==1) {
							System.out.println(	myengi.reportWithStats());
							}else if(service==2) {
								 prefixes = new ArrayList<String>(); 
								setRulesAnnotated();
								
									myengi.registerInputRuleSetForAnnotatedFiles(inputSpec, prefixes);
									myengi.loadFileAndCharacterizeBlocks();
									int service2=app.choseService("διαλεξε λειτουργία\n"+
											"1. exportpdf/n2. exportmd");
									if(service2==1) {
										System.out.println("Δώσε path παραγόμενου αρχείου");
										String pathout=app.reader.next();
										myengi.exportPdf(pathout);
									}else {
										System.out.println("Δώσε path παραγόμενου αρχείου");
										String pathout=app.reader.next();
										myengi.exportMarkDown(pathout);
									}
							}
					
					
					
					
					
					
				}
			}else {
				
				break;
		}
		
}


		app.closeReader();
	
	
	
	}


	
}