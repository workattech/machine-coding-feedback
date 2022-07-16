package services;
import entities.Board;
import exceptions.InvalidInputException;

public class BoardService {

	public void addSnakeOrLadder(int x, int y, Board b) throws InvalidInputException{
		
		if(x<0 || x>100 || y<0 || y>100) { throw new InvalidInputException(" The input is not valid "); }
		
		b.getBoard()[x] = y;
		b.setTurn();
	}
	
	public int playerPosition(int position, Board b){
		
		while(b.getBoard()[position]!=-1) {
			
			position = b.getBoard()[position];
			
		}
		
		return position;
	}
	
}
