package com.main;

import java.util.Arrays;

import com.commonClasses.Pair;
import com.exceptions.DataFormatIncorrectException;
import com.factories.AttributeKeyValueMapFactory;
import com.factories.KeyValueMapFactory;
import com.keyvalueStore.KeyValueStore;
import com.keyvalueStore.interfaces.IKeyValueStore;
import com.map.KeyValueMap;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws DataFormatIncorrectException the data format incorrect exception
	 */
	public static void main(String[] args) throws DataFormatIncorrectException {
		IKeyValueStore<String, String, String> keyValueStore = new KeyValueStore<>(new KeyValueMapFactory());
		
		keyValueStore.put("test1", Arrays.asList(new Pair<String, String>("att1", "123.0")));
		
		System.out.println(keyValueStore.get("test1"));
		
		System.out.println(keyValueStore.search("att1", "1231"));
		
		System.out.println(keyValueStore.keys());
		
		keyValueStore.delete("test1");
		
		System.out.println(keyValueStore.get("test1"));
		
		keyValueStore.put("test1", Arrays.asList(new Pair<String, String>("att1", "123")));
		
		keyValueStore.put("test2", Arrays.asList(new Pair<String, String>("att1", "1232")));
		
		System.out.println(keyValueStore.get("test1"));	
		
		System.out.println(keyValueStore.search("att1", "1231"));
		
		System.out.println(keyValueStore.keys());
	}

}
