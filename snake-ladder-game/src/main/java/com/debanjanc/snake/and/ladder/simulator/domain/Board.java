package com.debanjanc.snake.and.ladder.simulator.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

	private final List<Cell> cells;
	
	private Map<Player, Cell> positionMap = new HashMap<>();

	public List<Cell> cells() {
		return Collections.unmodifiableList(cells);
	}
	
	public Cell getPlayerPosition(Player player) {
		return positionMap.getOrDefault(player, cells.get(0));
	}
	
	public Cell changePlayerPosition(Player player, Cell cell) {
		return positionMap.put(player, cell);
	}
	
	public Integer size() {
		return this.cells.size() - 1;
	}

	private Board(Builder builder) {
		this.cells = builder;
	}

	public static class Builder extends ArrayList<Cell> {

		private static final long serialVersionUID = 7127748332817723222L;

		private Builder() {
			super();
		}

		public static Builder getInstance() {
			return new Builder();
		}

		public Builder addCell(Cell cell) {
			super.add(cell);
			return this;
		}

		public Builder addCells(Collection<Cell> cells) {
			cells.addAll(cells);
			return this;
		}

		public Board build() {

			Collections.sort(this);
			return new Board(this);

		}

	}

}
