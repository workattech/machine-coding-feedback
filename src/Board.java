import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Tile> gameBoard;
    private final List<Player> playerList;

    public Board() {
        gameBoard = new ArrayList<>();
        gameBoard.add(new Tile(0));
        for(int i = 1;i <=Constants.MAXIMUM_TILES;i++) {
            gameBoard.add(new Tile(i));
        }
        this.playerList = new ArrayList<>();
    }

    public List<Tile> getGameBoard() {
        return this.gameBoard;
    }

    public List<Player> getPlayerList() {
        return this.playerList;
    }

    public void addPlayerToGame(Player player) {
        this.playerList.add(player);
    }
}
