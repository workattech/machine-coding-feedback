package com.ioParser;

import java.util.ArrayList;
import java.util.List;

import com.commonClasses.Pair;
import com.exceptions.InputFormatIncorrectException;
import com.exceptions.KeyValueStoreException;
import com.ioParser.interfaces.IInputFormatter;

// TODO: Auto-generated Javadoc
/**
 * The Class InputFormatter.
 */
public class InputFormatter implements IInputFormatter<String, String, String> {

	/**
	 * Parses the put operation input.
	 *
	 * @param parts the parts
	 * @return the pair
	 * @throws KeyValueStoreException the key value store exception
	 */
	@Override
	public Pair<String, List<Pair<String, String>>> parsePutOperationInput(String[] parts) throws KeyValueStoreException {
		if (parts.length < 2 || parts.length % 2 != 0) {
			throw new InputFormatIncorrectException();
		}
		
		String key = parts[1];
		
		List<Pair<String, String>> attributeValue = new ArrayList<>();
		
		int i = 2;
		
		while (i < parts.length - 1) {
			String att = parts[i];
			
			String val = parts[i + 1];
			
			attributeValue.add(new Pair<String, String>(att, val));
			
			i += 2;
		}
		
		return new Pair<String, List<Pair<String,String>>>(key, attributeValue);
	}

	/**
	 * Parses the search operation input.
	 *
	 * @param parts the parts
	 * @return the pair
	 * @throws KeyValueStoreException the key value store exception
	 */
	@Override
	public Pair<String, String> parseSearchOperationInput(String[] parts) throws KeyValueStoreException {
		if (parts.length < 3) {
			throw new InputFormatIncorrectException();
		}
		
		return new Pair<String, String>(parts[1], parts[2]);
	}

	/**
	 * Parses the get operation input.
	 *
	 * @param parts the parts
	 * @return the string
	 * @throws KeyValueStoreException the key value store exception
	 */
	@Override
	public String parseGetOperationInput(String[] parts) throws KeyValueStoreException {
		if (parts.length < 2) {
			throw new InputFormatIncorrectException();
		}
		
		return parts[1];
	}

	/**
	 * Parses the delete operation input.
	 *
	 * @param parts the parts
	 * @return the string
	 * @throws KeyValueStoreException the key value store exception
	 */
	@Override
	public String parseDeleteOperationInput(String[] parts) throws KeyValueStoreException {
		return this.parseGetOperationInput(parts);
	}

}
