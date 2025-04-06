package com.strategies.equalDivisionStrategy;

import java.util.List;

import com.strategies.interfaces.ISplitInput;
import com.strategies.splitObjects.SplitInput;
import com.strategies.splitObjects.StrategyInputGenerator;

// TODO: Auto-generated Javadoc
/**
 * The Class EqualStrategyInutGenerator.
 */
public class EqualStrategyInutGenerator extends StrategyInputGenerator {
	
	/**
	 * Generate split input.
	 *
	 * @param baseInput the base input
	 * @param input the input
	 * @param lastVisitedIndex the last visited index
	 * @return the equal strategy split input
	 */
	@Override
	public EqualStrategySplitInput generateSplitInput(ISplitInput baseInput, List<String> input, int lastVisitedIndex) {
		SplitInput baseInput2 = super.generateSplitInput(baseInput, input, lastVisitedIndex);
		
		return new EqualStrategySplitInput(baseInput2.getPaidBy(), baseInput2.getParticipants(), baseInput2.getPaidAmount());
	}
}
