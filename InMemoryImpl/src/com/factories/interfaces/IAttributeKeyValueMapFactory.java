package com.factories.interfaces;

import com.attribute.interfaces.IAttributeKeyValueMap;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating IAttributeKeyValueMap objects.
 */
public interface IAttributeKeyValueMapFactory {
	
	/**
	 * Creates a new IAttributeKeyValueMap object.
	 *
	 * @param <K> the key type
	 * @param <V> the value type
	 * @param value the value
	 * @return the i attribute key value map< k, v>
	 */
	<K, V> IAttributeKeyValueMap<K, V> createAttributeKeyValueMap(V value);
}
