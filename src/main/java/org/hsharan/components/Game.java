package org.hsharan.components;

import org.hsharan.components.Ladder;
import org.hsharan.components.Player;
import org.hsharan.components.Snake;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game {
    public static final Integer[] diceNum={1,2,3,4,5,6};
    private static Integer turnCounter;
    private static Integer playerCount;
    private static final Integer winningNum = 100;

    private static List<Player> playerList;

    private static Logger logger = Logger.getLogger("Game");


    /**generates Random Dice Number**/
    public static Integer rollDice(){
        Random random = new Random();
        return diceNum[random.nextInt(diceNum.length-1)];
    }

    /**Initialize the Board**/
    public static void initializeGame(){
        turnCounter=0;

        playerList = Player.getAllPlayer();
        playerCount = playerList.size();
        for(Player var : playerList){
            var.setPosition(0);
        }
    }

    /** get the Final Postion after applying the change done by snake or Ladder **/
    public static Integer getFinalPostion(Integer curPosition){
        Snake snake = Snake.getSnake(curPosition);
        Ladder ladder = Ladder.getLadder(curPosition);

        if(snake!=null){
            return snake.getEnd();
        } else if (ladder!=null) {
            return ladder.getEnd();
        }
        else {
            return curPosition;
        }
    }

    /** Move the player Based on its steps **/
    public static void movePlayer(Integer steps,Player player) throws Exception{
        player.setPosition(getFinalPostion(player.getPosition()+steps));
    }

    /** Move the Turn to next Player **/
    private static Integer  increaseTurnCounter(){
        turnCounter= (turnCounter+1)%playerCount;
        return turnCounter;
    }

    /** move the current player by rolling the dice and return if he wins or not **/
    public static Boolean playMove() throws Exception {
        Integer diceResult = rollDice();
        Player player = playerList.get(turnCounter);
        Integer currentPosition = player.getPosition();
        movePlayer(diceResult,player);
        logger.log(Level.INFO,"{0} rolled a {1} and moved from {2} to {3}",
                new Object[]{player.getName(),
                        diceResult,
                        currentPosition,
                        player.getPosition()
        });
        if(player.getPosition()==winningNum){
            return true;
        }
        else {
            return false;
        }
    }

    /** Return the winner by moving player until one of them reaches the winning position  **/
    public static Player playGame() throws Exception {
        initializeGame();
        while(playMove()==false){
            increaseTurnCounter();
        }

        return playerList.get(turnCounter);
    }

}
