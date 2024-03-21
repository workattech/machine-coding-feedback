import java.util.*;
import java.util.Map.Entry;

public class Splitwise {
    private Map<String, User> users = new HashMap<>();

    public void addUser(String name, String id) {
        users.put(id, new User(name, id));
    }

    private boolean checkBalances() {
        for (Entry<String, User> curUser : users.entrySet()) {
            if (!curUser.getValue().checkBalances()) {
                return false;
            }
        }
        return true;
    }

    public void show() {
        if (checkBalances()) {
            System.out.println("No balances");
            return;
        }
        for (Entry<String, User> user : users.entrySet()) {
            user.getValue().showLenders();
        }
    }

    public void show(String userId) {
        if (users.containsKey(userId)) {
            if (users.get(userId).checkBalances()) {
                System.out.println("No balances");
                return;
            }
            users.get(userId).showAll();
        } else {
            System.out.println("Invalid Key!");
        }
    }

    public void addExpense(String payerId, Double totalAmount, String type, List<String> borrowerList) {
        List<User> takers = new ArrayList<>();
        for (String userId : borrowerList) {
            takers.add(users.get(userId));
        }
        Expense exp = new Expense(users.get(payerId), type, totalAmount, takers);
        exp.splitAmount();
    }

    public void addExpense(String payerId, Double totalAmount, String type, List<String> borrowerList,
            List<Double> shares) {
        List<User> takers = new ArrayList<>();
        for (String userId : borrowerList) {
            takers.add(users.get(userId));
        }
        Expense exp = new Expense(users.get(payerId), type, totalAmount, takers, shares);
        exp.splitAmount();
    }

}
