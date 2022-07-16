package com.mtn.SnakeLadder.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
	
	private String id;
	private String name;
	@Setter private CellPosition currentPosition;
	
	public Player(String id, String name) {
		this.id = id;
		this.name = name;
		this.currentPosition = new CellPosition(0);
	}
}
