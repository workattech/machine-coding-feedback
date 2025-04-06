package com.strategies.interfaces;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface IStrategyInputGenerator.
 */
public interface IStrategyInputGenerator {
	
	/**
	 * Generate split input.
	 *
	 * @param baseInput the base input
	 * @param input the input
	 * @param lastVisitedIndex the last visited index
	 * @return the i split input
	 */
	ISplitInput generateSplitInput(ISplitInput baseInput, List<String> input, int lastVisitedIndex);
}
