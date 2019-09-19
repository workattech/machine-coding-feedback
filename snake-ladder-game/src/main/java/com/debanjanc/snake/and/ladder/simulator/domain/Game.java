package com.debanjanc.snake.and.ladder.simulator.domain;

import java.util.Collection;

public abstract class Game {

	private final Board board;
	private final Collection<Player> players;
	private final Dice dice;
	private final Integer diceRollPerUser;

	public Game(Board board, Collection<Player> players, Dice dice, Integer diceRollPerUser) {
		this.board = board;
		this.players = players;
		this.dice = dice;
		this.diceRollPerUser = diceRollPerUser;
	}

	public Board getBoard() {
		return board;
	}

	public Collection<Player> getPlayers() {
		return players;
	}

	public Dice getDice() {
		return dice;
	}

	public Integer getDiceRollPerUser() {
		return diceRollPerUser;
	}

}
