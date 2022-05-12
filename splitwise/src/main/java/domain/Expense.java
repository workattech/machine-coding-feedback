package splitwise.src.main.java.domain;

import domain.ExpenseType;
import domain.User;

import java.util.List;

public class Expense {
    private ExpenseType expenseType;
    private Double transactionAmount;
    private User transactingUser;
    private List<User> beneficiaryUserList;
}
