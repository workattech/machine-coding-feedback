package com.debanjanc.snake.and.ladder.simulator.domain;

import java.util.Objects;
import java.util.UUID;

public final class Player {

	private final String name;
	private final String id;

	public Player(String name) {
		this.name = name;
		this.id = UUID.randomUUID().toString();

	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Player other = (Player) obj;

		return Objects.equals(this.id, other.id) && Objects.equals(this.name, other.name);

	}

	@Override
	public int hashCode() {

		return Objects.hash(this.id, this.name);

	}

}
