import java.util.List;
import java.util.Map;

public class Game {

    private static Object mutex = new Object();
    private static Game game = null;
    private Player[] players;

    private Board board;

    private Dice dice;
    private int noOfPlayers;
    private int currPlayerIndex;

    private Player currPlayer;

    private Player winner = null;
    private Game(){

    }

    public static Game getInstance(){
        if(game==null){
            synchronized (mutex){
                if(game == null){
                    game = new Game();
                }
            }
        }
        return game;
    }

    public void initializeGame(int noOfPlayers, Map<Integer,Integer> snakes, Map<Integer,Integer> ladders, List<String> playerNames){
        this.players = new Player[noOfPlayers];
        this.noOfPlayers = noOfPlayers;
        for(int i=0; i<noOfPlayers; i++){
            this.players[i] = new Player(playerNames.get(i));
        }
        this.board = new Board(10,10,snakes, ladders);
        this.dice = new Dice(1, 6);
    }

    public void Play(){
        while(this.winner == null){
            this.currPlayerIndex = (this.currPlayerIndex+1) % this.noOfPlayers;
            this.currPlayer = this.players[this.currPlayerIndex];
            int currPlayerPosition = this.currPlayer.getCurrPosition();
            int stepsToMove = this.dice.rollDice();
            int nextPosition = this.board.getNextPosition(currPlayerPosition, stepsToMove);
            this.currPlayer.setPrevPosition(currPlayerPosition);
            this.currPlayer.setCurrPosition(nextPosition);
            System.out.println(this.currPlayer.getName() +" rolled a " + stepsToMove + " and moved from " + currPlayerPosition + " to " + nextPosition);
            if(nextPosition==100){
                this.winner = this.currPlayer;
                break;
            }
        }
        System.out.println(this.winner.getName()+" wins the game!!");
    }



}
