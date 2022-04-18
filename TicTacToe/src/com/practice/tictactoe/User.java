package com.practice.tictactoe;

public class User {
	private String name;
	private String piece;
	private boolean didIwin;
	public User(String name, String piece, boolean didIwin) {
		this.name = name;
		this.piece = piece;
		this.didIwin = didIwin;
	}
	public boolean getDidIwin() {
		return didIwin;
	}
	public void setDidIwin(boolean didIwin) {
		this.didIwin = didIwin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPiece() {
		return piece;
	}
	public void setPiece(String piece) {
		this.piece = piece;
	}
}
