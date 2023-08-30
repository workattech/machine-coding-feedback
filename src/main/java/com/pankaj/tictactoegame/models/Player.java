package com.pankaj.tictactoegame.models;

public class Player {
	private String name;
	private char type;
	private int movestaken;
	
	
	public Player(String name, char type) {
		this.name = name;
		this.type = type;
		this.movestaken=0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public int getMovestaken() {
		return movestaken;
	}
	public void setMovestaken(int movestaken) {
		this.movestaken = movestaken;
	}
}
