import gamemodel.GameEnhancement;
import gamemodel.GameModel;
import gamemodel.Player;

import java.util.*;

/**
 * @author r.shukla
 */
public class SnakeAndLadderGame {

    private static final int DICE_FACES = 6;
    private static Map<Integer, GameModel> snakesMap = new HashMap<>();
    private static Map<Integer, GameModel> ladderMap = new HashMap<>();
    private static Queue<Player> playerQueue = new LinkedList<>();
    private static final int MAX_BOARD_CELL = 100;

    /**
     * ENUM for game factors
     */
    private enum GameFactors { SNAKES, LADDERS }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        scannGameInfo();
        playGame();
    }

    private static void scannGameInfo() {
        Scanner scanner = new Scanner(System.in);
        int snakes  = scanner.nextInt();
        while (snakes > 0) {
            putValueInMap(GameFactors.SNAKES, scanner);
            snakes--;
        }
        int ladders = scanner.nextInt();
        while (ladders > 0) {
            putValueInMap(GameFactors.LADDERS, scanner);
            ladders--;
        }
        int players = scanner.nextInt();
        while (players > 0) {
            Player player = new Player(scanner.next());
            playerQueue.add(player);
            players--;
        }
    }

    private static void putValueInMap(GameFactors type, Scanner scanner) {
        int startPosition = scanner.nextInt();
        int endPosition = scanner.nextInt();
        if (GameFactors.SNAKES.equals(type)) {
            snakesMap.put(startPosition, getGameModel(startPosition, endPosition));
        } else {
            ladderMap.put(startPosition, getGameModel(startPosition, endPosition));
        }
    }

    private static GameModel getGameModel(int startPosition, int endPosition) {
        return new GameEnhancement(startPosition, endPosition);
    }

    //Used single class , can be moved in separate class for game algo
    /**
     * made public to test the functionality , can be removed in general as the method should be accessed from main method only
     */
    public static void playGame() {
        while (!playerQueue.isEmpty()) {
            Player player = playerQueue.poll();
            int diceValue = rollDice();
            int playerPosition = setPlayerPosition(player, diceValue);
            playerQueue.add(player);
            if (checkHasPlayerWon(playerPosition)) {
                declareWinner(player);
            }
        }
    }

    private static int setPlayerPosition(Player player, int diceValue) {
        int initialPosition = player.getPlayerPosition();
        int finalPosition = diceValue + initialPosition;
        if (finalPosition <= MAX_BOARD_CELL) {
            if (isLadder(finalPosition) && ladderMap.get(finalPosition) != null) {
                finalPosition = ladderMap.get(finalPosition).getfinalPosition();
            } else if (isSnake(finalPosition) && snakesMap.get(finalPosition) != null) {
                finalPosition = snakesMap.get(finalPosition).getfinalPosition();
            }
            player.setPlayerPosition(finalPosition);
            printPlayerStepMessage(player.getPlayerName(), diceValue, initialPosition, finalPosition);
            return finalPosition;
        }
        return initialPosition;
    }

    private static void declareWinner(Player player) {
        System.out.println(player.getPlayerName() + " wins the game");
        if (playerQueue != null) {
            playerQueue.clear();
        }
    }

    private static void printPlayerStepMessage(String playerName, int diceValue, int initialPosition,
                                               int finalPosition) {
      String gameMessage =  playerName + " rolled a " + diceValue + " and moved from " + initialPosition + " to "
              + finalPosition;
      System.out.println(gameMessage);
    }

    private static int rollDice() {
        Random ran = new Random();
        return ran.nextInt(DICE_FACES) + 1;
    }

    private static boolean isLadder(int cellPosition) {
        return snakesMap.containsKey(cellPosition);
    }

    private static  boolean isSnake(int cellPosition) {
        return ladderMap.containsKey(cellPosition);
    }

    private static boolean checkHasPlayerWon(int cellPosition) {
        if (cellPosition == MAX_BOARD_CELL) {
            return true;
        }
        return false;
    }
}
