package co.app.splitwise.consoleDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import co.app.splitwise.controllers.ExpenseController;
import co.app.splitwise.controllers.UserController;
import co.app.splitwise.exceptions.InvalidExpenseException;
import co.app.splitwise.exceptions.InvalidInputException;
import co.app.splitwise.exceptions.UserNotFound;
import co.app.splitwise.models.EqualSplitExpense;
import co.app.splitwise.models.ExactSplitExpense;
import co.app.splitwise.models.ExpenseType;
import co.app.splitwise.models.PercentSplitExpens;
import co.app.splitwise.models.User;

@Component
public class AppDriver {
	ExpenseController expenseController;
	UserController userController;
	AtomicLong expenseId;
	public AppDriver(ExpenseController expenseController, UserController userController) {
		this.expenseController = expenseController;
		this.userController = userController;
		expenseId = new AtomicLong();
	}
	
	public void init() throws InvalidInputException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.println("Enter Command");
				String input[];
				input = reader.readLine().split(" ");
				if(input[0].equals("SHOW")) {
					if(input.length == 1) {
						expenseController.show();
						continue;
					}
					String userId = input[1];
					expenseController.show(userId);
					continue;
				}
				else if(input[0].equals("EXPENSE")) {
					User lendBy = new User();
					lendBy.setUserId(input[1]);
					Double amountLended = Double.valueOf(input[2]);
					Integer countUsersOwes = Integer.valueOf(input[3]);
					List<User> owedBy = new ArrayList<User>();
					for(int i=0;i<countUsersOwes;i++) {
						User user = new User();
						user.setUserId(input[4+i]);
						owedBy.add(user);
					}
					String expenseT = input[4+countUsersOwes];
					switch (expenseT) {
					case "EQUAL":
						ExpenseType expenseType = ExpenseType.EQUAL;
						EqualSplitExpense equalSplitExpense = new EqualSplitExpense(expenseId.incrementAndGet(),lendBy,amountLended,expenseType,owedBy);
						expenseController.addExpense(equalSplitExpense);
						break;
					case "EXACT":
						expenseType = ExpenseType.EXACT;
						List<Double> exactSplit = new ArrayList<>();
						for(int i=1;i<=countUsersOwes;i++) {
							exactSplit.add(Double.valueOf(input[4+countUsersOwes+i]));
						}
						ExactSplitExpense exactSplitExpense = new ExactSplitExpense(expenseId.incrementAndGet(),lendBy,amountLended,expenseType,owedBy,exactSplit);
						expenseController.addExpense(exactSplitExpense);
						break;
					case "PERCENT":
						expenseType = ExpenseType.PERCENT;
						List<Double> percentSplit = new ArrayList<>();
						for(int i=1;i<=countUsersOwes;i++) {
							percentSplit.add(Double.valueOf(input[4+countUsersOwes+i]));
						}
						PercentSplitExpens percentSplitExpense = new PercentSplitExpens(expenseId.incrementAndGet(),lendBy,amountLended,expenseType,owedBy,percentSplit);
						expenseController.addExpense(percentSplitExpense);
						break;
					default:
						System.out.println("Invalid Expese Type");
						break;
					}
				}else {
					new InvalidInputException("Invalid Input!!");
				}
			} catch (IOException | UserNotFound e ) {
				System.out.println( e.getMessage());
			} catch (InvalidExpenseException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
