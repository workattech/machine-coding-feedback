import controller.SplitWiseController;
import domain.RequestObject;
import domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for split wise application.
 */
public class SplitWiseApplication {
    public static void main(String[] args) {
        System.out.println("SplitWise program started");

        final List<User> initialUserList = new ArrayList<>();
        initialUserList.add(new User("u1", "u1", "user1@gmail.com", 12));
        initialUserList.add(new User("u2", "u2", "user2@gmail.com", 34));
        initialUserList.add(new User("u3", "u3", "user3@gmail.com", 56));
        initialUserList.add(new User("u4", "u4", "user4@gmail.com", 78));

        final SplitWiseController splitWiseController = new SplitWiseController(initialUserList);

        for (int j = 0; j < 4; ++j) {
            final Scanner scanner = new Scanner(System.in);
            final String requestType = scanner.next();
            if ("SHOW".equalsIgnoreCase(requestType)) {
                splitWiseController.showAll();
            } else if ("EXPENSE".equalsIgnoreCase(requestType)) {
                final RequestObject requestObject = new RequestObject();
                requestObject.setTransactionUser(scanner.next());
                requestObject.setTransactionAmount(scanner.nextDouble());
                final Integer cnt = scanner.nextInt();
                final List<String> userList = new ArrayList<>();
                for (int i = 0; i < cnt; ++i) {
                    final String userId = scanner.next();
                    userList.add(userId);
                }
                requestObject.setUsersInvolved(userList);
                requestObject.setExpenseType(scanner.next());

                if (requestObject.getExpenseType().equalsIgnoreCase("EXACT")) {
                    final List<Double> exactAmountList = new ArrayList<>();
                    for (int i = 0; i < cnt; ++i) {
                        exactAmountList.add(scanner.nextDouble());
                    }
                    requestObject.setExactAmountList(exactAmountList);
                } else if (requestObject.getExpenseType().equalsIgnoreCase("PERCENT")) {
                    final List<Integer> percentList = new ArrayList<>();
                    for (int i = 0; i < cnt; ++i) {
                        percentList.add(scanner.nextInt());
                    }
                    requestObject.setPercentAmountList(percentList);
                }

                splitWiseController.splitAmount(requestObject);
            }
        }

        System.out.println("SplitWise program ended");
    }
}
