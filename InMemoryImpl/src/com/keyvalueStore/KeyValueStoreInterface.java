package com.keyvalueStore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.commonClasses.Pair;
import com.enums.Operations;
import com.exceptions.InputFormatIncorrectException;
import com.exceptions.KeyValueStoreException;
import com.factories.KeyValueMapFactory;
import com.ioParser.InputFormatter;
import com.ioParser.ResultFormatter;
import com.ioParser.interfaces.IInputFormatter;
import com.ioParser.interfaces.IResultFormatter;
import com.keyvalueStore.interfaces.IKeyValueStore;
import com.keyvalueStore.interfaces.IKeyValueStoreInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class KeyValueStoreInterface.
 */
public class KeyValueStoreInterface implements IKeyValueStoreInterface {

	/** The key value store. */
	private IKeyValueStore<String, String, String> keyValueStore;
	
	/** The result formatter. */
	private IResultFormatter<String, String, String> resultFormatter;
	
	/** The input formatter. */
	private IInputFormatter<String, String, String> inputFormatter;
	
	
	/**
	 * Instantiates a new key value store interface.
	 */
	public KeyValueStoreInterface() {
		this.keyValueStore = new KeyValueStore<String, String, String>(new KeyValueMapFactory());
		this.inputFormatter = new InputFormatter();
		
		this.resultFormatter = new ResultFormatter();
	}


	/**
	 * Return result.
	 *
	 * @param input the input
	 * @return the list
	 */
	@Override
	public List<String> returnResult(List<String> input) {
		List<String> result = new ArrayList<String>();
		
		Iterator<String> it = input.listIterator();
		
		while (it.hasNext()) {
			try {
				result.add(this.processInput(it.next()));
			} catch (KeyValueStoreException e) {
				result.add(e.getMessage());
			}
		}
		
		return result;
	}
	
	/**
	 * Process input.
	 *
	 * @param inputString the input string
	 * @return the string
	 * @throws KeyValueStoreException the key value store exception
	 */
	private String processInput(String inputString) throws KeyValueStoreException {
		String[] parts = inputString.split(" ");
		
		if (parts.length == 0) {
			throw new InputFormatIncorrectException();
		}
		
		try {
			Operations operation = Operations.valueOf(parts[0].toUpperCase());
			
			switch (operation) {
			case PUT:
				return this.parseAndExecutePUTOperation(parts);
			case DELETE:
				return this.parseAndExecuteDELETEOperation(parts);
			case GET:
				
				return this.parseAndExecuteGETOperation(parts);
			case KEYS:
				return this.parseAndExecuteKEYSOperation();
			case SEARCH:
				return this.parseAndExecuteSEARCHOperation(parts);
			default:
				return "";
				
			}
		} catch(KeyValueStoreException dataException) {
			throw dataException;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InputFormatIncorrectException();
		}
		
		
	}


	/**
	 * Parses the and execute KEYS operation.
	 *
	 * @return the string
	 * @throws KeyValueStoreException the key value store exception
	 */
	private String parseAndExecuteKEYSOperation() throws KeyValueStoreException {
		
		return this.resultFormatter.getResultString(this.keyValueStore.keys());
	}


	/**
	 * Parses the and execute GET operation.
	 *
	 * @param parts the parts
	 * @return the string
	 * @throws KeyValueStoreException the key value store exception
	 */
	private String parseAndExecuteGETOperation(String[] parts) throws KeyValueStoreException {
		
		String input = this.inputFormatter.parseGetOperationInput(parts);
		
		
		String result = this.resultFormatter.getResultString(this.keyValueStore.get(this.inputFormatter.parseGetOperationInput(parts)));
		
		if (result.equals("")) {
			return "No entry found for " +  input;
		}
		
		return result;
	}


	/**
	 * Parses the and execute DELETE operation.
	 *
	 * @param parts the parts
	 * @return the string
	 * @throws KeyValueStoreException the key value store exception
	 */
	private String parseAndExecuteDELETEOperation(String[] parts) throws KeyValueStoreException {
		
		
		this.keyValueStore.delete(this.inputFormatter.parseDeleteOperationInput(parts));
		
		return null;
	}


	/**
	 * Parses the and execute PUT operation.
	 *
	 * @param parts the parts
	 * @return the string
	 * @throws KeyValueStoreException the key value store exception
	 */
	private String parseAndExecutePUTOperation(String[] parts) throws KeyValueStoreException {
		Pair<String, List<Pair<String, String>>> input = this.inputFormatter.parsePutOperationInput(parts);
		
		this.keyValueStore.put(input.getKey(), input.getValue());
		
		return "";
	}
	
	/**
	 * Parses the and execute SEARCH operation.
	 *
	 * @param parts the parts
	 * @return the string
	 * @throws KeyValueStoreException the key value store exception
	 */
	private String parseAndExecuteSEARCHOperation(String[] parts) throws KeyValueStoreException {
		Pair<String, String> input = this.inputFormatter.parseSearchOperationInput(parts);
		List<String> result = this.keyValueStore.search(input.getKey(), input.getValue());
		
		return this.resultFormatter.getResultString(result);
	}

}
