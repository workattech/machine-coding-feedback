package com.workat.tech.service;

import java.util.Deque;
import java.util.Map;

import com.workat.tech.model.Ladder;
import com.workat.tech.model.Player;
import com.workat.tech.model.Snake;

public class GameService {

	public Player start(Map<Integer, Snake> snakeMap, Map<Integer, Ladder> ladderMap, Deque<Player> playerQueue) {

		while (!playerQueue.isEmpty()) {
			Player player = playerQueue.removeFirst();
			int dice = DiceService.rollTheDice();
			int currentPosition = player.getCurrentPosition();
			int prevPosition = currentPosition;
			currentPosition += dice;

			currentPosition = checkSnakeAndLadder(currentPosition, snakeMap, ladderMap);

			if(currentPosition == 100) {
				player.setCurrentPosition(currentPosition);
				return player;
			}
			if(currentPosition > 100) {
				System.out.println(player.getName()+" rolled a "+dice+" and did not move");
				playerQueue.addLast(player);
				continue;
			}

			player.setCurrentPosition(currentPosition);
			playerQueue.addLast(player);

			System.out.println(player.getName()+" rolled a "+dice+" and moved from "+prevPosition+" to "+currentPosition);
		}

		throw new RuntimeException("Game ended abruptly");
	}

	private int checkSnakeAndLadder(int currentPosition, Map<Integer, Snake> snakeMap, Map<Integer, Ladder> ladderMap) {
		if (!snakeMap.containsKey(currentPosition) && !ladderMap.containsKey(currentPosition)) {
			return currentPosition;
		}

		if(snakeMap.containsKey(currentPosition)) {
			currentPosition = snakeMap.get(currentPosition).getTail();
		}

		if (ladderMap.containsKey(currentPosition)) {
			currentPosition = ladderMap.get(currentPosition).getEnd();
		}

		return checkSnakeAndLadder(currentPosition, snakeMap, ladderMap);
	}

}
