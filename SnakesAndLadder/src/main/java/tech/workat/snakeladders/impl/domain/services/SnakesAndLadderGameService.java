package tech.workat.snakeladders.impl.domain.services;

import tech.workat.snakeladders.impl.domain.models.Ladder;
import tech.workat.snakeladders.impl.domain.models.Player;
import tech.workat.snakeladders.impl.domain.models.Snake;
import tech.workat.snakeladders.impl.domain.models.SnakesAndLaddersBoard;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakesAndLadderGameService {

    private SnakesAndLaddersBoard snakesAndLaddersBoard;

    private Queue<Player> players;

    public SnakesAndLadderGameService(int maxBoardSize) {
        this.snakesAndLaddersBoard = new SnakesAndLaddersBoard(maxBoardSize);
        this.players = new LinkedList<>();
    }

    public void initiliazeSNLBoard(List<Ladder> ladders, List<Snake> snakes, List<Player> players){
        snakesAndLaddersBoard.setLadders(ladders);
        snakesAndLaddersBoard.setSnakes(snakes);
        for (Player player : players){
            snakesAndLaddersBoard.getPlayerPositions().put(player, 0);
            this.players.add(player);
        }
    }

    private boolean hasPlayerWonTheGame(Player player){
        Integer currentPosition = getCurrentPosition(player);
        if(currentPosition.equals(new Integer(snakesAndLaddersBoard.getEndPosition()))){
            return true;
        }
        return false;
    }

    private int getCurrentPosition(Player player) {
        return snakesAndLaddersBoard.getPlayerPositions().get(player);
    }


    public void startGame(){
        while(!players.isEmpty()){
            Player player = players.poll();
            int diceValue = DiceService.rollDice();
            int newPosition = movePlayer(player, diceValue);
            System.out.println(player.getName() + " rolled a " + diceValue + " and moved from " + getCurrentPosition(player) + " to " + newPosition);
            changePlayerPositionInBoard(player,newPosition);
            if(hasPlayerWonTheGame(player)){
                System.out.println(player.getName() + " has won the game");
                players.remove();
            }
            else{
                players.add(player);
            }
        }


    }

    private void changePlayerPositionInBoard(Player player, Integer newPosition) {
        snakesAndLaddersBoard.getPlayerPositions().put(player, newPosition);
    }

    private int movePlayer(Player player, int diceValue) {
        int currPoss = getCurrentPosition(player);
        if(currPoss + diceValue > snakesAndLaddersBoard.getEndPosition()){
            return currPoss;
        }
        else{
            return currPoss + diceValue;
        }
    }
}
