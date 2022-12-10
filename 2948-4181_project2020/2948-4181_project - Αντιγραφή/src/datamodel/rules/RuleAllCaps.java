package datamodel.rules;


import datamodel.buildingblocks.LineBlock;

public class RuleAllCaps extends AbstractRule {

	@Override
	public boolean isValid(LineBlock paragraph) {
		
		 if( (paragraph.getLines().get(0)).equals(paragraph.getLines().get(0).toUpperCase())) {
	           return true;
	           }
	        else {
	           return false;
	        
	        }
		
		
		//return false;
	}

	@Override
	public String toString() {
		
		return "The rule is:"+"RullAllCaps";
	}

}
