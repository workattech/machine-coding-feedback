import java.util.HashMap;
import java.util.Map;

import models.User;
import models.object.Dice;
import models.object.ObjectType;

public class SnakeLadderManager {

    private Map<Integer, Integer> objectsPosMap;

    private Map<User, Integer> userPosMap;

    SnakeLadderManager() {
        objectsPosMap = new HashMap<>();
        userPosMap = new HashMap<>();
    }

    public void addSnake(Integer head, Integer tail) {
        SnakeLadderService.addObject(ObjectType.SNAKE, head, tail);
        objectsPosMap.put(head, tail);
    }

    public void addLadder(Integer head, Integer tail) {
        SnakeLadderService.addObject(ObjectType.LADDER, head, tail);
        objectsPosMap.put(head, tail);
    }

    public void addUser(String name) {
        User user = new User(name);
        userPosMap.put(user, 0);
    }

    public void playGame() {
        while (true) {
            boolean winnerDeclared = false;
            for (User user : userPosMap.keySet()) {
                Integer currVal = Dice.getDiceValue(1, 6);
                Integer currPos = userPosMap.get(user);
                if (currPos + currVal == 100) {
                    printMove(user, currVal, currPos, currPos+currVal);
                    printWinner(user);
                    winnerDeclared = true;
                    break;
                }
                if (currPos + currVal > 100) {
                    printMove(user, currVal, currPos, currPos);
                    continue;
                }
                Integer newPos = currPos + currVal;
                if (objectsPosMap.containsKey(newPos)) {
                    newPos = objectsPosMap.get(newPos);
                }
                userPosMap.put(user, newPos);
                printMove(user, currVal, currPos, newPos);
            }
            if (winnerDeclared) {
                break;
            }
        }
    }

    public  void printMove(User user, Integer diceMove, Integer initialPos, Integer newPos) {
        System.out.printf("%s rolled a %s and moved from %s to %s %n", user.getName(), diceMove,
                initialPos, newPos);
    }
    public void printWinner(User user) {
        System.out.printf("%s wins the game %n", user.getName());
    }

}
