package com.commonClasses;

// TODO: Auto-generated Javadoc
/**
 * The Class Pair.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class Pair<K, V> {
	
	/** The key. */
	private K key;
	
	/** The value. */
	private V value;

	/**
	 * Instantiates a new pair.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public V getValue() {
		return value;
	}
	
	
}
