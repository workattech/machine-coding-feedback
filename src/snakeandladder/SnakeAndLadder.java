/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladder;

import java.io.IOException;

/**
 *
 * @author rails
 */
public class SnakeAndLadder {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        Game game = new Game();
        game.addPlayers();
        game.simulate();
    }
    
}
