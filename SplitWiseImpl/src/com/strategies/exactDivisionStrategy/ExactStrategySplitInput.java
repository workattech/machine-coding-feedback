package com.strategies.exactDivisionStrategy;

import java.util.HashMap;
import java.util.List;

import com.enums.SplitStrategyType;
import com.strategies.splitObjects.SplitInput;

// TODO: Auto-generated Javadoc
/**
 * The Class ExactStrategySplitInput.
 */
public class ExactStrategySplitInput extends SplitInput {
	
	/** The exact amount owed map. */
	private HashMap<String, Double> exactAmountOwedMap;
	
	/**
	 * Instantiates a new exact strategy split input.
	 *
	 * @param paidBy the paid by
	 * @param participants the participants
	 * @param paidAmount the paid amount
	 * @param exactAmountOwedMap the exact amount owed map
	 */
	public ExactStrategySplitInput(String paidBy, List<String> participants, double paidAmount,
			HashMap<String, Double> exactAmountOwedMap) {
		super(paidBy, participants, paidAmount);
		this.exactAmountOwedMap = exactAmountOwedMap;
	}

	/**
	 * Gets the exact amount owed map.
	 *
	 * @return the exact amount owed map
	 */
	public HashMap<String, Double> getExactAmountOwedMap() {
		return exactAmountOwedMap;
	}

	/**
	 * Gets the split input type.
	 *
	 * @return the split input type
	 */
	@Override
	public SplitStrategyType getSplitInputType() {
		
		// TODO Auto-generated method stub
		return SplitStrategyType.EXACT;
	}

	
}
