package com.hitesh.TicTacToe;

import com.hitesh.TicTacToe.mode.FileMode;
import com.hitesh.TicTacToe.mode.Mode;
import com.hitesh.TicTacToe.model.Game;
import com.hitesh.TicTacToe.mode.InteractiveMode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.UUID;


@SpringBootApplication
public class TicTacToeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TicTacToeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Game newGame = new Game(UUID.randomUUID().toString(), new ArrayList<>(), null);
		Mode mode;
		if(args.length == 0){
			mode = new InteractiveMode(newGame);
		}
		else{
			mode = new FileMode(newGame, args[0]);
		}
		mode.process();

		if(newGame.isWin()){
			System.out.println(newGame.getCurrentPlayer().getName() + " won the game");
		}
		else{
			System.out.println("Game Over");
		}
	}
}
