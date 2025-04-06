package com.strategies.splitObjects;

import java.util.List;

import com.strategies.interfaces.ISplitInput;
import com.strategies.interfaces.IStrategyInputGenerator;

// TODO: Auto-generated Javadoc
/**
 * The Class StrategyInputGenerator.
 */
public abstract class StrategyInputGenerator implements IStrategyInputGenerator {

	/**
	 * Generate split input.
	 *
	 * @param baseInput the base input
	 * @param input the input
	 * @param lastVisitedIndex the last visited index
	 * @return the split input
	 */
	@Override
	public SplitInput generateSplitInput(ISplitInput baseInput, List<String> input, int lastVisitedIndex) {
		try {
			return (SplitInput) baseInput;
		} catch (Exception e) {
			return null;
		}
	}

}
