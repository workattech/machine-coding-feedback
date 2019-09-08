import java.util.List;

public class GameManager {
    private final Game game;

    public GameManager(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return this.game;
    }

    private boolean isGameWon() {
        int playersWon = 0;
        List<Player> players = this.game.getBoard().getPlayerList();
        for(Player player : players) {
            playersWon += (player.getHasWon())?1:0;
        }
        if(playersWon == (players.size()-1))
            return true;
        return false;
    }
    
    public void play() {
        while (isGameWon() == false) {
            this.game.playGame();
        }
        this.game.setGameWon();
    }
}
