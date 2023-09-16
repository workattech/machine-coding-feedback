/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author rails
 */
public class Game {
    Board board;
    List<Player> players;
    boolean finished;
    
    Game() throws IOException{
        this.board = new Board();
        this.board.initialize();
        this.players = new ArrayList<>();
        this.finished = false;
    }
    
    // Add multiple players to a game taking input from user
    
    public void addPlayers() throws IOException{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPlayers = Integer.parseInt(br.readLine().trim());
        while(numberOfPlayers > 0){
            numberOfPlayers--;
            String name = br.readLine();
            Player player = new Player(name);
            this.addPlayerToGame(player);
        }
    }
    
    // Add a single player to a game
    private void addPlayerToGame(Player player){
        players.add(player);
    }
    
    // Simulate the game turns between all players
    
    public void simulate(){
        int numberOfPlayers = players.size();
        int currentPlayer = 0;
        // Keep playing till the game is not finished
        while(!finished){
            makeMove(players.get(currentPlayer % numberOfPlayers));
            currentPlayer++;
        }
    }
    
    private void makeMove(Player player){
        // Play with two dices instead of one
        int dice1 = rollDice();
        int dice2 = rollDice();
        int move = dice1 + dice2;
        int initialPosition = player.getPosition();
        // Get next position of player on board on making the move
        int newPosition = this.board.getNextPosition(initialPosition, move);
        player.setPosition(newPosition);
        System.out.println(player.getName() + " rolled a " + move + 
                " and moved from "+ initialPosition + " to " + newPosition);
        
        // Check if the player reached the won i.e won the game
        if(newPosition == 100){
            this.finished = true;
            System.out.println(player.getName() + " wins the game");
        }
    }
    
    private int rollDice(){
        int max = 6;
        int min = 1;
        Random r = new Random();
        // Generate a random number between min and max including both
        return r.nextInt((max - min) + 1) + min; 
    }
}

