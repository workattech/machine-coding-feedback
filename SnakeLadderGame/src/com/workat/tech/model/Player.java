package com.workat.tech.model;

public class Player {
	String name;
	int currentPosition;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
}
