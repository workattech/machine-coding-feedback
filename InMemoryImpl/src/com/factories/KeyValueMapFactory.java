package com.factories;

import com.factories.interfaces.IKeyValueMapFactory;
import com.map.KeyValueMap;
import com.map.interfaces.IKeyValueMap;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating KeyValueMap objects.
 */
public class KeyValueMapFactory implements IKeyValueMapFactory {

	/**
	 * Gets the key value map.
	 *
	 * @param <Key> the generic type
	 * @param <AttributeKey> the generic type
	 * @param <AttributeValue> the generic type
	 * @return the key value map
	 */
	@Override
	public <Key extends Object, AttributeKey extends Object, AttributeValue extends Object> IKeyValueMap<Key, AttributeKey, AttributeValue> getKeyValueMap() {
		return new KeyValueMap<Key, AttributeKey, AttributeValue>(new AttributeKeyValueMapFactory());
	}

}
