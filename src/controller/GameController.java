package controller;

import models.Game;
import models.GameStatus;
import models.Player;
import models.Value;
import service.GameService;

import java.util.Scanner;

public class GameController {
	public void startGame(Player player) {
		GameService gameService = new GameService();
		gameService.startGame(player);
	}


}
