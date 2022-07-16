import java.util.Scanner;

import entities.*;
import exceptions.InvalidInputException;
import services.*;

public class SnakeAndLadderApplication {

	
	public static void main(String[] args) {
		
		
		Board b = new Board();
		BoardService bs = new BoardService();
		Dice dice = new Dice();
		
		Scanner sc = new Scanner(System.in);
		
		int numSnakes = Integer.parseInt(sc.nextLine());
		
		while(numSnakes>=1 && sc.hasNextLine()) {
			
			numSnakes-=1;
			String read = sc.nextLine();
			String arr[] = read.split(" ");
			
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			
			try {
			bs.addSnakeOrLadder(x, y, b);
			}
			catch(InvalidInputException e){
				
				System.out.println("\n"+ e.getMessage() + "\n");
				continue;
			}
		}
		
		int numLadder = Integer.parseInt(sc.nextLine());
		
        while(numLadder>=1 && sc.hasNextLine()) {
			
			numLadder-=1;
			String read = sc.nextLine();
			String arr[] = read.split(" ");
			
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			
			try {
				bs.addSnakeOrLadder(x, y, b);
				}
				catch(InvalidInputException e){
					
					System.out.println("\n"+ e.getMessage() + "\n");
					continue;
				}
		}
        
        int numPlayers = Integer.parseInt(sc.nextLine());
        int turn = 0;
        Player[] players = new Player[numPlayers];
        
        while(numPlayers>=1 && sc.hasNextLine()) {
        	
        	numPlayers -=1;
        	String playerName = sc.nextLine();
        	players[turn] = new Player(playerName, turn, 0);
        	turn+=1;
       
        }
        
        turn = 0;
        
        while(true) {
        	
        	int prevPosition = players[turn].getPosition(); 
        	int diceNum = dice.rollDice();		
        	if(players[turn].getPosition()+diceNum <= 100) {
    			
           		players[turn].setPosition(players[turn].getPosition()+diceNum);
    		}
    		
        	int finalPos = bs.playerPosition(players[turn].getPosition(), b);
        	
        	if(finalPos == 100) {
        		
        		System.out.println( players[turn].getName() + " rolled a " + diceNum +" and moved from " 
        	        	 + prevPosition + " to " + finalPos);
        		
        		System.out.println(players[turn].getName()+ " has won the game");
        		break;}
        	
        	System.out.println( players[turn].getName() + " rolled a " + diceNum +" and moved from " 
        	 + prevPosition + " to " + finalPos);
        	
        	players[turn].setPosition(finalPos);
        	
        	turn = (turn+1)%players.length;
            
        }
        
        sc.close();
        
	}
}
