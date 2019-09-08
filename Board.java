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

     /**
     * Method used to calcluate the players position after rolling dice
     * @param diceValue
     * @param currentPosition
     * @param playerName
     * @return
     */
    public int calculatePlayerPosition(int diceValue,int currentPosition,String playerName){
        int finalPosition=currentPosition+diceValue;
        if(this.getSnakes()!=null&& !this.getSnakes().isEmpty() && this.getSnakes().containsKey(finalPosition)){
            finalPosition=this.getSnakes().get(finalPosition);
            //snake encountered move down the board
        }else if(this.getLadders()!=null &&!this.getLadders().isEmpty()&& this.getLadders().containsKey(finalPosition)){
            finalPosition=this.getLadders().get(finalPosition);
            //ladder encountered move up the board
        }
            return finalPosition;
}
}