package com.debanjanc.snake.and.ladder.simulator.setup;

import java.io.InputStream;
import java.util.Scanner;

import com.debanjanc.snake.and.ladder.simulator.domain.Ladder;
import com.debanjanc.snake.and.ladder.simulator.domain.Player;
import com.debanjanc.snake.and.ladder.simulator.domain.Snake;

public class ConsoleGameLoader extends GameLoader {

	private Scanner scanner;

	public ConsoleGameLoader(InputStream inStream) {
		super(inStream);
		scanner = new Scanner(inStream);

	}

	@Override
	protected void loadSnakes() {
		int n = scanner.nextInt();
		while (n-- > 0) {
			getSnakes().add(new Snake(scanner.nextInt(), scanner.nextInt()));
		}

	}

	@Override
	protected void loadLadders() {
		int n = scanner.nextInt();
		while (n-- > 0) {
			getLadders().add(new Ladder(scanner.nextInt(), scanner.nextInt()));
		}

	}

	@Override
	protected void loadPlayers() {
		int n = scanner.nextInt();
		while (n-- > 0) {
			getPlayers().add(new Player(scanner.next()));
		}

	}

	@Override
	protected void loadBoardSize() {
		setBoardSize(100); // Can be load from console if required

	}

	protected void load() {
		super.load();
		scanner.close();
	}

}
