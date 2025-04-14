package com.attribute.typeClasses;

import com.attribute.AttributeKeyValueMap;
import com.exceptions.DataFormatIncorrectException;

// TODO: Auto-generated Javadoc
/**
 * The Class BooleanAttributeKeyValueMap.
 *
 * @param <Key> the generic type
 * @param <Value> the generic type
 */
public class BooleanAttributeKeyValueMap<Key extends Object, Value extends Object> extends AttributeKeyValueMap<Boolean, Key, Value> {

	/**
	 * Gets the value as T.
	 *
	 * @param value the value
	 * @return the value as T
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	@Override
	protected Boolean getValueAsT(Value value) throws DataFormatIncorrectException {
		try {
			return Boolean.parseBoolean(value.toString());
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
			Boolean.parseBoolean(value.toString());
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
