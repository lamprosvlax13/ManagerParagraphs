package datamodel.rules;

import java.util.List;

import datamodel.buildingblocks.LineBlock;

public class RuleInPosition extends AbstractRule {

	private List<LineBlock> pLineblocks;
	private List<Integer> pPositions;

	public RuleInPosition(List<LineBlock> pLineblocks, List<Integer> pPositions) {
		this.pLineblocks=pLineblocks;
		this.pPositions=pPositions;
	}

	

	@Override
	public boolean isValid(LineBlock paragraph) {
		
		for (Integer pPosition : pPositions) {
			if(pLineblocks.get(pPosition).getLines().get(0).equals(paragraph.getLines().get(0))) {
				//if(pLineblocks.get(pPosition).getLines().get(0).equals(paragraph.getLines().get(0)))
				return true;
			}else {
				continue;
			}
			
		}
	
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rule in Position";
	}



	public List<LineBlock> getpLineblocks() {
		return this.pLineblocks;
	}



	public List<Integer> getpPositions() {
		return this.pPositions;
	}

}
