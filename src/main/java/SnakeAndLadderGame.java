import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SnakeAndLadderGame {
    private Board board;
    private SnakesMap snakesMap;
    private LaddersMap laddersMap;
    private List<Dice> dices;
    private List<Player> players;
    private List<String> logs;


    public SnakeAndLadderGame(Board board, SnakesMap snakesMap, LaddersMap laddersMap,List<Player> players,List<Dice> dices) {
        this.board = board;
        this.snakesMap = snakesMap;
        this.laddersMap = laddersMap;
        this.players = players;
        this.dices = dices;
        logs = new ArrayList<>();
    }

    private void turnFor(Player player){
        int delta = player.rollTheDices(dices);


        int nextPos = player.getPosition() + delta;


        if(nextPos<100){

            int pos=nextPos;
            do{
                nextPos = pos;

                //snake bite
                int tail = snakesMap.steppedOnSnake(pos);
                if(tail>0)
                    pos = tail;

                //either or

                //ladder
                int end = laddersMap.steppedOnLadder(pos);
                if(end>0)
                    pos = end;

            }while(pos!=nextPos);

        }
        if(nextPos > 100)
            nextPos = player.getPosition();
        logs.add(player.getName()+" rolled a "+delta+" and moved from "+player.getPosition()+" to "+nextPos);
        player.setPosition(nextPos);


    }

    public List<String> playAuto(){

        Iterator<Player> playerIterator = players.iterator();

        while(true) {


            if (!playerIterator.hasNext())
                playerIterator = players.iterator();

            Player currentPlayer = playerIterator.next();

            turnFor(currentPlayer);

            if (currentPlayer.getPosition() == board.getEnd()) {
                logs.add(currentPlayer.getName() + " wins the game");
                break;
            }
        }

        return logs;

    }
}