package com.interfaces;

import java.util.Map;

import com.enums.SplitStrategyType;
import com.strategies.interfaces.ISplitStrategy;

// TODO: Auto-generated Javadoc
/**
 * The Interface IStrategyList.
 */
public interface IStrategyList {
	
	/**
	 * Gets the split strategies.
	 *
	 * @return the split strategies
	 */
	Map<SplitStrategyType, ISplitStrategy> getSplitStrategies();
}
