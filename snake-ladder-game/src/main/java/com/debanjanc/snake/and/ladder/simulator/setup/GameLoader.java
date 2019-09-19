package com.debanjanc.snake.and.ladder.simulator.setup;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import com.debanjanc.snake.and.ladder.simulator.domain.Ladder;
import com.debanjanc.snake.and.ladder.simulator.domain.Player;
import com.debanjanc.snake.and.ladder.simulator.domain.Snake;

public abstract class GameLoader {

	private InputStream inStream;
	private Integer boardSize;
	private List<Snake> snakes = new LinkedList<>();
	private List<Ladder> ladders = new LinkedList<>();
	private List<Player> players = new LinkedList<>();

	protected GameLoader(InputStream inStream) {
		this.inStream = inStream;
	}


	protected abstract void loadBoardSize();

	protected abstract void loadSnakes();

	protected abstract void loadLadders();

	protected abstract void loadPlayers();

	protected void load() {
		loadBoardSize();
		loadSnakes();
		loadLadders();
		loadPlayers();

	}
	
	protected InputStream getInputStream() {
		return this.inStream;
	}


	protected Integer getBoardSize() {
		return boardSize;
	}


	protected void setBoardSize(Integer boardSize) {
		this.boardSize = boardSize;
	}


	protected List<Ladder> getLadders() {
		return ladders;
	}


	protected List<Snake> getSnakes() {
		return snakes;
	}


	protected List<Player> getPlayers() {
		return players;
	}


}
