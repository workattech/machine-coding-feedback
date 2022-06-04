package com.hitesh.demo.snakeladder;

import com.hitesh.demo.snakeladder.controller.GameController;
import com.hitesh.demo.snakeladder.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class SnakeLadderApplication implements CommandLineRunner {

	private final GameController gameController;

	public static void main(String[] args) {
		SpringApplication.run(SnakeLadderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Snake> snakes = new ArrayList<>();
		List<Ladder> ladders = new ArrayList<>();
		List<Player> players = new ArrayList<>();

		Scanner scanner = new Scanner(System.in);

		int snakesCount = scanner.nextInt();

		for(int i=0;i<snakesCount;i++){

			int start = scanner.nextInt();
			int end = scanner.nextInt();

			Snake snake = new Snake(UUID.randomUUID().toString(), new CellPosition(start),
					new CellPosition(end));

			snakes.add(snake);
		}

		int laddersCount = scanner.nextInt();

		for(int i=0;i<laddersCount;i++){

			int start = scanner.nextInt();
			int end = scanner.nextInt();

			Ladder ladder = new Ladder(UUID.randomUUID().toString(), new CellPosition(start),
					new CellPosition(end));

			ladders.add(ladder);
		}

		int playersCount = scanner.nextInt();

		for(int i=0;i<playersCount;i++){
			String name = scanner.next();
			players.add(new Player(UUID.randomUUID().toString(), name));
		}


		Game game = gameController.add(snakes, ladders, players);
		Player winner = gameController.run(game);

		System.out.println(winner.getName() + " wins the game");

	}
}
