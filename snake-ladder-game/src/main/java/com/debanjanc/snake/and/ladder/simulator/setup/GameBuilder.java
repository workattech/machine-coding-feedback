package com.debanjanc.snake.and.ladder.simulator.setup;

import com.debanjanc.snake.and.ladder.simulator.domain.Game;

public abstract class GameBuilder<T extends Game>{

	private final GameLoader gameLoader;
	

	public GameLoader getGameLoader() {
		return gameLoader;
	}

	public GameBuilder(GameLoader gameLoader) {
		this.gameLoader = gameLoader;
	}
	
	public abstract T build();

}
