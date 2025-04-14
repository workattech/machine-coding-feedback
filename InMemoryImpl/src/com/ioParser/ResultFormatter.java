package com.ioParser;

import java.util.List;

import com.attribute.interfaces.IValueAttribute;
import com.ioParser.interfaces.IResultFormatter;

// TODO: Auto-generated Javadoc
/**
 * The Class ResultFormatter.
 */
public class ResultFormatter implements IResultFormatter<String, String, String> {

	/**
	 * Gets the result string.
	 *
	 * @param valueAttribute the value attribute
	 * @return the result string
	 */
	@Override
	public String getResultString(IValueAttribute<String, String> valueAttribute) {
		if (valueAttribute == null) {
			return "";
		}
		return valueAttribute.toString();
	}

	/**
	 * Gets the result string.
	 *
	 * @param keys the keys
	 * @return the result string
	 */
	@Override
	public String getResultString(List<String> keys) {
		if (keys == null || keys.size() == 0) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(keys.get(0));
		
		int i = 1;
		
		while (i < keys.size()) {
			sb.append(",");
			
			sb.append(keys.get(i));
			
			i++;
		}
		
		return sb.toString();
	}

}
