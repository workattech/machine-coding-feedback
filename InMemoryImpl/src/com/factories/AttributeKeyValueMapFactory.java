package com.factories;

import com.attribute.interfaces.IAttributeKeyValueMap;
import com.attribute.typeClasses.BooleanAttributeKeyValueMap;
import com.attribute.typeClasses.DoubleAttributeKeyValueMap;
import com.attribute.typeClasses.IntegerAttributeKeyValueMap;
import com.attribute.typeClasses.StringAttributekeyValueMap;
import com.factories.interfaces.IAttributeKeyValueMapFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating AttributeKeyValueMap objects.
 */
public class AttributeKeyValueMapFactory implements IAttributeKeyValueMapFactory {

	/**
	 * Creates a new AttributeKeyValueMap object.
	 *
	 * @param <Key> the generic type
	 * @param <Value> the generic type
	 * @param value the value
	 * @return the i attribute key value map< key, value>
	 */
	@Override
	public <Key, Value> IAttributeKeyValueMap<Key, Value> createAttributeKeyValueMap(Value value) {
		try {
			Integer.parseInt(value.toString());
			
			return new IntegerAttributeKeyValueMap<Key, Value>();
		} catch (Exception e) {
			// do nothing
		}
		
		try {
			Double.parseDouble(value.toString());
			
			return new DoubleAttributeKeyValueMap<Key, Value>();
		} catch (Exception e) {
			// Do nothing
		}
		
		try {
			Boolean.parseBoolean(value.toString());
			
			return new BooleanAttributeKeyValueMap<Key, Value>();
		} catch (Exception e) {
			return new StringAttributekeyValueMap<Key, Value>();
		}
	}

}
