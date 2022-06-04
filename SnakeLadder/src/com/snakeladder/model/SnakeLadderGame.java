package com.snakeladder.model;
import java.util.ArrayList;
import java.util.List;
import com.snakeladder.model.board.Block;
import com.snakeladder.model.board.Board;
import com.snakeladder.model.entities.Ladder;
import com.snakeladder.model.entities.Snake;

public class SnakeLadderGame {
	private Board board;
	private ArrayList<Player> players;
	private Player currentTurnPlayer;
	private ArrayList<Move> moves;
	public SnakeLadderGame() {
		// TODO Auto-generated constructor stub
	}
	
	public void initialize(ArrayList<String> player, ArrayList<ArrayList<Integer>> snakes, ArrayList<ArrayList<Integer>> ladders) throws Exception {
		this.board = new Board(10, 10, snakes, ladders);
		this.players = new ArrayList<Player>();
		this.moves = new ArrayList<Move>();
		for(int i=0;i<player.size();i++) {
			Player p = new Player(player.get(i), null);
			players.add(p);
		}
		currentTurnPlayer = players.get(0);
	}
	
	public void start() {
		int i=0;
		boolean flag = true;
		int n = players.size();
		while(flag) {
			currentTurnPlayer = this.players.get(i);
			flag = rollDice(currentTurnPlayer);
			i++;
			i=i%n;
		}
	}
	
	public boolean rollDice(Player player) {
		Dice dice = new Dice();
		int number = dice.roll();
		Block updatedBlock;
		
		Block startBlock = player.getCurrentBlock();
		if (startBlock==null) {
			updatedBlock = this.board.getBlockIndex(number);
		}
		else {
			int newNumber = number+startBlock.getBlockNumber();
			if(newNumber>100)
					return true;
			updatedBlock = this.board.getBlockIndex(newNumber);
		}
		if(updatedBlock!=null && updatedBlock.getEntity() != null && updatedBlock.getEntity() instanceof Snake) {
			updatedBlock = updatedBlock.getEntity().getStartBlock();
		}
		
		else if(updatedBlock!=null && updatedBlock.getEntity() != null && updatedBlock.getEntity() instanceof Ladder) {
			updatedBlock = updatedBlock.getEntity().getEndBlock();
		}

		player.setCurrentBlock(updatedBlock);
		Move move = new Move(number, startBlock, updatedBlock, player);
		moves.add(move);
		if(isWinner(player)) {
			System.out.println(player.getName()+" wins the game.");
			return false;
		}
		if(startBlock==null)
			System.out.println(player.getName()+" rolled a " + number + " and moved from 0 to "+ updatedBlock.getBlockNumber());
		else {
			System.out.println(player.getName()+" rolled a " + number + " and moved from "+ startBlock.getBlockNumber() + " to "+ updatedBlock.getBlockNumber());
		}
		return true;
	}
	
	private boolean isWinner(Player player) {
		Block currentBlock = player.getCurrentBlock();
		if(currentBlock!=null && currentBlock.getBlockNumber() == 100)
			return true;
		return false;
	}
}
