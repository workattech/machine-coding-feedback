import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Splitwise newGroup = new Splitwise();
        newGroup.addUser("User1", "u1");
        newGroup.addUser("User2", "u2");
        newGroup.addUser("User3", "u3");
        newGroup.addUser("User4", "u4");
        while (true) {
            String currentInput = sc.nextLine();
            if (currentInput.length() == 0) {
                break;
            }
            String[] inputElements = currentInput.split(" ");
            switch (inputElements[0]) {
                case "EXPENSE":
                    String payerId = inputElements[1];
                    Double totalAmount = Double.parseDouble(inputElements[2]);
                    Integer noOfUsers = Integer.parseInt(inputElements[3]);
                    List<String> userIds = new ArrayList<>();
                    for (int i = 4; i < 4 + noOfUsers; i++) {
                        userIds.add(inputElements[i]);
                    }
                    String type = inputElements[4 + noOfUsers];
                    if (inputElements.length == 5 + noOfUsers) {
                        newGroup.addExpense(payerId, totalAmount, type, userIds);
                    } else {
                        List<Double> shares = new ArrayList<>();
                        for (int i = 5 + noOfUsers; i < inputElements.length; i++) {
                            shares.add(Double.parseDouble(inputElements[i]));
                        }
                        newGroup.addExpense(payerId, totalAmount, type, userIds, shares);
                    }
                    break;
                case "SHOW":
                    if (inputElements.length == 1) {
                        newGroup.show();
                    } else {
                        newGroup.show(inputElements[1]);
                    }
                default:
                    break;
            }
        }
        sc.close();
    }
}
