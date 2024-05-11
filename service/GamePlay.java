package service;

import model.Board;
import model.User;

import java.util.*;

public class GamePlay {

    private final Board board;
    private final int DICE_MIN = 1;
    private final int DICE_MAX = 6;
    private final int CONTINUOUS_MAX_ALLOWED = 3;
    private final Map<Integer, Integer> userPostions;
    private final Map<Integer, Integer> snakePositions;
    private final Map<Integer, Integer> ladderPositions;

    public GamePlay(int ladders, int snakes, int users, List<List<Integer>> laddersList, List<List<Integer>> snakesList, List<String> usersList) {
        board = new Board(ladders, snakes, users);
        board.setLaddersList(laddersList);
        board.setSnakesList(snakesList);
        userPostions = new HashMap<>();
        snakePositions = new HashMap<>();
        ladderPositions = new HashMap<>();
        setUsers(usersList);
        setSnakeAndLadderPositions(snakesList, laddersList);
    }

    private void setUsers(List<String> usersList) {
        List<User> usersClassList = new ArrayList<>();
        for(int i=0; i<usersList.size(); i++) {
            usersClassList.add(new User(i+1, usersList.get(i)));
            userPostions.put(i+1, 0);
        }
        board.setUsersList(usersClassList);
    }

    private void setSnakeAndLadderPositions(List<List<Integer>> snakesList, List<List<Integer>> laddersList) {
        for(int i=0; i<snakesList.size(); i++) {
            snakePositions.put(snakesList.get(i).get(0), snakesList.get(i).get(1));
        }
        for(int i=0; i<laddersList.size(); i++) {
            ladderPositions.put(laddersList.get(i).get(0), laddersList.get(i).get(1));
        }
    }

    public void play() {
        while(true) {
            List<User> currentUsersList = board.getUsersList();

            for(int i=0; i<currentUsersList.size(); i++) {

                User currentUser = currentUsersList.get(i);

                int diceNumber = rollDice();

                int startPosition = userPostions.get(currentUser.getUserId());
                int userPosition = startPosition;

                if(diceNumber == DICE_MAX) {
                    currentUser.incrementContinuousMax();
                    if(currentUser.getContinuousMax() == CONTINUOUS_MAX_ALLOWED) {
                        userPosition = currentUser.getPositionBeforeThreeMoves();
                        currentUser.resetContinuousMax();
                        System.out.println(currentUser.getUserName() + " rolled a " + diceNumber + " and moved from " + startPosition + " to " + userPosition);
                        continue;
                    }
                }

                userPosition += diceNumber;
                if(userPosition > 100) {
                    userPosition = startPosition;
                }
                if (userPosition == 100) {
                    System.out.println(currentUser.getUserName() + " rolled a " + diceNumber + " and moved from " + startPosition + " to " + userPosition);
                    declareWinner(currentUser);
                    return;
                }

                while(snakePositions.containsKey(userPosition) || ladderPositions.containsKey(userPosition)) {
                    if(snakePositions.containsKey(userPosition)) {
                        userPosition = snakePositions.get(userPosition);
                    }
                    else {
                        userPosition = ladderPositions.get(userPosition);
                    }
                }

                if (userPosition == 100) {
                    declareWinner(currentUser);
                    return;
                }

                if(diceNumber != DICE_MAX) {
                    currentUser.setPositionBeforeThreeMoves(userPosition);
                }

                userPostions.put(currentUser.getUserId(), userPosition);

                System.out.println(currentUser.getUserName() + " rolled a " + diceNumber + " and moved from " + startPosition + " to " + userPosition);
            }
        }
    }

    private int rollDice() {
        Random r = new Random();
        int low = DICE_MIN;
        int high = DICE_MAX+1;
        return r.nextInt(high - low) + low;
    }

    private void declareWinner(User user) {
        System.out.println(user.getUserName()+" wins the game");
    }

}
