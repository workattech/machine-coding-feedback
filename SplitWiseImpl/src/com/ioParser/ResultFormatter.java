package com.ioParser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dataStore.interfaces.IUserDataStore;
import com.ioParser.interfaces.IResultFormatter;
import com.strategies.splitObjects.SplitResult;

public class ResultFormatter implements IResultFormatter{


	@Override
	public List<String> getFormattedResult(SplitResult splitResult, IUserDataStore userDataStore) {
		List<String> result = new ArrayList<String>();
		
		if (splitResult.getOwedBy() !=  null) {
			Iterator<String> it = splitResult.getOwedBy().keySet().iterator();
			
			while (it.hasNext()) {
				String next = it.next();
				
				if (splitResult.getOwedBy().get(next) == null) {
					continue;
				}
				
				Iterator<String> it1 = splitResult.getOwedBy().get(next).keySet().iterator();
				
				while (it1.hasNext()) {
					String next1 = it1.next();
					
					double amount = splitResult.getOwedBy().get(next).get(next1);
					
					StringBuilder sb = new StringBuilder();
					
					sb.append(userDataStore.getUserDetails(next1).getName());
					sb.append(" owes to ");
					
					sb.append(userDataStore.getUserDetails(next).getName());
					sb.append(": " + amount);
					
					result.add(sb.toString());
				}
			}
		}
		
		if (splitResult.getOwedTo() !=  null) {
			Iterator<String> it = splitResult.getOwedTo().keySet().iterator();
			
			while (it.hasNext()) {
				String next = it.next();
				
				if (splitResult.getOwedTo().get(next) == null) {
					continue;
				}
				
				Iterator<String> it1 = splitResult.getOwedTo().get(next).keySet().iterator();
				
				while (it1.hasNext()) {
					String next1 = it1.next();
					
					double amount = splitResult.getOwedTo().get(next).get(next1);
					
					StringBuilder sb = new StringBuilder();
					
					sb.append(userDataStore.getUserDetails(next).getName());
					sb.append(" owes to ");
					
					sb.append(userDataStore.getUserDetails(next1).getName());
					sb.append(": " + amount);
					
					result.add(sb.toString());
				}
			}
		}
		
		if (result.size() == 0) {
			result.add("No Expenses");
		}
		
		return result;
		
	}

}
