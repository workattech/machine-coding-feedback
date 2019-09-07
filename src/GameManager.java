import java.util.List;

public class GameManager {
    private final Game game;

    public GameManager(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return this.game;
    }

    public void play() {
        while (this.game.getGameWon() == false) {
            this.game.playGame();
            int playersWon = 0;
            List<Player> players = this.game.getBoard().getPlayerList();
            for(Player player : players) {
                playersWon += (player.getHasWon())?1:0;
            }
            if(playersWon == players.size()-1)
                this.game.setGameWon();
        }
    }
}
