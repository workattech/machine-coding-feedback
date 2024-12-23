package practice.snakes.and.ladders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cell {

	private Snake snake;
	private Ladder ladder;
}
