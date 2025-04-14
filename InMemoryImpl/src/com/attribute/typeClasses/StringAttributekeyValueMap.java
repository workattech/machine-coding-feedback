package com.attribute.typeClasses;

import com.attribute.AttributeKeyValueMap;
import com.exceptions.DataFormatIncorrectException;

// TODO: Auto-generated Javadoc
/**
 * The Class StringAttributekeyValueMap.
 *
 * @param <Key> the generic type
 * @param <Value> the generic type
 */
public class StringAttributekeyValueMap<Key, Value> extends AttributeKeyValueMap<String, Key, Value> {

	/**
	 * Gets the value as T.
	 *
	 * @param value the value
	 * @return the value as T
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	@Override
	protected String getValueAsT(Value value) throws DataFormatIncorrectException {
		return value.toString();
	}

	/**
	 * Checks if is valid type.
	 *
	 * @param value the value
	 * @return true, if is valid type
	 */
	@Override
	public boolean isValidType(Value value) {
		return true;
	}

}
