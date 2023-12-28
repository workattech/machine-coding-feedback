package src.splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllUserBalances implements Balances {
    private Map<String, User> registeredUsers = appConfig.getRegisteredUserIdToUser();

    @Override
    public List<String> getBalances() throws IllegalArgumentException {
        List<String> balances = new ArrayList<String>();
        Map<String, Boolean> isUserVisited = new HashMap<String, Boolean>();
        for (String userId : registeredUsers.keySet()) {
            isUserVisited.put(userId, true);
            User user = registeredUsers.get(userId);
            Map<String, Double> userBalances = user.getBalances();
            for (String userFriendId : userBalances.keySet()) {
                User userFriend = appConfig.getUserFromId(userFriendId);
                if (isUserVisited.containsKey(userFriend.getUserId()) && isUserVisited.get(userFriend.getUserId()))
                    continue;
                if (userBalances.get(userFriendId) > 0.00f) {
                    balances.add(String.format("%s owes %s: %.2f", userFriend.getName(), user.getName(),
                            userBalances.get(userFriendId)));
                } else if (userBalances.get(userFriendId) < 0.00f) {
                    balances.add(String.format("%s owes %s: %.2f", user.getName(), userFriend.getName(),
                            (-1.00f) * userBalances.get(userFriendId)));
                }
            }
        }
        return balances;
    }
}
