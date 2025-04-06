package com.ioParser.interfaces;

import java.util.List;

import com.dataStore.interfaces.IUserDataStore;
import com.strategies.splitObjects.SplitResult;

// TODO: Auto-generated Javadoc
/**
 * The Interface IResultFormatter.
 */
public interface IResultFormatter {
	
	/**
	 * Gets the formatted result.
	 *
	 * @param splitResult the split result
	 * @return the formatted result
	 */
	List<String> getFormattedResult(SplitResult splitResult, IUserDataStore userDataStore);
}
