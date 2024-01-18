package gamemodel;

/**
 * @author r.shukla
 */
public class Player implements Plays {

    private String playerName;

    private int playerPosition;

    public Player(String playerName) {
        this.playerName = playerName;
        this.playerPosition = 0;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    /**
     *
     * @return
     */
    public String getPlayerName() {
        return playerName;
    }
}
