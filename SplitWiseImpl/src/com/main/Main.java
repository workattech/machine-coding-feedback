package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.application.ApplicationInterface;
import com.factory.DataStoreFactory;
import com.factory.StrategyListFactory;
import com.interfaces.IApplicationInterface;
import com.ioParser.InputReader;
import com.ioParser.ResultFormatter;
import com.user.UserDetails;

public class Main {

	public static void main(String[] args) {
		IApplicationInterface applicationInterface = new ApplicationInterface(new DataStoreFactory(), new StrategyListFactory(), new ResultFormatter(), new InputReader());
		
		
		applicationInterface.addNewUser(new UserDetails("u1", "user 1", "user1@gmail.com", "11111"));
		applicationInterface.addNewUser(new UserDetails("u2", "user 2", "user2@gmail.com", "22222"));
		applicationInterface.addNewUser(new UserDetails("u3", "user 3", "user3@gmail.com", "33333"));
		applicationInterface.addNewUser(new UserDetails("u4", "user 4", "user4@gmail.com", "44444"));
		
		applicationInterface.instantiateApplication();
		List<String> result = new ArrayList<String>();
		Iterator<String> it = Arrays.asList("SHOW", "SHOW u1", "EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL", "SHOW u4", "SHOW u1", "EXPENSE u1 1250 2 u2 u3 EXACT 370 880", "SHOW", "EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20", "SHOW u1", "SHOW").listIterator();
		
		while (it.hasNext()) {
			String next = it.next();
			
//			System.out.println(next);
			
			result.addAll(applicationInterface.runInputString(next));
			
			// System.out.println( applicationInterface.runInputString(next));
			
//			 result.add("-----------------");
			
		}
		
		// System.out.println(result);
		
		result.stream().forEach(s -> {
			System.out.println(s);
		});
		
	}

}
