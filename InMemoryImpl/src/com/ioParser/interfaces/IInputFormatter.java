package com.ioParser.interfaces;

import java.util.List;

import com.commonClasses.Pair;
import com.exceptions.KeyValueStoreException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IInputFormatter.
 *
 * @param <Key> the generic type
 * @param <AttributeKey> the generic type
 * @param <AttributeValue> the generic type
 */
public interface IInputFormatter<Key, AttributeKey, AttributeValue> {
	
	/**
	 * Parses the put operation input.
	 *
	 * @param input the input
	 * @return the pair
	 * @throws KeyValueStoreException the key value store exception
	 */
	Pair<Key, List<Pair<AttributeKey, AttributeValue>>> parsePutOperationInput(String[] input) throws KeyValueStoreException;
	
	/**
	 * Parses the search operation input.
	 *
	 * @param input the input
	 * @return the pair
	 * @throws KeyValueStoreException the key value store exception
	 */
	Pair<AttributeKey, AttributeValue> parseSearchOperationInput(String[] input) throws KeyValueStoreException;
	
	/**
	 * Parses the get operation input.
	 *
	 * @param input the input
	 * @return the key
	 * @throws KeyValueStoreException the key value store exception
	 */
	Key parseGetOperationInput(String[] input) throws KeyValueStoreException;
	
	/**
	 * Parses the delete operation input.
	 *
	 * @param input the input
	 * @return the key
	 * @throws KeyValueStoreException the key value store exception
	 */
	Key parseDeleteOperationInput(String[] input) throws KeyValueStoreException;
}
