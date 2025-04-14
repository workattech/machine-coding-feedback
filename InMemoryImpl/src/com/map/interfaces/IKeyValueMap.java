package com.map.interfaces;

import java.util.List;

import com.attribute.interfaces.IValueAttribute;
import com.exceptions.DataFormatIncorrectException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IKeyValueMap.
 *
 * @param <Key> the generic type
 * @param <AttributeKey> the generic type
 * @param <AttributeValue> the generic type
 */
public interface IKeyValueMap<Key extends Object, AttributeKey extends Object, AttributeValue extends Object> {
	
	/**
	 * Gets the.
	 *
	 * @param key the key
	 * @return the i value attribute
	 */
	IValueAttribute<AttributeKey, AttributeValue> get(Key key);
	
	/**
	 * Put.
	 *
	 * @param key the key
	 * @param value the value
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	void put(Key key, IValueAttribute<AttributeKey, AttributeValue> value) throws DataFormatIncorrectException;
	
	/**
	 * Gets the key containing attribute key value pair.
	 *
	 * @param attribute the attribute
	 * @param value the value
	 * @return the key containing attribute key value pair
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	List<Key> getKeyContainingAttributeKeyValuePair(AttributeKey attribute, AttributeValue value) throws DataFormatIncorrectException;
	
	/**
	 * Gets the keys.
	 *
	 * @return the keys
	 */
	List<Key> getKeys();
	
	/**
	 * Delete key.
	 *
	 * @param key the key
	 */
	void deleteKey(Key key);

}
