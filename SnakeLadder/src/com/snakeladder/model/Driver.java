package com.snakeladder.model;

import java.util.ArrayList;

public class Driver {
	public static void main(String[] args) throws Exception {
		int s = 9;
		int l = 8;
		int n = 2;
		ArrayList<ArrayList<Integer>> snakes = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> ladders = new ArrayList<ArrayList<Integer>>();
		ArrayList<String> players = new ArrayList<String>();
		for(int i=0;i<s;i++) {
			snakes.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<l;i++) {
			ladders.add(new ArrayList<Integer>());
		}
		
		snakes.get(0).add(5);
		snakes.get(0).add(62);
		snakes.get(1).add(6);
		snakes.get(1).add(33);
		snakes.get(2).add(9);
		snakes.get(2).add(49);
		snakes.get(3).add(16);
		snakes.get(3).add(88);
		snakes.get(4).add(20);
		snakes.get(4).add(41);
		snakes.get(5).add(53);
		snakes.get(5).add(56);
		snakes.get(6).add(64);
		snakes.get(6).add(98);
		snakes.get(7).add(73);
		snakes.get(7).add(93);
		snakes.get(8).add(75);
		snakes.get(8).add(95);
		
		ladders.get(0).add(2);
		ladders.get(0).add(37);
		ladders.get(1).add(27);
		ladders.get(1).add(46);
		ladders.get(2).add(10);
		ladders.get(2).add(32);
		ladders.get(3).add(51);
		ladders.get(3).add(68);
		ladders.get(4).add(61);
		ladders.get(4).add(79);
		ladders.get(5).add(65);
		ladders.get(5).add(84);
		ladders.get(6).add(71);
		ladders.get(6).add(91);
		ladders.get(7).add(81);
		ladders.get(7).add(100);
		
		players.add("Gaurav");
		players.add("Sagar");
		
		SnakeLadderGame game = new SnakeLadderGame();
		game.initialize(players, snakes, ladders);
		game.start();
	}
}
