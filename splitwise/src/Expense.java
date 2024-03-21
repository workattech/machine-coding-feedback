import java.util.*;
import java.util.Map.Entry;

enum Type {
    EQUAL,
    EXACT,
    PERCENT
}

public class Expense {
    private User lender;
    private Type type;
    private double totalAmount;
    private Map<User, Double> share = new HashMap<>();

    public Expense(User lender, String type, Double totalAmount, List<User> borrowers) {

        this.lender = lender;
        this.type = Type.valueOf(type);
        this.totalAmount = totalAmount;
        for (User borrower : borrowers) {
            Double equalShare = (Double) totalAmount / borrowers.size();
            share.put(borrower, equalShare);
        }
    }

    public Expense(User lender, String type, Double totalAmount, List<User> borrowers, List<Double> shareAmount) {
        if (verifyShares(Type.valueOf(type), totalAmount, shareAmount)) {
            this.lender = lender;
            this.type = Type.valueOf(type);
            this.totalAmount = totalAmount;
            for (int i = 0; i < borrowers.size(); i++) {
                User borrwer = borrowers.get(i);
                Double lenderShare = shareAmount.get(i);
                Double lenderAmount = (this.type.equals(Type.EXACT)) ? lenderShare
                        : ((lenderShare / 100.00) * totalAmount);
                share.put(borrwer, lenderAmount);
            }
        } else {
            System.out.println("Un Equal Distribution");
        }
    }

    private boolean verifyShares(Type type, Double totalAmount, List<Double> shareAmount) {
        switch (type) {
            case PERCENT:
                Double netPercentage = 0.00;
                for (Double percentShare : shareAmount) {
                    netPercentage += percentShare;
                }
                return Double.compare(netPercentage, 100.00) == 0;
            case EXACT:
                Double netAmount = 0.00;
                for (Double amountShare : shareAmount) {
                    netAmount += amountShare;
                }
                return Double.compare(netAmount, totalAmount) == 0;
            default:
                return false;
        }
    }

    public void splitAmount() {
        for (Entry<User, Double> exp : share.entrySet()) {
            lender.lendMoney(exp.getKey(), exp.getValue());
            exp.getKey().borrowMoney(lender, exp.getValue());
        }
    }

}
