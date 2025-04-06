package com.strategies.equalDivisionStrategy;

import java.util.HashMap;
import java.util.ListIterator;

import com.enums.InputValidationResult;
import com.enums.SplitStrategyType;
import com.strategies.interfaces.ISplitInput;
import com.strategies.interfaces.ISplitStrategy;
import com.strategies.splitObjects.SplitResult;

// TODO: Auto-generated Javadoc
/**
 * The Class EqualDivisionSplitStrategy.
 */
public class EqualDivisionSplitStrategy implements ISplitStrategy {
	
	
	/**
	 * Instantiates a new equal division split strategy.
	 */
	public EqualDivisionSplitStrategy() {
		// TODO Auto-generated constructor stub
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
			
		EqualStrategySplitInput input;
		
		input = (EqualStrategySplitInput) splitInput;
		
		
		HashMap<String, HashMap<String, Double>> owedByMap = new HashMap<String, HashMap<String, Double>>();
		HashMap<String, HashMap<String, Double>> owedToMap = new HashMap<String, HashMap<String, Double>>();
		HashMap<String, Double> owedMap = new HashMap<String, Double>();
		HashMap<String, Double> owesMap = new HashMap<String, Double>();
		
		double amountPerPerson = input.getPaidAmount() / input.getParticipants().size();
		
		owedByMap.put(input.getPaidBy(), new HashMap<String, Double>());
		
		
		ListIterator<String> it = input.getParticipants().listIterator();
		
		while (it.hasNext()) {
			String next = it.next();
			
			if (owedByMap.containsKey(next)) {
				continue;
			}
			
			owedByMap.get(input.getPaidBy()).put(next, amountPerPerson);
			
			if (!owedToMap.containsKey(next)) {
				owedToMap.put(next, new HashMap<String, Double>());
			}
			
			owedToMap.get(next).put(input.getPaidBy(), amountPerPerson);
			
			owesMap.put(next, amountPerPerson);
			
		}
		
		owedMap.put(input.getPaidBy(), amountPerPerson * input.getParticipants().size());
		
		return new SplitResult(owedByMap, owedToMap, owedMap, owesMap);
		
	}

	/**
	 * Verify input.
	 *
	 * @param splitInput the split input
	 * @return the input validation result
	 */
	@Override
	public InputValidationResult verifyInput(ISplitInput splitInput) {
		try {
			EqualStrategySplitInput input;
			
			input = (EqualStrategySplitInput) splitInput;
			
			return input != null ? InputValidationResult.VALID : InputValidationResult.WRONG_INPUT_FORMAT;
		} catch (Exception e) {
			return InputValidationResult.WRONG_INPUT_FORMAT;
		}
	}

	/**
	 * Gets the spli strategy type.
	 *
	 * @return the spli strategy type
	 */
	@Override
	public SplitStrategyType getSpliStrategyType() {
		// TODO Auto-generated method stub
		return SplitStrategyType.EQUAL;
	}

	

}
