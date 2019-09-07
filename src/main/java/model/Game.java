package main.java.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import main.java.constant.GameConstants;

public class Game {
 private int playerCount = 0;
 private int snakeCount = 0;
 private int ladderCount = 0;
 private Player[] players; 
 private Map<Integer,Integer> snakes = new HashMap<>();
 private Map<Integer,Integer> ladders = new HashMap<>();
 private Dice dice = new Dice();
 
public Game() {
	super();
}


public void createGame() {
	Scanner sc = new Scanner(System.in);
	snakeCount = sc.nextInt();
	for(int i=0;i<snakeCount;i++) {
		snakes.put(sc.nextInt(),sc.nextInt());
	}
	ladderCount = sc.nextInt();
	for(int i=0;i<ladderCount;i++) {
		ladders.put(sc.nextInt(),sc.nextInt());
	}
	playerCount = sc.nextInt();
	players = new Player[playerCount];
	for (int i = 0; i < playerCount; i++) {
		players[i] = new Player(sc.next());
	}
	sc.close();
}


public void startGame() {
 boolean winner = false;	
 Player curr = null;
 int value = 0;
 int diceRoll = 0;
 while(!winner) {
	 for(int i=0;i<playerCount;i++) {
		 curr = players[i];
		 diceRoll = dice.getValue();
		 value = newCell(curr.getCell(), diceRoll);
		 while(!isValidCell(value)) {
			 if(snakes.containsKey(value)) {
				 value = snakes.get(value);
			 }else {
				 value = ladders.get(value);
			 }
		 }
		 if(value <= 100) {
				System.out.println(String.format(GameConstants.PLAYER_ROLL_DICE, curr.getName(),diceRoll,curr.getCell(),value)); 
				curr.setCell(value);
		 }
		 
		 if(isWinner(curr)) {
			 winner = true;
			 break;
		 }
	 }
 }
 if(curr!=null) {
	 System.out.println(String.format(GameConstants.PLAYER_WIN, curr.getName())); 
 }
 
}


private boolean isValidCell(int value) {
	// TODO Auto-generated method stub
	return !snakes.containsKey(value) && !ladders.containsKey(value);
}


private int newCell(int cell, int value) {
	// TODO Auto-generated method stub
	return cell + value;
}


private boolean isWinner(Player player) {
	// TODO Auto-generated method stub
	return player.getCell()==100;
}
}
