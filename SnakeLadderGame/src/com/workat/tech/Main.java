package com.workat.tech;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import com.workat.tech.model.Ladder;
import com.workat.tech.model.Player;
import com.workat.tech.model.Snake;
import com.workat.tech.service.GameService;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Map<Integer, Snake> snakeMap = snakeInput(sc);
		Map<Integer, Ladder> ladderMap = ladderInput(sc);
		Deque<Player> playerQueue = playerInput(sc);

		GameService gameService = new GameService();
		Player winningPlayer = gameService.start(snakeMap, ladderMap, playerQueue);
		System.out.println(winningPlayer.getName()+" wins the game");

		sc.close();
	}

	private static Deque<Player> playerInput(Scanner sc) {
		System.out.println("Enter total number of players");
		int noOfPlayers = sc.nextInt();
		Deque<Player> playerQueue = new LinkedList<>();
		for (int i = 0; i < noOfPlayers; i++) {
			System.out.println("Enter player"+(i+1)+" name");
			String name = sc.next();
			playerQueue.addLast(new Player(name));
		}
		return playerQueue;
	}

	private static Map<Integer, Ladder> ladderInput(Scanner sc) {
		System.out.println("Enter total number of ladders");
		int noOfLadders = sc.nextInt();
		Map<Integer, Ladder> ladderMap = new HashMap<>(noOfLadders);
		for (int i = 0; i < noOfLadders; i++) {
			System.out.println("Enter start position for ladder"+(i+1));
			int start = sc.nextInt();
			System.out.println("Enter end position for ladder"+(i+1));
			int end = sc.nextInt();

			ladderMap.put(start, new Ladder(start, end));
		}
		return ladderMap;
	}

	private static Map<Integer, Snake> snakeInput(Scanner sc) {
		System.out.println("Enter total number of snakes");
		int noOfSnakes = sc.nextInt();
		Map<Integer, Snake> snakeMap = new HashMap<>(noOfSnakes);
		for (int i = 0; i < noOfSnakes; i++) {
			System.out.println("Enter head position for snake"+(i+1));
			int head = sc.nextInt();
			System.out.println("Enter tail position for snake"+(i+1));
			int tail = sc.nextInt();

			snakeMap.put(head, new Snake(head, tail));
		}
		return snakeMap;
	}
}
