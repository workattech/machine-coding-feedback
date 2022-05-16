package com.practice.snakeAndLadder;

public class Player {
	private String playerId;
	private String playerName;
	private int position;
	private int rank;
	public Player(String playerId, String playerName, int position, int rank) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.position = position;
		this.rank = rank;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getPlayerId() {
		return playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
}
