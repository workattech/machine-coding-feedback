package com.keyvalueStore.interfaces;

import java.util.List;

import com.attribute.interfaces.IValueAttribute;
import com.commonClasses.Pair;
import com.exceptions.DataFormatIncorrectException;


// TODO: Auto-generated Javadoc
/**
 * The Interface IKeyValueStore.
 *
 * @param <Key> the generic type
 * @param <AttributeKey> the generic type
 * @param <AttributeValue> the generic type
 */
public interface IKeyValueStore<Key extends Object, AttributeKey extends Object, AttributeValue extends Object> {
	
	/**
	 * Gets the.
	 *
	 * @param key the key
	 * @return the i value attribute
	 */
	IValueAttribute<AttributeKey, AttributeValue> get(Key key);
	
	/**
	 * Search.
	 *
	 * @param attributeKey the attribute key
	 * @param attributeValue the attribute value
	 * @return the list
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	List<Key> search(AttributeKey attributeKey, AttributeValue attributeValue) throws DataFormatIncorrectException;
	
	/**
	 * Put.
	 *
	 * @param key the key
	 * @param listOfAttributesPair the list of attributes pair
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	void put(Key key, List<Pair<AttributeKey, AttributeValue>> listOfAttributesPair) throws DataFormatIncorrectException;
	
	/**
	 * Delete.
	 *
	 * @param key the key
	 */
	void delete(Key key);
	
	/**
	 * Keys.
	 *
	 * @return the list
	 */
	List<Key> keys();
}
