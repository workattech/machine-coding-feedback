package service;

import domain.ExpenseType;
import domain.RequestObject;
import domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitWiseService {
    private List<User> initialUserList;
    private Map<String, Map<String, Double>> userToAmountOwedMap;

    public List<User> getInitialUserList() {
        return initialUserList;
    }

    public SplitWiseService(List<User> initialUserList) {
        if (initialUserList == null) {
            return;
        }

        this.initialUserList = initialUserList;
        final Map<String, Map<String, Double>> userToAmountOwedMap = new HashMap<>();
        int n = initialUserList.size();
        for (int i = 0; i < n; ++i) {
            String userId_i = initialUserList.get(i).getUserId();
            final Map<String, Double> transMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    String userId_j = initialUserList.get(j).getUserId();
                    transMap.put(userId_j, 0.0);
                }
            }
            userToAmountOwedMap.put(userId_i, transMap);
        }
        this.userToAmountOwedMap = userToAmountOwedMap;
    }

    public void splitAmount(final RequestObject requestObject) {
        if (requestObject == null
                || requestObject.getTransactionUser() == null
                || requestObject.getTransactionAmount() == null
                || requestObject.getExpenseType() == null
                || requestObject.getUsersInvolved() == null) {
            System.out.println("Invalid request");
            return;
        }

        if (ExpenseType.EQUAL.getExpenseName().equalsIgnoreCase(requestObject.getExpenseType())) {
            splitEqualAmount(requestObject);
        } else if (ExpenseType.EXACT.getExpenseName().equalsIgnoreCase(requestObject.getExpenseType())) {
            splitExactAmount(requestObject);
        } else if (ExpenseType.PERCENT.getExpenseName().equalsIgnoreCase(requestObject.getExpenseType())) {
            splitPercentAmount(requestObject);
        }
    }

    public void show(final String userId) {
        if (!userToAmountOwedMap.containsKey(userId)) {
            System.out.println("Invalid request");
            return;
        }

        userToAmountOwedMap.get(userId).forEach((userId1, amountOwed) -> {
            if (amountOwed < 0.0) {
                System.out.println(String.format("%s owes %s : %f", userId, userId1, -amountOwed));
            } else if (amountOwed > 0.0) {
                System.out.println(String.format("%s owes %s : %f", userId1, userId, amountOwed));
            }
        });
    }

    public void showAll() {
        userToAmountOwedMap.forEach((userId1, amountOwedMap) -> {
            if (userId1 == null || amountOwedMap == null) {
                return;
            }

            amountOwedMap.forEach((userId2, amount) -> {
                if (userId2 == null || amount == null) {
                    return;
                }

                if (amount > 0.0) {
                    System.out.println(String.format("%s owes %s : %f", userId2, userId1, amount));
                }
            });
        });
    }

    private void splitEqualAmount(final RequestObject requestObject) {
        final String transactingUser = requestObject.getTransactionUser();
        int size = requestObject.getUsersInvolved().size();
        for (int i = 0; i < size; ++i) {
            final String beneficiaryUser = requestObject.getUsersInvolved().get(i);
            final Double amountOwedByEachUser = requestObject.getTransactionAmount() / size;
            transactAmount(transactingUser, beneficiaryUser, amountOwedByEachUser);
        }
    }

    private void splitExactAmount(final RequestObject requestObject) {
        final String transactingUser = requestObject.getTransactionUser();
        int size = requestObject.getUsersInvolved().size();
        for (int i = 0; i < size; ++i) {
            final String beneficiaryUser = requestObject.getUsersInvolved().get(i);
            final Double exactAmount = requestObject.getExactAmountList().get(i);
            transactAmount(transactingUser, beneficiaryUser, exactAmount);
        }
    }

    private void splitPercentAmount(final RequestObject requestObject) {
        final String transactingUser = requestObject.getTransactionUser();
        int size = requestObject.getUsersInvolved().size();
        for (int i = 0; i < size; ++i) {
            final String beneficiaryUser = requestObject.getUsersInvolved().get(i);
            final Integer curPercent = requestObject.getPercentAmountList().get(i);
            final Double percentAmount = (curPercent * requestObject.getTransactionAmount()) / 100;
            transactAmount(transactingUser, beneficiaryUser, percentAmount);
        }
    }

    private void transactAmount(final String transactingUser, final String beneficiaryUser, final Double amount) {
        if (transactingUser == null || beneficiaryUser == null) {
            System.out.println("Invalid params to make transaction");
            return;
        }

        if (transactingUser.equalsIgnoreCase(beneficiaryUser)) {
            System.out.println("Holy shit");
            return;
        }

        if (userToAmountOwedMap.containsKey(transactingUser)
                && userToAmountOwedMap.get(transactingUser).containsKey(beneficiaryUser)) {
            final Double currentAmount = userToAmountOwedMap.get(transactingUser).get(beneficiaryUser);
            userToAmountOwedMap.get(transactingUser).put(beneficiaryUser, currentAmount + amount);
        }
        if (userToAmountOwedMap.containsKey(beneficiaryUser)
                && userToAmountOwedMap.get(beneficiaryUser).containsKey(transactingUser)) {
            final Double currentAmount = userToAmountOwedMap.get(beneficiaryUser).get(transactingUser);
            userToAmountOwedMap.get(beneficiaryUser).put(transactingUser, currentAmount - amount);
        }
    }
}
