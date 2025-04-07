package com.main;

import java.util.Scanner;

import com.application.ApplicationInterface;
import com.factory.DataStoreFactory;
import com.factory.StrategyListFactory;
import com.interfaces.IApplicationInterface;
import com.ioParser.InputReader;
import com.ioParser.ResultFormatter;
import com.user.UserDetails;

public class CommandLineMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		IApplicationInterface applicationInterface = new ApplicationInterface(new DataStoreFactory(), new StrategyListFactory(), new ResultFormatter(), new InputReader());
		applicationInterface.addNewUser(new UserDetails("u1", "user 1", "user1@gmail.com", "11111"));
		applicationInterface.addNewUser(new UserDetails("u2", "user 2", "user2@gmail.com", "22222"));
		applicationInterface.addNewUser(new UserDetails("u3", "user 3", "user3@gmail.com", "33333"));
		applicationInterface.addNewUser(new UserDetails("u4", "user 4", "user4@gmail.com", "44444"));
		
		applicationInterface.instantiateApplication();
		while (true) {
			String next = sc.nextLine();
			if (next.equals("")) {
				break;
			}
			applicationInterface.runInputString(next).stream().forEach(s -> {
				System.out.println(s);
			});
		}
		
	}

}
