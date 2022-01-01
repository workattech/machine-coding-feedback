import controller.GameController;
import models.Game;
import models.GameStatus;
import models.Player;
import models.Value;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Player player = new Player("player1");
		GameController gameController = new GameController();

		gameController.startGame(player);
	}
}
