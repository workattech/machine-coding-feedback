package com.ioParser.interfaces;

import java.util.List;

import com.strategies.interfaces.ISplitInput;

// TODO: Auto-generated Javadoc
/**
 * The Interface IInputReader.
 */
public interface IInputReader {
	
	/**
	 * Parses the input.
	 *
	 * @param input the input
	 * @return the i split input
	 */
	ISplitInput parseInput(List<String> input);
}
