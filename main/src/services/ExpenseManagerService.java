package services;

import model.Expense;
import model.Split;
import model.User;

import java.util.Map;

public class ExpenseManagerService {
    private UserService userService;

    public ExpenseManagerService(UserService userService) {
        this.userService = userService;
    }

    public void addExpense(Expense expense) {
        Split split = expense.getSplit();
        if(split.validate()) {
            split.calculateEachShare();
        }


        User userWhoPaid = expense.getUser();
        Map<User,Double> usersSplitList = split.getPaidForUsers();

        for(Map.Entry<User,Double> entry: usersSplitList.entrySet()) {
            User user = entry.getKey();
            Double amount = entry.getValue();
            user.updatePassBook(userWhoPaid,amount);
            userWhoPaid.updatePassBook(user,amount*(-1.0));
        }

    }

}
