package com.snakeladder.model.entities;

import com.snakeladder.model.board.Block;

public class Entity {
	private Block startBlock;
	private Block endBlock;
	
	public Entity(Block startBlock, Block endBlock) {
		super();
		setStartBlock(startBlock);
		setEndBlock(endBlock);
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
	
	
}
