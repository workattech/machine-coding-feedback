package com.snakeladder.model.board;

import java.util.ArrayList;
import com.snakeladder.model.entities.Ladder;
import com.snakeladder.model.entities.Snake;

public class Board {

	private int length;
	private int width;
	public Block[][] blocks;
	private ArrayList<ArrayList<Integer>> snakes;
	private ArrayList<ArrayList<Integer>> ladders;
	public Board(int length, int width, ArrayList<ArrayList<Integer>> snakes, ArrayList<ArrayList<Integer>> ladders) throws Exception {
		super();
		this.length = length;
		this.width = width;
		this.snakes = snakes;
		this.ladders = ladders;
		this.resetBoard();
	}
	
	private void resetBoard() throws Exception {
		this.blocks = new Block[this.length][this.width];
		int counter = 1;
		for(int i=0;i<length;i++) {
			for(int j=0;j<width;j++) {
				blocks[i][j]= new Block(i, j, counter);
				counter++;
			}
		}
		for(int i=0;i<snakes.size();i++) {
			Block startBlock = this.getBlockIndex(snakes.get(i).get(0));
			Block endBlock = this.getBlockIndex(snakes.get(i).get(1));
			addSnake(i, 1, startBlock, endBlock);
		}
		for(int i=0;i<ladders.size();i++) {
			Block startBlock = this.getBlockIndex(ladders.get(i).get(0));
			Block endBlock = this.getBlockIndex(ladders.get(i).get(1));
			addLadder(i, 1, startBlock, endBlock);
		}
		
	}
	
	private void addSnake(int i, int j, Block startBlock, Block endBlock) throws Exception{
		if(this.blocks[i][j].getEntity()!=null &&  this.blocks[i][j].getEntity() instanceof Snake && (this.blocks[i][j].getEntity().getStartBlock() == startBlock)) {
			throw new Exception("This block already contain snake or ladder");
		}
		if(this.blocks[i][j].getEntity()!=null &&  this.blocks[i][j].getEntity() instanceof Ladder && (this.blocks[i][j].getEntity().getStartBlock() == startBlock)) {
			throw new Exception("This block already contain snake or ladder");
		}
		
		Snake snake = new Snake(startBlock, endBlock);
		this.blocks[startBlock.getX()][startBlock.getY()].setEntity(snake);
	}
	
	private void addLadder(int i, int j, Block startBlock, Block endBlock) throws Exception{
		if(this.blocks[i][j].getEntity()!=null && this.blocks[i][j].getEntity() instanceof Snake && (this.blocks[i][j].getEntity().getStartBlock() == startBlock)) {
			throw new Exception("This block already contain snake");
		}
		if(this.blocks[i][j].getEntity()!=null &&  this.blocks[i][j].getEntity() instanceof Ladder && (this.blocks[i][j].getEntity().getStartBlock() == startBlock)) {
			throw new Exception("This block already contain ladder");
		}
		
		Ladder ladder = new Ladder(startBlock, endBlock);
		this.blocks[startBlock.getX()][startBlock.getY()].setEntity(ladder);
	}
	
	public Block getBlockIndex(int blockNumber) {
		for(int i=0;i<this.length;i++) {
			for(int j=0; j< this.width; j++) {
				if(this.blocks[i][j].getBlockNumber() == blockNumber)
					return blocks[i][j];
			}
		}
		return null;
	}
}
