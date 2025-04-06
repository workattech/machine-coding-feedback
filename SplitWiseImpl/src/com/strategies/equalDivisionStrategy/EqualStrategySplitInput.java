package com.strategies.equalDivisionStrategy;

import java.util.List;

import com.enums.SplitStrategyType;
import com.strategies.splitObjects.SplitInput;

// TODO: Auto-generated Javadoc
/**
 * The Class EqualStrategySplitInput.
 */
public class EqualStrategySplitInput extends SplitInput {

	/**
	 * Instantiates a new equal strategy split input.
	 *
	 * @param paidBy the paid by
	 * @param participants the participants
	 * @param paidAmount the paid amount
	 */
	public EqualStrategySplitInput(String paidBy, List<String> participants, double paidAmount) {
		super(paidBy, participants, paidAmount);
	}

	/**
	 * Gets the split input type.
	 *
	 * @return the split input type
	 */
	@Override
	public SplitStrategyType getSplitInputType() {
		
		// TODO Auto-generated method stub
		return SplitStrategyType.EQUAL;
	}
	
	

}
