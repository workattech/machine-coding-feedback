package splitwise;


import java.util.ArrayList;
import java.util.List;

public class Expense {

    String expenseId;

    String description;

    double expenseAmount;

    User paidByUser;

    ExpenseSplitType splitType;

    List<SplitDetails> splitDetails = new ArrayList<>();

    public Expense(String expenseId, String description, double expenseAmount, User paidByUser, ExpenseSplitType splitType, List<SplitDetails> splitDetails) {
        this.expenseId = expenseId;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.paidByUser = paidByUser;
        this.splitType = splitType;
        this.splitDetails.addAll(splitDetails);
    }
}

