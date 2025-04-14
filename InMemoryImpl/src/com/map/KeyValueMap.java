package com.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.attribute.ValueAttribute;
import com.attribute.interfaces.IAttributeKeyValueMap;
import com.attribute.interfaces.IValueAttribute;
import com.exceptions.DataFormatIncorrectException;
import com.factories.interfaces.IAttributeKeyValueMapFactory;
import com.map.interfaces.IKeyValueMap;

// TODO: Auto-generated Javadoc
/**
 * The Class KeyValueMap.
 *
 * @param <Key> the generic type
 * @param <AttributeKey> the generic type
 * @param <AttributeValue> the generic type
 */
public class KeyValueMap<Key extends Object, AttributeKey extends Object, AttributeValue extends Object> implements IKeyValueMap<Key, AttributeKey, AttributeValue> {
	
	/** The attribute map. */
	private HashMap<AttributeKey, IAttributeKeyValueMap<Key, AttributeValue>> attributeMap;
	
	/** The key attribute map. */
	private HashMap<Key, List<AttributeKey>> keyAttributeMap;
	
	/** The attribute key value map factory. */
	private IAttributeKeyValueMapFactory attributeKeyValueMapFactory;
	
	

	/**
	 * Instantiates a new key value map.
	 *
	 * @param attributeKeyValueMapFactory the attribute key value map factory
	 */
	public KeyValueMap(IAttributeKeyValueMapFactory attributeKeyValueMapFactory) {
		this.attributeKeyValueMapFactory = attributeKeyValueMapFactory;
		this.attributeMap = new HashMap<AttributeKey, IAttributeKeyValueMap<Key, AttributeValue>>();
		
		this.keyAttributeMap = new HashMap<Key, List<AttributeKey>>();
	}

	/**
	 * Gets the.
	 *
	 * @param key the key
	 * @return the i value attribute
	 */
	@Override
	public IValueAttribute<AttributeKey, AttributeValue> get(Key key) {
		IValueAttribute<AttributeKey, AttributeValue> value = new ValueAttribute<AttributeKey, AttributeValue>();
		
		if (!this.keyAttributeMap.containsKey(key)) {
			return null;
		}
		
		List<AttributeKey> attributeList = this.keyAttributeMap.get(key);
		
		Iterator<AttributeKey> it = attributeList.listIterator();
		
		while (it.hasNext()) {
			AttributeKey next = it.next();
			
			value.setAttribute(next, this.attributeMap.get(next).get(key));
		}
		
		return value;
	}

	/**
	 * Put.
	 *
	 * @param key the key
	 * @param value the value
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	@Override
	public void put(Key key, IValueAttribute<AttributeKey, AttributeValue> value) throws DataFormatIncorrectException {
		if (this.keyAttributeMap.containsKey(key)) {
			this.deleteKey(key);
		}
		
		List<AttributeKey> attributeList = new ArrayList<AttributeKey>();
		
		Iterator<AttributeKey> it = value.getAttributeKeys().listIterator();
		
		while (it.hasNext()) {
			AttributeKey attkey = it.next();
			
			AttributeValue attValue = value.getAttribute(attkey);
			
			if (!attributeMap.containsKey(attkey)) {
				this.attributeMap.put(attkey, attributeKeyValueMapFactory.createAttributeKeyValueMap(attValue));
			}
			
			this.attributeMap.get(attkey).put(key, attValue);
			
			attributeList.add(attkey);
		}
		
		this.keyAttributeMap.put(key, attributeList);
		
	}

	/**
	 * Gets the key containing attribute key value pair.
	 *
	 * @param attribute the attribute
	 * @param value the value
	 * @return the key containing attribute key value pair
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	@Override
	public List<Key> getKeyContainingAttributeKeyValuePair(AttributeKey attribute, AttributeValue value) throws DataFormatIncorrectException {
		
		if (!this.attributeMap.containsKey(attribute)) {
			return new ArrayList<Key>();
		}
		return this.attributeMap.get(attribute).getkeysWithValues(value);
	}

	/**
	 * Gets the keys.
	 *
	 * @return the keys
	 */
	@Override
	public List<Key> getKeys() {
		List<Key> keys = new ArrayList<Key>();
		
		Iterator<Key> it = this.keyAttributeMap.keySet().iterator();
		
		while (it.hasNext()) {
			keys.add(it.next());
		}
		
		return keys;
	}

	/**
	 * Delete key.
	 *
	 * @param key the key
	 */
	@Override
	public void deleteKey(Key key) {
		if (!this.keyAttributeMap.containsKey(key)) {
			return;
		}
		
		Iterator<AttributeKey> it  = this.keyAttributeMap.get(key).listIterator();
		
		while (it.hasNext()) {
			AttributeKey attribute = it.next();
			
			
			this.attributeMap.get(attribute).deleteKey(key);
			
		}
		
		this.keyAttributeMap.remove(key);
		
		return;
	}

}
