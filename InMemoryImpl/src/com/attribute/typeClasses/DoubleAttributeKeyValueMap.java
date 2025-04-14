package com.attribute.typeClasses;

import com.attribute.AttributeKeyValueMap;
import com.exceptions.DataFormatIncorrectException;

// TODO: Auto-generated Javadoc
/**
 * The Class DoubleAttributeKeyValueMap.
 *
 * @param <Key> the generic type
 * @param <Value> the generic type
 */
public class DoubleAttributeKeyValueMap<Key, Value> extends AttributeKeyValueMap<Double, Key, Value> {

	/**
	 * Gets the value as T.
	 *
	 * @param value the value
	 * @return the value as T
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	@Override
	protected Double getValueAsT(Value value) throws DataFormatIncorrectException {
		if (!this.isValidType(value)) {
			throw new DataFormatIncorrectException();
		}
		
		return Double.parseDouble(value.toString());
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
			if (value.toString().indexOf('.') == -1) {
				return false;
			}
			Double.parseDouble(value.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
