import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SnakeAndLadderService {

    public static boolean hasWon=false;
    private static boolean flag=false;
    static Random random=new Random();
    public static  Player p1=new Player("Arjun");
    public static Player p2=new Player("Gaurav");

    public static int getDiceNumber(){
        return 1+random.nextInt(6);
    }

    public static Player getPlayer(){
        return flag?p1:p2;
    }



    public static void startGame(int[][] snakesStartAndEnd,int[][] laddersStartAndEnd,int numOfPlayers){

        while(!hasWon){
                int diceRollOutput=getDiceNumber();
                flag=!flag;
                Player current_player=getPlayer();
                current_player.setDiceRollOut(diceRollOutput);
                SnakeAndLadderUtilityService utilityService=new SnakeAndLadderUtilityService();
                hasWon=utilityService.startGameUtil(snakesStartAndEnd,laddersStartAndEnd,current_player,diceRollOutput);
        }
        System.out.println(getPlayer()+" has won the game");
    }
}
