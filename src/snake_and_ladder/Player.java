package src.snake_and_ladder;

/**
 * denotes a player in the game.
 * 
 * @param name    is the name of the player
 * @param positon is the current position of player on the board
 */
public class Player {
    private String name;
    private int position;

    public Player(String name, int position) throws Exception {
        if (name == null)
            throw new IllegalArgumentException("Name can't be null!");
        int boardSize = GameConfig.getInstance().getBoardSize();
        if (position > boardSize) {
            throw new IllegalArgumentException("Position of a player is bounded by board size!");
        }
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
