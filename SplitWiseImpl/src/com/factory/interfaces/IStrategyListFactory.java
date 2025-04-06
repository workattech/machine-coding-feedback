package com.factory.interfaces;

import java.util.List;

import com.interfaces.IStrategyList;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating IStrategyList objects.
 */
public interface IStrategyListFactory {
	
	/**
	 * Gets the strategy list.
	 *
	 * @param strategiesPresent the strategies present
	 * @return the strategy list
	 */
	IStrategyList getStrategyList(List<String> strategiesPresent);
}
