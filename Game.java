import java.util.List;

public class Game {

    List<Dice> dices;
    List<Player> players;

    Board board;

    public Game (Board board, List<Player>players, List<Dice> dices)
    {
        this.board = board;
        this.players =players;
        this.dices= dices;
    }
    
    public boolean hasWon(Player player)
    {
        if(player.currPosition == board.size)
            return true;
        return false;
    }

    int newPosOfPlayer(Player player, int count)
    {
        return player.currPosition + count;
    }

}
