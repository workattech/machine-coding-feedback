package com.attribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.attribute.interfaces.IValueAttribute;
import com.commonClasses.Pair;

// TODO: Auto-generated Javadoc
/**
 * The Class ValueAttribute.
 *
 * @param <Key> the generic type
 * @param <Value> the generic type
 */
public class ValueAttribute<Key, Value> implements IValueAttribute<Key, Value> {
	
	/** The attribute key value map. */
	HashMap<Key, Value> attributeKeyValueMap;

	/**
	 * Instantiates a new value attribute.
	 */
	public ValueAttribute() {
		this.attributeKeyValueMap = new HashMap<Key, Value>();
	}
	
	/**
	 * Instantiates a new value attribute.
	 *
	 * @param attributekeyValueList the attributekey value list
	 */
	public ValueAttribute(List<Pair<Key, Value>> attributekeyValueList) {
		this();
		Iterator<Pair<Key, Value>> it =  attributekeyValueList.listIterator();
		
		while (it.hasNext()) {
			Pair<Key, Value> next = it.next();
			this.attributeKeyValueMap.put(next.getKey(), next.getValue());
		}
	}
	
	/**
	 * Sets the attribute.
	 *
	 * @param key the key
	 * @param value the value
	 */
	@Override
	public void setAttribute(Key key, Value value) {
		this.attributeKeyValueMap.put(key, value);

	}

	/**
	 * Gets the attribute.
	 *
	 * @param key the key
	 * @return the attribute
	 */
	@Override
	public Value getAttribute(Key key) {
		return this.attributeKeyValueMap.get(key);
	}

	/**
	 * Gets the attribute keys.
	 *
	 * @return the attribute keys
	 */
	@Override
	public List<Key> getAttributeKeys() {
		List<Key> attributeKeys = new ArrayList<Key>();
		
		Iterator<Key> it =  this.attributeKeyValueMap.keySet().iterator();
		
		while (it.hasNext()) {
			attributeKeys.add(it.next());
		}
		
		return attributeKeys;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Iterator<Key> it  = this.attributeKeyValueMap.keySet().iterator();
		
		while (it.hasNext()) {
			Key next = it.next();
			
			Value value = this.attributeKeyValueMap.get(next);
			
			sb.append(next);
			sb.append(": ");
			sb.append(value);
			
			if (it.hasNext()) {
				sb.append(", ");
			}
		}
		
		return sb.toString();
	}
	
	

}
