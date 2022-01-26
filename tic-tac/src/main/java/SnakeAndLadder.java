import java.util.*;

public class SnakeAndLadder {
    private Map<Integer, Integer> startToEndLadderMap;
    private Map<Integer, Integer> startToEndSnakeMap;
    private List<String> playerList;
    private Map<String, Integer> playerToPositionMap;
    public static final int MIN_DICE_FACE_VALUE = 1;
    public static final int MAX_DICE_FACE_VALUE = 6;
    public static final int WINNING_POSITION_SNAKE_LADDER_GAME = 100;

    public SnakeAndLadder() {
        startToEndLadderMap = new HashMap<>();
        startToEndSnakeMap = new HashMap<>();
        playerToPositionMap = new HashMap<>();
        playerList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int numberOfLadder = sc.nextInt();
        for(int i=0;i<numberOfLadder;++i) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            startToEndLadderMap.put(st, ed);
        }
        int numberOfSnakes = sc.nextInt();
        for(int i=0;i<numberOfSnakes;++i) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            startToEndSnakeMap.put(st, ed);
        }
        int numberOfPlayers = sc.nextInt();
        for(int i=0;i<numberOfPlayers;++i) {
            String playerName = sc.next();
            playerList.add(playerName);
            playerToPositionMap.put(playerName, 0);
        }
    }

    public void startGame() throws Exception {
        System.out.println("Game started");
        while (true) {
            boolean isGameOver = false;
            for (String plyName : playerList) {
                Integer playerPosition = playerToPositionMap.get(plyName);
                if (playerPosition == null) {
                    throw new Exception(plyName + " not found");
                }
                final Random random = new Random();
                int randomDiceValue = MIN_DICE_FACE_VALUE + random.nextInt(6);
                int finalPosition = getPlayerFinalPosition(playerPosition, randomDiceValue);
                System.out.println(String.format(
                        "%s rolled a %d and moved from %d to %d",
                        plyName,
                        randomDiceValue,
                        playerPosition,
                        finalPosition));
                if (finalPosition == WINNING_POSITION_SNAKE_LADDER_GAME) {
                    System.out.println("Winner of game is " + plyName);
                    isGameOver = true;
                    break;
                }
                playerToPositionMap.put(plyName, finalPosition);
            }
            if (isGameOver) {
                break;
            }
        }
    }

    /**
     * Recursive function to get final position after passing through ladder
     * and snake.
     *
     * @param initialPosition
     * @param numberOfStep
     * @return
     */
    private Integer getPlayerFinalPosition(final int initialPosition, final int numberOfStep) {
        if ((initialPosition + numberOfStep) > WINNING_POSITION_SNAKE_LADDER_GAME) {
            return initialPosition;
        }
        if (startToEndLadderMap.containsKey(initialPosition + numberOfStep)) {
            return getPlayerFinalPosition(startToEndLadderMap.get(initialPosition + numberOfStep), 0);
        }
        if (startToEndSnakeMap.containsKey(initialPosition + numberOfStep)) {
            return getPlayerFinalPosition(startToEndSnakeMap.get(initialPosition + numberOfStep), 0);
        }

        return initialPosition + numberOfStep;
    }
}
