package com.debanjanc.snake.and.ladder.simulator.setup;

import java.util.List;

import com.debanjanc.snake.and.ladder.simulator.domain.Board;
import com.debanjanc.snake.and.ladder.simulator.domain.Board.Builder;
import com.debanjanc.snake.and.ladder.simulator.domain.Cell;
import com.debanjanc.snake.and.ladder.simulator.domain.Ladder;
import com.debanjanc.snake.and.ladder.simulator.domain.Snake;
import com.debanjanc.snake.and.ladder.simulator.domain.TwoPlayerCubeGame;

public class TwoPlayerCubeGameBuilder extends GameBuilder<TwoPlayerCubeGame> {

	private TwoPlayerCubeGameBuilder(GameLoader gameLoader) {
		super(gameLoader);

	}

	public static TwoPlayerCubeGameBuilder gameLoader(GameLoader gameLoader) {
		return new TwoPlayerCubeGameBuilder(gameLoader);
	}

	@Override
	public TwoPlayerCubeGame build() {

		/* Load the game parameters */
		GameLoader gameLoader = super.getGameLoader();
		gameLoader.load();

		return TwoPlayerCubeGame.Builder.getInstance().board(buildBoard()).firstPlayer(gameLoader.getPlayers().get(0))
				.secondPlayer(gameLoader.getPlayers().get(1)).build();

	}

	private Board buildBoard() {
		Builder boardBuilder = Board.Builder.getInstance();

		GameLoader gameLoader = super.getGameLoader();

		/* Initialize */
		for (int i = 0; i <= gameLoader.getBoardSize(); ++i) {
			boardBuilder.addCell(new Cell(i));
		}

		Board board = boardBuilder.build();
		List<Cell> cells = board.cells();

		/* setup ladders */

		List<Ladder> ladders = gameLoader.getLadders();
		for (Ladder ladder : ladders) {
			cells.get(ladder.getStart()).setEffectiveCell(cells.get(ladder.getEnd()));
		}

		/* setup snakes */
		List<Snake> snakes = gameLoader.getSnakes();
		for (Snake snake : snakes) {
			cells.get(snake.getHead()).setEffectiveCell(cells.get(snake.getTail()));
		}

		return board;

	}

}
