package practice.snakes.and.ladders;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ladder {

	int start, end;
	
	public int newPositionAfterLadderJump() {
		return end;
	}
}
