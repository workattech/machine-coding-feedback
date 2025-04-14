package com.attribute.interfaces;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface IValueAttribute.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public interface IValueAttribute<K, V> {
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	String toString();
	
	/**
	 * Sets the attribute.
	 *
	 * @param key the key
	 * @param value the value
	 */
	void setAttribute(K key, V value);
	
	/**
	 * Gets the attribute.
	 *
	 * @param key the key
	 * @return the attribute
	 */
	V getAttribute(K key);
	
	/**
	 * Gets the attribute keys.
	 *
	 * @return the attribute keys
	 */
	List<K> getAttributeKeys();
}
