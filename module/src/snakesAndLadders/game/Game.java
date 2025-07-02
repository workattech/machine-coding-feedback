package snakesAndLadders.game;

import snakesAndLadders.board.Board;
import snakesAndLadders.model.Dice;
import snakesAndLadders.model.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Game {
    Queue<Player> players;
    Board board;
    Dice dice;
    public Game(List<Player> players, Map<Integer,Integer> snakes, Map<Integer,Integer> ladders){
         this.players = new LinkedList<Player>(players);
         this.board = new Board(snakes,ladders);
         this.dice = new Dice();
    }
    public void start(){
        while(!players.isEmpty()){
            Player current = players.peek();
            players.remove();
            int roll = dice.roll();
            System.out.println("Player "+current.getName()+" rolled: "+roll);
            int newPosition = current.getPosition() + roll;
            if(newPosition > 100){
                newPosition = current.getPosition();
            } else{
                newPosition = board.getNextPosition(newPosition);
            }
            current.setPosition(newPosition);
            if(newPosition == 100){
                System.out.println("Player " + current.getName() + " won!");
                break;
            }
            players.add(current);
        }
    }
}
