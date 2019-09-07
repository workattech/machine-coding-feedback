/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *
 * @author rails
 */
public class Board {
    HashMap<Integer, Integer> snakes;
    HashMap<Integer, Integer> ladders;
    
    Board() throws IOException{
        snakes = new HashMap<>();
        ladders = new HashMap<>();
    }
    
    public int getNextPosition(int initialPosition, int move){
        int nextPosition;
        nextPosition = initialPosition + move;
        
        // Keep moving till there is no ladder or snake on player's new position
        while(true){
            // If the move leads to a position greater than 100, don't make the move
            if(nextPosition > 100)
                return initialPosition;
            if(snakes.containsKey(nextPosition)){
                nextPosition = snakes.get(nextPosition);
            } else if (ladders.containsKey(nextPosition)) {
                nextPosition = ladders.get(nextPosition);
            } else {
                return nextPosition;
            }
        }
    }
    
    public void addSnake(Snake snake){
        snakes.put(snake.getHead(), snake.getTail());
    }
    
    public void addLadder(Ladder ladder){
        ladders.put(ladder.getStart(), ladder.getEnd());
    }
    
    public void initialize() throws IOException{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        
        // Take input for snakes
        int numberOfSnakes = Integer.parseInt(br.readLine());
        while(numberOfSnakes > 0){
            numberOfSnakes--;
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            int head = Integer.parseInt(strs[0]);
            int tail = Integer.parseInt(strs[1]);
            Snake snake = new Snake(head, tail);
            this.addSnake(snake);
        }
        
        // Take input for ladders
        int numberOfLadders = Integer.parseInt(br.readLine());
        while(numberOfLadders > 0){
            numberOfLadders--;
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            int start = Integer.parseInt(strs[0]);
            int end = Integer.parseInt(strs[1]);
            Ladder ladder = new Ladder(start, end);
            this.addLadder(ladder);
        }
    }
   
}
