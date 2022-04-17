package com.practice.snakeAndLadder;

import java.util.*;

public class Driver {
	public static void main(String[] args) {
		int[][] snakes = {{62,5},{33,6},{49,9},{88,16},{41,20},{56,53},{98,64},{93,73},{95,75}};
		int[][] ladders = {{2,37},{27,46},{10,32},{51,68},{61,79},{65,84},{71,91},{81,100}};
		String[] playersInput = {"Gaurav", "Sagar", "Ajay"};
		int boardSize = 100;
		Board board = new Board(boardSize);
		board.intializeBoard();
		HashMap<Integer, SnakeLadder> boardMap = board.getBoard();
		for(int i=0; i<snakes.length; i++) {
			Snake snake = new Snake(snakes[i][0], snakes[i][1]);
			boardMap.put(snakes[i][0], snake); 
		}
		for(int i=0; i<ladders.length; i++) {
			Ladder ladder = new Ladder(ladders[i][0], ladders[i][1]);
			boardMap.put(ladders[i][0], ladder);
		}
		List<Player> players = new ArrayList();
		for(int i=0; i<playersInput.length; i++) {
			Player p = new Player(playersInput[i],playersInput[i],0,playersInput.length);
			players.add(p);
		}
		Dice dice = new Dice(1, 6);
		int playersSize = players.size();
		int turn = 0;
		int rank = 1;
		while(playersSize > 1) {
			int diceVal = dice.generateRandomNumber();
			int prevPos = players.get(turn).getPosition();
			int pos = diceVal + prevPos;
			if(pos > board.getBoardSize()) {
				turn = (turn + 1) % playersSize;
				continue;
			}
			//System.out.println(boardMap.get(pos) instanceof Snake);
			while((boardMap.get(pos) instanceof Snake) || (boardMap.get(pos) instanceof Ladder)) {
				if(boardMap.get(pos) instanceof Snake) {
					pos = ((Snake) boardMap.get(pos)).getTail();
					System.out.println(players.get(turn).getPlayerName() + " bitten by Snake and going down from " + prevPos + " to " + pos);
				}
				else if(boardMap.get(pos) instanceof Ladder) {
					pos = ((Ladder) boardMap.get(pos)).getEnd();
					System.out.println(players.get(turn).getPlayerName() + " got ladder and going up from " + prevPos + " to " + pos);
				}
			}
			
			if(pos <= board.getBoardSize()) {
				players.get(turn).setPosition(pos);
				System.out.println(players.get(turn).getPlayerName() + " rolled a " + diceVal + " and moved from " + prevPos + " to " + pos);
			}
			
			if(players.get(turn).getPosition() == board.getBoardSize()) {
				System.out.println(players.get(turn).getPlayerName() +" wins the game with rank " + rank);
				players.get(turn).setRank(rank);
				rank++;
				playersSize--;
			}
			turn = (turn + 1) % playersSize;
		}
	}
}
