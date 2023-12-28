package src.snake_and_ladder;

import java.util.List;

public class Board {
    private int size = GameConfig.getInstance().getBoardSize();
    private BoardEntity snakes;
    private Ladders ladders;
    private DiceRoller dices;
    private List<Player> players;

    /**
     * 
     * @param size    of the Board
     * @param snakes  the list of snakes on the board
     * @param ladders the list of ladders on the board
     * @param dices   number of dice used in the game
     * @param players players record
     * @throws Exception Illegal argument if size is not positive
     */
    public Board(BoardEntity snakes, Ladders ladders, DiceRoller dices, List<Player> players)
            throws Exception {
        this.snakes = snakes;
        this.ladders = ladders;
        this.dices = dices;
        this.players = players;
    }

    public void run() {
        Boolean gameRunning = true;
        while (gameRunning) {
            for (Player player : players) {
                int curPosition = player.getPosition();
                int diceValue = dices.throwChance();
                int newPosition = curPosition + diceValue;
                if (newPosition > size)
                    continue;
                newPosition = getDestinationPosition(newPosition);
                System.out.println(String.format("%s rolled a %d and moved from %d to %d", player.getName(), diceValue,
                        curPosition, newPosition));
                player.setPosition(newPosition);
                if (newPosition == size) {
                    System.out.println(String.format("%s wins the game", player.getName()));
                    gameRunning = false;
                    break;
                }
            }
        }
    }

    private int getDestinationPosition(int position) {
        while (snakes.isPresent(position) || ladders.isPresent(position)) {
            if (snakes.isPresent(position)) {
                position = snakes.getDestinationPosition(position);
            }
            if (ladders.isPresent(position)) {
                position = ladders.getDestinationPosition(position);
            }
        }
        return position;
    }
}
