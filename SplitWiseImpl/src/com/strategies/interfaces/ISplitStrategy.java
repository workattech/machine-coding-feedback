package com.strategies.interfaces;
import com.enums.InputValidationResult;
import com.enums.SplitStrategyType;
import com.strategies.splitObjects.SplitResult;

// TODO: Auto-generated Javadoc
/**
 * The Interface ISplitStrategy.
 */
public interface ISplitStrategy {
	
	/**
	 * Verify input.
	 *
	 * @param splitInput the split input
	 * @return the input validation result
	 */
	InputValidationResult verifyInput(ISplitInput splitInput);
	
	/**
	 * Gets the final split.
	 *
	 * @param splitInput the split input
	 * @return the final split
	 */
	SplitResult getFinalSplit(ISplitInput splitInput);
	
	/**
	 * Gets the spli strategy type.
	 *
	 * @return the spli strategy type
	 */
	SplitStrategyType getSpliStrategyType();
}
