package com.attribute.typeClasses;


import com.attribute.AttributeKeyValueMap;
import com.exceptions.DataFormatIncorrectException;

// TODO: Auto-generated Javadoc
/**
 * The Class IntegerAttributeKeyValueMap.
 *
 * @param <Key> the generic type
 * @param <Value> the generic type
 */
public class IntegerAttributeKeyValueMap<Key, Value> extends AttributeKeyValueMap<Integer, Key, Value> {

	/**
	 * Gets the value as T.
	 *
	 * @param value the value
	 * @return the value as T
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	@Override
	protected Integer getValueAsT(Value value) throws DataFormatIncorrectException {
		
		try {
			return Integer.parseInt(value.toString());
		} catch (Exception e) {
			throw new DataFormatIncorrectException();
		}
	}

	/**
	 * Checks if is valid type.
	 *
	 * @param value the value
	 * @return true, if is valid type
	 */
	@Override
	public boolean isValidType(Value value) {
		try {
			
			Integer.parseInt(value.toString());
			
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
}
