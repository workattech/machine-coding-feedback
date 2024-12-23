package practice.snakes.and.ladders;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
	
	String name;
	int position;
	
	public boolean moveToPosition(Board board, int diceRoll) {
		
		int newPosition = position + diceRoll;
		
		if (newPosition > Board.BOARD_SIZE) return false;
		
		
		Cell newCell = board.getCells().get(newPosition);
		
		while (newCell.getSnake() != null || newCell.getLadder() != null) {
			newPosition = newCell.getSnake() != null ? newCell.getSnake().newPositionAfterSnakeBite(): newCell.getLadder().newPositionAfterLadderJump();
			newCell = board.getCells().get(newPosition);
		}
		
		this.position = newPosition;
		return true;
		
	}

	
}
