package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.keyvalueStore.KeyValueStoreInterface;
import com.keyvalueStore.interfaces.IKeyValueStoreInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class InterfaceMain.
 */
public class InterfaceMain {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		IKeyValueStoreInterface keyValueStoreInterface = new KeyValueStoreInterface();
		
		Scanner sc = new Scanner(System.in);
		
		List<String> input = new ArrayList<String>();
		
		
		while (true) {
			String next = sc.nextLine();
			
			if (next.equals("EXIT")) {
				break;
			}

			input.add(next);
		}
		
		List<String> result = keyValueStoreInterface.returnResult(input);
		
//		Stream.of(result).forEach(s -> {
//			System.out.println(s);
//		});
//		
//		System.out.println(result);
		
		int i = 0;
		
		while (i < result.size()) {
			if (result.get(i) != null && !result.get(i).equals("")) {
				System.out.println(result.get(i));
			}
			
			i++;
		}
		
		sc.close();
	}

}
