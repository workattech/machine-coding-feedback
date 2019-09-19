package com.debanjanc.snake.and.ladder.simulator.domain;

import com.google.common.collect.ImmutableList;

public class TwoPlayerCubeGame extends Game {

	private TwoPlayerCubeGame(Builder builder) {
		super(builder.board, ImmutableList.of(builder.firstPlayer, builder.secondPlayer), new CubeDice(), 1);

	}

	public static class Builder {

		private Board board;
		private Player firstPlayer;
		private Player secondPlayer;

		public static Builder getInstance() {
			return new Builder();
		}

		public Builder board(Board board) {
			this.board = board;
			return this;
		}

		public Builder firstPlayer(Player firstPlayer) {
			this.firstPlayer = firstPlayer;
			return this;
		}

		public Builder secondPlayer(Player secondPlayer) {
			this.secondPlayer = secondPlayer;
			return this;
		}

		public TwoPlayerCubeGame build() {
			return new TwoPlayerCubeGame(this);
		}
	}

}
