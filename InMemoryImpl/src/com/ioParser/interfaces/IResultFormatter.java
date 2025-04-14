package com.ioParser.interfaces;

import java.util.List;

import com.attribute.interfaces.IValueAttribute;

// TODO: Auto-generated Javadoc
/**
 * The Interface IResultFormatter.
 *
 * @param <Key> the generic type
 * @param <Attributekey> the generic type
 * @param <AttributeValue> the generic type
 */
public interface IResultFormatter<Key, Attributekey, AttributeValue> {
	
	/**
	 * Gets the result string.
	 *
	 * @param valueAttribute the value attribute
	 * @return the result string
	 */
	String getResultString(IValueAttribute<Attributekey, AttributeValue> valueAttribute);
	
	/**
	 * Gets the result string.
	 *
	 * @param keys the keys
	 * @return the result string
	 */
	String getResultString(List<Key> keys);
}
