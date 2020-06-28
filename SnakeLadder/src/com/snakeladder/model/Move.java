package com.snakeladder.model;

import com.snakeladder.model.board.Block;

public class Move {
	private int diceNumber;
	private Block startBlock;
	private Block endBlock;
	private Player player;
	public Move(int diceNumber, Block startBlock, Block endBlock, Player player) {
		super();
		setDiceNumber(diceNumber);
		setEndBlock(endBlock);
		setStartBlock(startBlock);
		setPlayer(player);
	}
	public int getDiceNumber() {
		return diceNumber;
	}
	public void setDiceNumber(int diceNumber) {
		this.diceNumber = diceNumber;
	}
	public Block getStartBlock() {
		return startBlock;
	}
	public void setStartBlock(Block startBlock) {
		this.startBlock = startBlock;
	}
	public Block getEndBlock() {
		return endBlock;
	}
	public void setEndBlock(Block endBlock) {
		this.endBlock = endBlock;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
}
