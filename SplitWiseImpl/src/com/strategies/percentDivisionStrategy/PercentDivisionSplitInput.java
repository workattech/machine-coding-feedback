package com.strategies.percentDivisionStrategy;

import java.util.HashMap;
import java.util.List;

import com.enums.SplitStrategyType;
import com.strategies.splitObjects.SplitInput;

// TODO: Auto-generated Javadoc
/**
 * The Class PercentDivisionSplitInput.
 */
public class PercentDivisionSplitInput extends SplitInput {
	
	/** The percent owed map. */
	private HashMap<String, Double> percentOwedMap;
	
	/**
	 * Instantiates a new percent division split input.
	 *
	 * @param paidBy the paid by
	 * @param participants the participants
	 * @param paidAmount the paid amount
	 * @param percentOwedMap the percent owed map
	 */
	public PercentDivisionSplitInput(String paidBy, List<String> participants, double paidAmount,
			HashMap<String, Double> percentOwedMap) {
		super(paidBy, participants, paidAmount);
		this.percentOwedMap = percentOwedMap;
	}

	/**
	 * Gets the percent owed map.
	 *
	 * @return the percent owed map
	 */
	public HashMap<String, Double> getPercentOwedMap() {
		return percentOwedMap;
	}

	/**
	 * Gets the split input type.
	 *
	 * @return the split input type
	 */
	@Override
	public SplitStrategyType getSplitInputType() {
		
		return SplitStrategyType.PERCENT;
	}
}
