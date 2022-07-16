package entities;

import java.util.Arrays;

public class Board {

	int size = 101; 
	int[] board;
    int turn;
	
	public Board(){
		
		board = new int[this.size];	
		Arrays.fill(board, -1);
		}
	
	public Board(int size){
		
		this.size = size+1;
		board = new int[this.size];	
		Arrays.fill(board, -1);
	}
	
	public int[] getBoard() {
		
		return board;
		
	}
	
	public int getTurn() {return turn;}
	
	public void setTurn() {turn+=1;}
	
}
