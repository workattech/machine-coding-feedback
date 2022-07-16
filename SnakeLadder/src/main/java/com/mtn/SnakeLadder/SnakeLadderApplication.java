package com.mtn.SnakeLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mtn.SnakeLadder.controller.SnakeLadderController;
import com.mtn.SnakeLadder.entity.CellPosition;
import com.mtn.SnakeLadder.entity.Game;
import com.mtn.SnakeLadder.entity.Ladder;
import com.mtn.SnakeLadder.entity.Player;
import com.mtn.SnakeLadder.entity.Snake;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class SnakeLadderApplication implements CommandLineRunner{

	private static final Logger logger = Logger.getLogger("MyLogger");
	
	
	private final SnakeLadderController snakeLadderController;
	
	public static void main(String[] args) {
		SpringApplication.run(SnakeLadderApplication.class, args);
	}
	
	public void run(String... args) throws Exception{
		List<Snake> snakes = new ArrayList<>();
		List<Ladder> ladders = new ArrayList<>();
		List<Player> players = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		int numOfSnakes = sc.nextInt();
		
		for(int i=0; i<numOfSnakes; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			Snake snake = new Snake(UUID.randomUUID().toString(), new CellPosition(start), new CellPosition(end));
			snakes.add(snake);
		}
		
		int numOfLadders = sc.nextInt();
		
		for(int i=0; i<numOfLadders; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			Ladder ladder = new Ladder(UUID.randomUUID().toString(), new CellPosition(start), new CellPosition(end));
			ladders.add(ladder);
		}
		
		int numOfPlayers = sc.nextInt();
		
		for(int i=0; i<numOfPlayers; i++) {
			String name = sc.next();
			
			Player player = new Player(UUID.randomUUID().toString(), name);
			players.add(player);
		}
		
		Game game = snakeLadderController.add(snakes, ladders, players);
		Player winner = snakeLadderController.run(game);
		
		logger.info(winner.getName()+ " wins the game");
	}
}
