public class Player {

    private String playerName;
    private int currentPosition;

    public Player(String playerName) {
        this.playerName = playerName;
        this.currentPosition = 0;
    }


    public String getPlayerName() {
        return playerName;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}