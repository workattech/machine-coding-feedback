import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random; 

public class SnakeAndLadderMain{

    private static final int WINNING_SCORE=100;
    private static final int STARTING_POSITION=0;
    private static Random random= new Random();

    public static void main(String args[]){
        
        System.out.println("Welcome to Snake And Ladder Game \n");

        
        System.out.println("Enter no. of Snakes in the Game and The starting and ending position of Snake of each Snake:");
        int snakesCount=ScannerUtils.readInt();
        Map<Integer,Integer> snakesPositionMap=setUpSnakes(snakesCount);

        System.out.println("Enter no. of Ladders in the Game and The starting and ending position of each Ladder:");
        int laddersCount=ScannerUtils.readInt();
        Map<Integer,Integer> laddersPositionMap=setUpLadders(laddersCount);
        
        System.out.println("Enter the number of players and their names");
        int playersCount=ScannerUtils.readInt();
        Player[] playersArray=setUpPlayers(playersCount);

        Board board=new Board(playersArray,snakesPositionMap,laddersPositionMap);

        playSnakeAndLadder(board);



}
       

    /**
     * Generates a random number (dice rolling)
     * @return int
     */
    private static int getDiceRolling(){
        return random.nextInt(6)+1;
    }

  

    private static Map<Integer,Integer> setUpSnakes(int snakesCount){
       Map<Integer,Integer> snakesMap=new HashMap<>();
        if(snakesCount!=0){
            
            for(int i=1;i<=snakesCount;i++){
                snakesMap.put(ScannerUtils.readInt(), ScannerUtils.readInt());
              
            }
            
        }
        return snakesMap;
    }
    private static  Map<Integer,Integer>  setUpLadders(int laddersCount){
        Map<Integer,Integer> laddersMap=new HashMap<>();
        if(laddersCount!=0){
            
            for(int i=1;i<=laddersCount;i++){
                laddersMap.put(ScannerUtils.readInt(), ScannerUtils.readInt());
              
            }
            
        }
        return laddersMap;
        
    }
    private static Player[] setUpPlayers(int playersCount){
        Player[] players=null;
        if(playersCount!=0){
            players=new Player[playersCount];
            for(int i=0;i<playersCount;i++){
                Player player=new Player(ScannerUtils.readString(),STARTING_POSITION);
                players[i]=player;
                
                
           }
      
        }
        return players;
      
    }
    private static void playSnakeAndLadder(Board board){
        
        while(true){
            for(int i=0;i<board.getPlayers().length;i++){
                int diceValue=getDiceRolling();
                Player currentPlayer=board.getPlayers()[i];
                int playerFinalPosition=currentPlayer.calculatePlayerPosition(diceValue,currentPlayer.getPosition(),currentPlayer.getName(),board);
                System.out.println(currentPlayer.getName()+" rolled a "+diceValue+" and moved from "+currentPlayer.getPosition()+" to "+playerFinalPosition);
                currentPlayer.setPosition(playerFinalPosition);
                if(playerFinalPosition==WINNING_SCORE){
                    System.out.println(currentPlayer.getName()+" has won ");
                    return;
        
                }
            }
        }
    }
    
}