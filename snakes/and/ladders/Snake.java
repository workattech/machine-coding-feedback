package practice.snakes.and.ladders;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Snake {
	
	private int head, tail;
	
	public int newPositionAfterSnakeBite() {
		return tail;
	}

}
