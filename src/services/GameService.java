package services;

import OutputWriter.OutputWriter;
import models.Game;
import models.Obstacles;
import models.Player;

import java.util.LinkedList;
import java.util.Queue;

public class GameService {
    final Game game;
    final PlayerService playerService;
    final OutputWriter outputWriter;

    public GameService(Game game, PlayerService playerService, OutputWriter outputWriter) {
        this.game = game;
        this.playerService = playerService;
        this.outputWriter = outputWriter;
    }

    private int getNewPosition(Player player, int diceValue) {
        int currentPosition = player.getCurrentPosition();
        int newPosition = currentPosition + diceValue;

        if(newPosition > 100){
            newPosition = currentPosition;
        } else {
            newPosition = getPostionIfObstacle(newPosition);
        }

        return newPosition;
    }

    public int getPostionIfObstacle(int position) {
        int newPosition = -1;
        while(position!=newPosition && newPosition==-1){
            for(Obstacles obstacle : game.getBoard().getObstacles()) {
                if(obstacle.getStart() == position){
                     position = obstacle.getEnd();
                    break;
                }
            }
            newPosition = position;

        }
        return newPosition;
    }

    public boolean checkWinner(Player player) {
        if (player.getCurrentPosition() == game.getBoard().getMaxPosition()){
            outputWriter.onWin(player);
            return true;
        }
        return false;
    }

    public void runGame() {
        Queue<Player> playersQueue = new LinkedList<>();
        playersQueue.addAll(game.getPlayers());

        while (!playersQueue.isEmpty()) {
            Player player = playersQueue.poll();
            int diceValue = playerService.rolldice(player);
            int newPostion = getNewPosition(player, diceValue);
            playerService.updatePosition(player, newPostion);
            outputWriter.onTurnCompletion(player, diceValue);
            if(!checkWinner(player)){
                playersQueue.add(player);
            } else {
                break;
            }
        }
    }
}
