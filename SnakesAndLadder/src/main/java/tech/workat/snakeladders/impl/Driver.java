package tech.workat.snakeladders.impl;

import tech.workat.snakeladders.impl.domain.models.Ladder;
import tech.workat.snakeladders.impl.domain.models.Player;
import tech.workat.snakeladders.impl.domain.models.Snake;
import tech.workat.snakeladders.impl.domain.services.SnakesAndLadderGameService;

import java.util.*;

public class Driver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SnakesAndLadderGameService snakesAndLadderGameService = new SnakesAndLadderGameService(scanner.nextInt());
        int noOfSnakes = scanner.nextInt();
        List<Snake> snakes = new ArrayList<Snake>();
        for(int i = 0 ; i < noOfSnakes ; i++){
            snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
        }
        int noOfLadders = scanner.nextInt();
        List<Ladder> ladders = new ArrayList<Ladder>();
        for(int i = 0 ; i < noOfLadders; i++){
            ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
        }
        int noOfPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<Player>();
        for(int i =0 ; i < noOfPlayers; i++){
            players.add(new Player(scanner.next()));
        }
        snakesAndLadderGameService.initiliazeSNLBoard(ladders,snakes, players);
        snakesAndLadderGameService.startGame();
    }
}
