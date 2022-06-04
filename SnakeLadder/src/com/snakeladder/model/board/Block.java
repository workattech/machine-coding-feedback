package com.snakeladder.model.board;

import com.snakeladder.model.Player;
import com.snakeladder.model.entities.Entity;
import com.snakeladder.model.entities.Ladder;
import com.snakeladder.model.entities.Snake;

public class Block {
	private int x;
	private int y;
	private int  blockNumber;
	private Player player;
	private Entity entity;
	
	public Block(int x, int y, int blockNumber) {
		super();
		setBlockNumber(blockNumber);
		setX(x);
		setY(y);
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getBlockNumber() {
		return blockNumber;
	}


	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}

	

	public Entity getEntity() {
		return entity;
	}


	public void setEntity(Entity entity) {
		this.entity = entity;
	}


//	public Snake getSnake() {
//		return snake;
//	}
//
//
//	public void setSnake(Snake snake) {
//		this.snake = snake;
//	}
//
//
//	public Ladder getLadder() {
//		return ladder;
//	}
//
//
//	public void setLadder(Ladder ladder) {
//		this.ladder = ladder;
//	}
	

}
