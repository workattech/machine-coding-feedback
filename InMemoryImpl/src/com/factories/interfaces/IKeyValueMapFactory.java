package com.factories.interfaces;

import com.map.interfaces.IKeyValueMap;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating IKeyValueMap objects.
 */
public interface IKeyValueMapFactory {
	
	/**
	 * Gets the key value map.
	 *
	 * @param <Key> the generic type
	 * @param <AttributeKey> the generic type
	 * @param <AttributeValue> the generic type
	 * @return the key value map
	 */
	<Key, AttributeKey, AttributeValue> IKeyValueMap<Key, AttributeKey, AttributeValue> getKeyValueMap();
}
