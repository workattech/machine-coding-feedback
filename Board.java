import java.util.Map;
public class Board{

    private Player[] players;
    private Map<Integer,Integer> snakes;
    private Map<Integer,Integer> ladders;

    public Board(Player[] players,Map<Integer,Integer> snakes,Map<Integer,Integer> ladders){

        this.players=players;
        this.snakes=snakes;
        this.ladders=ladders;
    }
    
    public Player[] getPlayers(){
        return this.players;
    }
    
    public Map<Integer,Integer> getSnakes(){
        return this.snakes;
    }
   
   
    public Map<Integer,Integer> getLadders(){
        return this.ladders;
    }
}