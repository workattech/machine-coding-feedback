package app;

import java.util.*;
import java.lang.Integer;
import players.*;
import board.*;
import dice.*;


public class App {

	public static void main(String[] args) {
        
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//generating snakes
        System.out.println("Enter number of snakes");
        int no_of_snakes = sc.nextInt();
        
        sc.nextLine();
        
        int[][] snakes = new int[no_of_snakes][2];

        for(int i = 0; i<no_of_snakes; i+=1){
            String[] ip = sc.nextLine().split(" ");
            
            snakes[i][0] = Integer.parseInt(ip[0]);
            snakes[i][1] = Integer.parseInt(ip[1]);
        }

        //generating ladders
        System.out.println("Enter number of ladders");
        int no_of_ladders = sc.nextInt();
        
        sc.nextLine();

        int[][] ladders = new int[no_of_ladders][2];

        for(int i = 0; i<no_of_ladders; i+=1){
            String[] ip = sc.nextLine().split(" ");
            ladders[i][0] = Integer.parseInt(ip[0]);
            ladders[i][1] = Integer.parseInt(ip[1]);
        }

        
        //generating board
        Board board = new Board(snakes, ladders);
        
        
        //Generating players
        System.out.println("Enter number of players");
        int no_of_players = sc.nextInt();
        
        sc.nextLine();

        Player[] players = new Player[no_of_players];

        for(int i = 0; i<no_of_players; i+=1){
            String name = sc.nextLine();
            Player p = new Player(name);
            players[i] = p;
        }



        
        Dice dice = new Dice();

        //playing
        int max_pos = 0;
        while (max_pos < 100) {
        	for(int i = 0; i<no_of_players; i+=1){

                int prev_pos = players[i].peice.getPos();
                int dice_value = players[i].rolldice(dice);

                board.checkSnake(players[i].peice);

                board.checkLadder(players[i].peice);

                System.out.println(players[i].name + " rolled a " + dice_value + " and moved from " + prev_pos + " to " + players[i].peice.getPos());
                             
                
                if(players[i].peice.getPos() > max_pos) {
                	max_pos = players[i].peice.getPos();
                }
                
                
                if(players[i].peice.getPos() == 100){
                    System.out.println(players[i].name + " wins the game");
                    break;
                }
            }
        }
        

        sc.close();

	}

}
