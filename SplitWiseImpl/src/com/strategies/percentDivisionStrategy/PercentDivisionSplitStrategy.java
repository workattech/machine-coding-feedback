package com.strategies.percentDivisionStrategy;

import java.util.HashMap;
import java.util.Iterator;

import com.enums.InputValidationResult;
import com.enums.SplitStrategyType;
import com.strategies.interfaces.ISplitInput;
import com.strategies.interfaces.ISplitStrategy;
import com.strategies.splitObjects.SplitResult;

// TODO: Auto-generated Javadoc
/**
 * The Class PercentDivisionSplitStrategy.
 */
public class PercentDivisionSplitStrategy implements ISplitStrategy {
	
	/** The percentage 100. */
	static public double PERCENTAGE_100 = 100.0;

	/**
	 * Verify input.
	 *
	 * @param splitInput the split input
	 * @return the input validation result
	 */
	@Override
	public InputValidationResult verifyInput(ISplitInput splitInput) {
		try {
			PercentDivisionSplitInput input = (PercentDivisionSplitInput) splitInput;
			
			Iterator<String> it = input.getPercentOwedMap().keySet().iterator();
			double sum = 0.0;
			while (it.hasNext()) {
				sum += input.getPercentOwedMap().get(it.next());
			}
			
			if (sum != PercentDivisionSplitStrategy.PERCENTAGE_100) {
				return InputValidationResult.SUM_NOT_EQUAL_TO_TOTAL_PAID;
			}
			
			return InputValidationResult.VALID;
		} catch (Exception e) {
			return InputValidationResult.WRONG_INPUT_FORMAT;
		}
	}

	/**
	 * Gets the final split.
	 *
	 * @param splitInput the split input
	 * @return the final split
	 */
	@Override
	public SplitResult getFinalSplit(ISplitInput splitInput) {
		if (this.verifyInput(splitInput) != InputValidationResult.VALID) {
			return null;
		}

		PercentDivisionSplitInput input = (PercentDivisionSplitInput) splitInput;
		
		HashMap<String, HashMap<String, Double>> owedByMap = new HashMap<String, HashMap<String, Double>>();
		HashMap<String, HashMap<String, Double>> owedToMap = new HashMap<String, HashMap<String, Double>>();
		HashMap<String, Double> owedMap = new HashMap<String, Double>();
		HashMap<String, Double> owesMap = new HashMap<String, Double>();
		
		owedByMap.put(input.getPaidBy(), new HashMap<String, Double>());
		
		Iterator<String> it = input.getPercentOwedMap().keySet().iterator();
		
		double sum = 0.0;
		
		while (it.hasNext()) {
			String next = it.next();
			
			if (owedByMap.containsKey(next)) {
				continue;
			}
			
			double amountOwed = (input.getPercentOwedMap().get(next) * input.getPaidAmount()) / 100.0;
			
			owedByMap.get(input.getPaidBy()).put(next, amountOwed);
			
			if (!owedToMap.containsKey(next)) {
				owedToMap.put(next, new HashMap<String, Double>());
			}
			
			
			owedToMap.get(next).put(input.getPaidBy(), amountOwed);
			
			owesMap.put(next, amountOwed);
			
			sum += amountOwed;
		}
		
		owedMap.put(input.getPaidBy(), sum);
		
		return new SplitResult(owedByMap, owedToMap, owedMap, owesMap);
	}

	/**
	 * Gets the spli strategy type.
	 *
	 * @return the spli strategy type
	 */
	@Override
	public SplitStrategyType getSpliStrategyType() {
		// TODO Auto-generated method stub
		return SplitStrategyType.PERCENT;
	}

}
