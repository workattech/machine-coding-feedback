package com.snakeladder.model;

import java.util.ArrayList;

import com.snakeladder.model.board.Block;

public class Player {
	private String name;
	private long uid;
	private long NEW_UID = 0;
	private Block currentBlock;
	
	public Player(String name, Block currentBlock) {
		setUid();
		setName(name);
		setCurrentBlock(currentBlock);
	}
	
	public void setUid() {
		this.uid = NEW_UID++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Block getCurrentBlock() {
		return currentBlock;
	}

	public void setCurrentBlock(Block currentBlock) {
		this.currentBlock = currentBlock;
	}

	public long getUid() {
		return uid;
	}
}
