package com.debanjanc.snake.and.ladder.simulator.domain;

public final class Player {

	private final String name;

	public String getName() {
		return name;
	}

	public Player(String name) {
		this.name = name;

	}
	
	

	@Override
	public String toString() {
		return "Player [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	

}
