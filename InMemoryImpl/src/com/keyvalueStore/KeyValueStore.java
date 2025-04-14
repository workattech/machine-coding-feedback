package com.keyvalueStore;

import java.util.List;

import com.attribute.ValueAttribute;
import com.attribute.interfaces.IValueAttribute;
import com.commonClasses.Pair;
import com.exceptions.DataFormatIncorrectException;
import com.factories.interfaces.IKeyValueMapFactory;
import com.keyvalueStore.interfaces.IKeyValueStore;
import com.map.interfaces.IKeyValueMap;

// TODO: Auto-generated Javadoc
/**
 * The Class KeyValueStore.
 *
 * @param <Key> the generic type
 * @param <AttributeKey> the generic type
 * @param <AttributeValue> the generic type
 */
public class KeyValueStore<Key extends Object, AttributeKey extends Object, AttributeValue extends Object> implements IKeyValueStore<Key, AttributeKey, AttributeValue> {
	
	/** The key value map. */
	private IKeyValueMap<Key, AttributeKey, AttributeValue> keyValueMap;
	
	/** The key value map factory. */
	private IKeyValueMapFactory keyValueMapFactory;

	/**
	 * Instantiates a new key value store.
	 *
	 * @param keyValueMapFactory the key value map factory
	 */
	public KeyValueStore(IKeyValueMapFactory keyValueMapFactory) {
		this.keyValueMapFactory = keyValueMapFactory;
		
		this.keyValueMap = this.keyValueMapFactory.<Key, AttributeKey, AttributeValue>getKeyValueMap();
	}

	/**
	 * Gets the.
	 *
	 * @param key the key
	 * @return the i value attribute
	 */
	@Override
	public IValueAttribute<AttributeKey, AttributeValue> get(Key key) {
		return this.keyValueMap.get(key);
	}

	/**
	 * Search.
	 *
	 * @param attributeKey the attribute key
	 * @param attributeValue the attribute value
	 * @return the list
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	@Override
	public List<Key> search(AttributeKey attributeKey, AttributeValue attributeValue) throws DataFormatIncorrectException {
		// TODO Auto-generated method stub
		return this.keyValueMap.getKeyContainingAttributeKeyValuePair(attributeKey, attributeValue);
	}

	/**
	 * Put.
	 *
	 * @param key the key
	 * @param listOfAttributesPair the list of attributes pair
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	@Override
	public void put(Key key, List<Pair<AttributeKey, AttributeValue>> listOfAttributesPair) throws DataFormatIncorrectException {
		this.keyValueMap.put(key, new ValueAttribute<AttributeKey, AttributeValue>(listOfAttributesPair));
	}

	/**
	 * Delete.
	 *
	 * @param key the key
	 */
	@Override
	public void delete(Key key) {
		this.keyValueMap.deleteKey(key);

	}

	/**
	 * Keys.
	 *
	 * @return the list
	 */
	@Override
	public List<Key> keys() {
		return this.keyValueMap.getKeys();
	}


}
