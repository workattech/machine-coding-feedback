package src.splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserBalances implements Balances {
    private User user;

    public UserBalances(String userId) throws IllegalArgumentException {
        user = appConfig.getUserFromId(userId);
    }

    @Override
    public List<String> getBalances() throws IllegalArgumentException {
        Map<String, Double> userBalances = user.getBalances();
        List<String> balances = new ArrayList<String>(userBalances.size());
        for (String userFriendId : userBalances.keySet()) {
            User userFriend = appConfig.getUserFromId(userFriendId);
            if (userBalances.get(userFriendId) > 0.00f) {
                balances.add(String.format("%s owes %s: %.2f", userFriend.getName(), user.getName(),
                        userBalances.get(userFriendId)));
            } else if (userBalances.get(userFriendId) < 0.00f) {
                balances.add(String.format("%s owes %s: %.2f", user.getName(), userFriend.getName(),
                        (-1.00f) * userBalances.get(userFriendId)));
            }
        }
        return balances;
    }

}
