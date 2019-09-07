public class Player {
    private final String playerName;
    private int playerCoordinate;
    private boolean hasWon;

    public Player(String playerName) {
        this.playerName = playerName;
        this.playerCoordinate = 0;
        this.hasWon = false;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public int getPlayerCoordinate() {
        return this.playerCoordinate;
    }

    public void setPlayerCoordinate(int playerCoordinate) {
        this.playerCoordinate = playerCoordinate;
        return;
    }

    public boolean getHasWon() {
        return this.hasWon;
    }

    public void setHasWon() {
        this.hasWon = true;
    }
}
