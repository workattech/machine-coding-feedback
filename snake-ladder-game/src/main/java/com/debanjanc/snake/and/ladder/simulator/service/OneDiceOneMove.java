package com.debanjanc.snake.and.ladder.simulator.service;

import com.debanjanc.snake.and.ladder.simulator.domain.Cell;
import com.debanjanc.snake.and.ladder.simulator.domain.Game;
import com.debanjanc.snake.and.ladder.simulator.domain.Player;

public class OneDiceOneMove implements MoveCommand {

	private Game game;
	private Player player;

	/* Will be used while undoing */
	private boolean isSuccess = false;
	private Integer diceRolledValue;
	private Cell beforePosition;
	private Cell afterPostion;

	public OneDiceOneMove(Game game, Player player) {
		this.game = game;
		this.player = player;
	}

	public Integer getDiceRolledValue() {
		return diceRolledValue;
	}

	public Cell getBeforePosition() {
		return beforePosition;
	}

	public Game getGame() {
		return game;
	}

	public Player getPlayer() {
		return player;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public Cell getAfterPostion() {
		return afterPostion;
	}

	private Cell newPosition() {

		Cell currentPlayerPosition = this.game.getBoard().getPlayerPosition(this.player);
		this.diceRolledValue = this.game.getDice().roll();
		System.out.println();

		if (currentPlayerPosition.getNumber() + this.diceRolledValue > 100) {
			return currentPlayerPosition;
		} else {

			Cell currentEffectiveCell = this.game.getBoard().cells()
					.get(currentPlayerPosition.getNumber() + this.diceRolledValue);

			while (currentEffectiveCell.compareTo(currentEffectiveCell.getEffectiveCell()) != 0) {
				currentEffectiveCell = currentEffectiveCell.getEffectiveCell();
			}

			return currentEffectiveCell;
		}

	}

	public void call() {

		this.beforePosition = this.game.getBoard().getPlayerPosition(this.player);
		this.afterPostion = this.newPosition();

		if (beforePosition.compareTo(afterPostion) != 0) {
			isSuccess = true;
			this.game.getBoard().changePlayerPosition(this.player, afterPostion);
		}

		System.out.printf("%s rolled a %s and moved from %s to %s\n", this.player.getName(), this.diceRolledValue,
				beforePosition.getNumber(), afterPostion.getNumber());

	}

	public void undo() {
		if (!this.isSuccess) {
			return;
		} else {
			this.game.getBoard().changePlayerPosition(this.player, this.beforePosition);
		}

	}

}
