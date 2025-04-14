package com.attribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.attribute.interfaces.IAttributeKeyValueMap;
import com.exceptions.DataFormatIncorrectException;

// TODO: Auto-generated Javadoc
/**
 * The Class AttributeKeyValueMap.
 *
 * @param <T> the generic type
 * @param <Key> the generic type
 * @param <Value> the generic type
 */
public abstract class AttributeKeyValueMap<T extends Object, Key extends Object, Value extends Object> implements IAttributeKeyValueMap<Key, Value>
{
	
	/** The key value map. */
	private HashMap<Key, T> keyValueMap;
	
	/** The value key map. */
	private HashMap<T, HashSet<Key>> valueKeyMap;
	
	/** The t value map. */
	private HashMap<T, Value> tValueMap;
	
	

	/**
	 * Instantiates a new attribute key value map.
	 */
	public AttributeKeyValueMap() {
		this.keyValueMap = new HashMap<>();
		this.valueKeyMap = new HashMap<T, HashSet<Key>>();
		this.tValueMap = new HashMap<T, Value>();
	}
	
	/**
	 * Gets the value as T.
	 *
	 * @param value the value
	 * @return the value as T
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	protected abstract T getValueAsT(Value value) throws DataFormatIncorrectException;
	
	/**
	 * Checks if is valid type.
	 *
	 * @param value the value
	 * @return true, if is valid type
	 */
	@Override
	public abstract boolean isValidType(Value value);

	/**
	 * Gets the.
	 *
	 * @param key the key
	 * @return the value
	 */
	@Override
	public Value get(Key key) {
		if (!keyValueMap.containsKey(key)) {
			
		}
		return this.getValue(this.keyValueMap.get(key));
	}

	/**
	 * Put.
	 *
	 * @param key the key
	 * @param value the value
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	@Override
	public void put(Key key, Value value) throws DataFormatIncorrectException {
		if (!isValidType(value)) {
			throw new DataFormatIncorrectException();
		}
		
		if (this.keyValueMap.containsKey(key)) {
			this.valueKeyMap.remove(this.keyValueMap.get(key));
		}
		this.keyValueMap.put(key, this.getValueAsT(value));	
		
		if (!this.valueKeyMap.containsKey(this.getValueAsT(value))) {
			this.valueKeyMap.put(this.getValueAsT(value), new HashSet<Key>());
		}
		
		this.valueKeyMap.get(this.getValueAsT(value)).add(key);
		this.tValueMap.put(this.getValueAsT(value), value);
	}

	/**
	 * Contains key.
	 *
	 * @param key the key
	 * @return true, if successful
	 */
	@Override
	public boolean containsKey(Key key) {
		if (this.keyValueMap.containsKey(key)) {
			return true;
		}
		
		return false;
	}

	

	/**
	 * Gets the keys with values.
	 *
	 * @param value the value
	 * @return the keys with values
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	@Override
	public List<Key> getkeysWithValues(Value value) throws DataFormatIncorrectException {
		
		if (!this.isValidType(value)) {
			return new ArrayList<Key>();
		}
		
		List<Key> result  = new ArrayList<Key>();
		
		if (!this.valueKeyMap.containsKey(this.getValueAsT(value))) {
			return new ArrayList<Key>();
		}
		
		Iterator<Key> it = this.valueKeyMap.get(getValueAsT(value)).iterator();
		
		while (it.hasNext()) {
			result.add(it.next());
		}
		
		return result;
	}
	
	
	
	/**
	 * Delete key.
	 *
	 * @param key the key
	 */
	@Override
	public void deleteKey(Key key) {
		if (!this.keyValueMap.containsKey(key)) {
			return;
		}
		
	}
	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "AttributeKeyValueMap [keyValueMap=" + keyValueMap + ", valueKeyMap=" + valueKeyMap + "]";
	}

	/**
	 * Gets the value.
	 *
	 * @param obj the obj
	 * @return the value
	 */
	protected Value getValue(T obj) {
		return this.tValueMap.get(obj);
	}

}
