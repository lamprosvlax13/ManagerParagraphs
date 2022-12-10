package datamodel.rules;

import datamodel.buildingblocks.FormatEnum;
import datamodel.buildingblocks.LineBlock;
import datamodel.buildingblocks.StyleEnum;

public class RuleUndefined extends AbstractRule {
	
	public RuleUndefined() {
		
		
	}

	@Override
	public boolean isValid(LineBlock paragraph) {
		//System.out.println((paragraph.getDetermineHeadingStatus()));
		//System.out.println( paragraph.getDetermineFormatStatus());
		if(paragraph.getDetermineFormatStatus()!=FormatEnum.REGULAR && paragraph.getDetermineHeadingStatus()==StyleEnum.NORMAL){
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "rule is undefined";
	}

}
