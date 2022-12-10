package datamodel.rules;

import datamodel.buildingblocks.LineBlock;

public class RuleStartWith extends AbstractRule {

	private String prefix;

	public RuleStartWith(String prefix) {
		// TODO Auto-generated constructor stub
		//System.out.println(prefix+"\n");
		this.prefix=prefix;
	}

	@Override
	public boolean isValid(LineBlock paragraph) {
		//System.out.println( paragraph.getLines().get(0).startsWith(this.prefix));
		return paragraph.getLines().get(0).startsWith(this.prefix);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "the rulestartwith";
	}

}
