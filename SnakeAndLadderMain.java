import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class SnakeAndLadderMain{

    private static final int WINNING_SCORE=100;
    private static final int STARTING_POSITION=0;
    private static int snakesCount=0;
    private static int laddersCount=0;
    private static int playersCount=0;
       private static String[] playersArray=null;
    private static Random random= new Random();
    private static Map<Integer,Integer> snakesPositionMap=new HashMap<>();
    private static Map<Integer,Integer> laddersPositionMap=new HashMap<>();
    private static Map<String,Integer> playersPositionMap=new HashMap<>();
    
    
    public static void main(String args[]){
        
        System.out.println("Welcome to Snake And Ladder Game \n");
        System.out.println("Enter no. of Snakes in the Game and The starting and ending position of Snake of each Snake:");
        snakesCount=ScannerUtils.readInt();
        
        setUpSnakesInBoard();
         
     
        System.out.println("Enter no. of Ladders in the Game and The starting and ending position of each Ladder:");

        laddersCount=ScannerUtils.readInt();
        
        System.out.println("Enter the number of players and their names");
        playersCount=ScannerUtils.readInt();
        
        
        setUpPlayers();

        playSnakeAndLadder();



}
       

    /**
     * Generates a random number (dice rolling)
     * @return int
     */
    private static int getDiceRolling(){
        return random.nextInt(6)+1;
    }

    /**
     * Method used to calcluate the players position after rolling dice
     * @param diceValue
     * @param currentPosition
     * @param playerName
     * @return
     */
    private static int getPlayerPosition(int diceValue,int currentPosition,String playerName){

            int finalPosition=currentPosition+diceValue;
            if(snakesPositionMap.containsKey(finalPosition)){
                finalPosition=snakesPositionMap.get(finalPosition);
                
                //snake encountered move down the board
    
            }else if(laddersPositionMap.containsKey(finalPosition)){
                finalPosition=laddersPositionMap.get(finalPosition);
                //ladder encountered move up the board
            }
            System.out.println(playerName+" rolled a "+diceValue+" and moved from "+currentPosition+" to "+finalPosition);
                return finalPosition;
            
        
        

    }

    private static setUpSnakesInBoard(){
        if(snakesCount!=0){
            for(int i=1;i<=snakesCount;i++){
                snakesPositionMap.put(ScannerUtils.readInt(), ScannerUtils.readInt());
            }
        }
    }
    private static setUpLaddersInBoard(){
        if(laddersCount!=0){
            for(int i=1;i<=laddersCount;i++){
                laddersPositionMap.put(ScannerUtils.readInt(), ScannerUtils.readInt());
            }
        }
    }
    private static setUpPlayers(){
        if(playersCount!=0){
            playersArray=new String[playersCount];
            for(int i=0;i<playersCount;i++){
               playersArray[i]=ScannerUtils.readString();
                playersPositionMap.put(playersArray[i], STARTING_POSITION);
            }
        }
    }
    private static playSnakeAndLadder(){
        while(true){
            for(int i=0;i<playersArray.length;i++){
                int diceValue=getDiceRolling();
                int playerPosition=getPlayerPosition(diceValue,playersPositionMap.get(playersArray[i]),playersArray[i]);
        
                playersPositionMap.put(playersArray[i], playerPosition);
                if(playersPositionMap.get(playersArray[i])==WINNING_SCORE){
                    System.out.println(playersArray[i]+" has won ");
                    return;
        
                }
        
        
        
            }
        }
    }
    
}