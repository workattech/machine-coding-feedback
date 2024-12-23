package practice.snakes.and.ladders;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Game {

	List<Player> players;
	Board board;
	boolean gameCompleted;
	
	public Game() {
		players = new ArrayList<>();
		board = new Board();
		gameCompleted = false;
	}
	
	public void addPlayer(String name) {
		players.add(new Player(name, 0));
	}
	
	public void startGame() {
		
		board.addSnakesAndLadders();
		
		while (!gameCompleted) {
			
			for (Player player: players) {
				int diceRoll = (int)(Math.random() * 6) + 1;
				int initialPosition = player.getPosition();
				player.moveToPosition(board, diceRoll);
				System.out.println(player.getName() +" rolled a "+diceRoll+" and moved from "+initialPosition+" to "+player.getPosition());
				
				if (player.getPosition() == Board.BOARD_SIZE) {
					System.out.println(player.getName()+" wins the game");
					gameCompleted = true;
					break;
				}
			}
			
		}
	}

}
