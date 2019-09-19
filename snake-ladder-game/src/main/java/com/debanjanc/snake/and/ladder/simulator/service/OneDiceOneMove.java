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
	private Cell finalPosition;
	
	

	public Cell getFinalPosition() {
		return finalPosition;
	}

	public OneDiceOneMove(Game game, Player player) {
		this.game = game;
		this.player = player;
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

		Cell currentPosition = this.game.getBoard().getPlayerPosition(this.player);
		Cell newPosition = this.newPosition();

		if (currentPosition.compareTo(newPosition) != 0) {
			isSuccess = true;
			this.game.getBoard().changePlayerPosition(this.player, newPosition);
		}

		System.out.printf("%s rolled a %s and moved from %s to %s\n", this.player.getName(), this.diceRolledValue,
				currentPosition.getNumber(), newPosition.getNumber());
		this.finalPosition = newPosition;

	}

	public void undo() {
		if (!this.isSuccess) {
			return;
		}

	}

}
