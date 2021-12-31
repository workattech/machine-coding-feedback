import models.Game;
import models.GameStatus;
import models.Player;
import models.Value;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Player player = new Player("player1");
		Game game = new Game(player, 4);
		Scanner playerInput = new Scanner(System.in);
		System.out.println("What base number do you want to play with? ");
		Value.baseNumber = playerInput.nextInt();
		System.out.println("What maximum power of " + Value.baseNumber + " is needed to win the game? ");
		Value.maxPower = playerInput.nextInt();
		game.getBoard().printBoard();

		playerInput.nextLine();
		while(game.getStatus() == GameStatus.ACTIVE) {
			String currentTurnInput = playerInput.nextLine();
			game.makeGameTurn(currentTurnInput);
			game.getBoard().printBoard();
			if(game.getStatus() != GameStatus.ACTIVE) {
				if(game.getStatus() == GameStatus.WON) {
					System.out.println(player.getName() + " has won the game.");
					break;
				}
				System.out.println(player.getName() + " has lost the game.");
				break;
			}
		}
	}
}
