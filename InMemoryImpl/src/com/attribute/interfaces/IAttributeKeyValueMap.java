package com.attribute.interfaces;

import java.util.List;

import com.exceptions.DataFormatIncorrectException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IAttributeKeyValueMap.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public interface IAttributeKeyValueMap<K, V> {
	
	/**
	 * Gets the.
	 *
	 * @param key the key
	 * @return the v
	 */
	V get(K key);
	
	/**
	 * Put.
	 *
	 * @param key the key
	 * @param value the value
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	void put(K key, V value) throws DataFormatIncorrectException;
	
	/**
	 * Contains key.
	 *
	 * @param key the key
	 * @return true, if successful
	 */
	boolean containsKey(K key);
	
	/**
	 * Checks if is valid type.
	 *
	 * @param value the value
	 * @return true, if is valid type
	 */
	boolean isValidType(V value);
	
	/**
	 * Gets the keys with values.
	 *
	 * @param value the value
	 * @return the keys with values
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	List<K> getkeysWithValues(V value) throws DataFormatIncorrectException;
	
	/**
	 * Delete key.
	 *
	 * @param key the key
	 */
	void deleteKey(K key);
 }
