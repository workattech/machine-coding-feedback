package com.debanjanc.snake.and.ladder.simulator.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.debanjanc.snake.and.ladder.simulator.domain.Board;
import com.debanjanc.snake.and.ladder.simulator.domain.Player;
import com.debanjanc.snake.and.ladder.simulator.domain.TwoPlayerCubeGame;
import com.debanjanc.snake.and.ladder.simulator.service.OneDiceOneMove;
import com.debanjanc.snake.and.ladder.simulator.setup.ConsoleGameLoader;
import com.debanjanc.snake.and.ladder.simulator.setup.TwoPlayerCubeGameBuilder;

public class ConsoleLauncher {

	public static void main(String args[]) throws Exception{
		
		/* Read the input from file placed under resources */
		URL resource = ConsoleLauncher.class.getResource("/sample-input.txt");
		InputStream inputStream = new FileInputStream(new File(Paths.get(resource.toURI()).toFile().getAbsolutePath()));
		
		/* To read from console send System.in */
		TwoPlayerCubeGame twoPlayerCubeGame = TwoPlayerCubeGameBuilder
				.gameLoader(new ConsoleGameLoader(inputStream)).build();

		Collection<Player> players = twoPlayerCubeGame.getPlayers();
		Board board = twoPlayerCubeGame.getBoard();

		List<OneDiceOneMove> allMoves = new LinkedList<>();
		boolean isWinnerDetermined = false;
		do {
			for (Player player : players) {
				OneDiceOneMove newMove = new OneDiceOneMove(twoPlayerCubeGame, player);
				newMove.call();
				if (newMove.getAfterPostion().getNumber() == board.size()) {
					isWinnerDetermined = true;
					break;
				}

			}

		} while (!isWinnerDetermined);
		
		/*
		 * at this point allMoves can be used to 
		 */
	}

}
