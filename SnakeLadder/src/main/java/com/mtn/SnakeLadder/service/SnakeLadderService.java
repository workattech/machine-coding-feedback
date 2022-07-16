package com.mtn.SnakeLadder.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.mtn.SnakeLadder.constants.GameStatus;
import com.mtn.SnakeLadder.entity.BaseEntity;
import com.mtn.SnakeLadder.entity.Board;
import com.mtn.SnakeLadder.entity.CellPosition;
import com.mtn.SnakeLadder.entity.Dice;
import com.mtn.SnakeLadder.entity.Game;
import com.mtn.SnakeLadder.entity.Ladder;
import com.mtn.SnakeLadder.entity.Move;
import com.mtn.SnakeLadder.entity.Player;
import com.mtn.SnakeLadder.entity.Snake;

@Service
public class SnakeLadderService {

	private static final Logger logger = Logger.getLogger("MyLogger");
	private Map<String, Game> gameMap;
	private Map<CellPosition, Snake> snakeMap;
	private Map<CellPosition, Ladder> ladderMap;
	
	public Game add(List<Snake> snakes, List<Ladder> ladders, List<Player> players) {
		if(gameMap==null)
			gameMap = new HashMap<String, Game>();
		
		Game newGame = Game.builder()
				.id(UUID.randomUUID().toString())
				.gameStatus(GameStatus.STARTED)
				.board(new Board(UUID.randomUUID().toString()))
				.moves(new ArrayList<>())
				.players(players)
				.build();
		
		populateSnakesAndLadders(snakes, ladders);
		gameMap.put(newGame.getId(), newGame);
		return newGame;
	}

	private void populateSnakesAndLadders(List<Snake> snakes, List<Ladder> ladders) {
		if(snakeMap==null) {
			snakeMap = new HashMap<>();
		}
		if(ladderMap==null) {
			ladderMap = new HashMap<>();
		}
		
		snakes.forEach(snake -> {
			snakeMap.put(snake.getStart(), snake);
		});
		
		ladders.forEach(ladder -> {
			ladderMap.put(ladder.getStart(), ladder);
		});
	}

	public Player run(Game game) {
		
		int listSize = game.getPlayers().size();
		int index = 0;
		game.start();
		
		while(!game.getGameStatus().equals(GameStatus.ENDED)) {
			int currentPlayerIndex = index % listSize;
			Player currentPlayer = game.getPlayers().get(currentPlayerIndex);
			game.setCurrentPlayer(currentPlayer);
			
			CellPosition randomDiceNumber = Dice.getRandomNumber();
			Move move = movePlayer(game, randomDiceNumber);
			
			if(move!=null) {
				currentPlayer.setCurrentPosition(move.getEnd());
				logger.info(currentPlayer.getName()+ " rolled a "+ randomDiceNumber.getId()
				+ " and moved from "+ move.getStart().getId()+ " to "+ move.getEnd().getId());
			}
			else {
				logger.info(currentPlayer.getName()+"rolled a "+ randomDiceNumber.getId()
				+ " and remains at same position");
			}
			index++;
		}
		
		return game.getCurrentPlayer();
	}

	private Move movePlayer(Game game, CellPosition randomDiceNumber) {
		Player currentPlayer = game.getCurrentPlayer();
        CellPosition start = currentPlayer.getCurrentPosition();
        CellPosition end = new CellPosition(currentPlayer.getCurrentPosition().getId() +
                randomDiceNumber.getId());

        if(end.getId() > 100){
            return null;
        }

        Move currentMove = new Move(UUID.randomUUID().toString(), currentPlayer);
        currentMove.move(start, end);

        if(currentMove.getEnd().getId() == 100){
            game.end();
            return currentMove;
        }

        return snakeAndLadderMoves(game, currentMove);
	}

	private Move snakeAndLadderMoves(Game game, Move currentMove) {
		  while(snakeMap.containsKey(currentMove.getEnd()) ||
	                ladderMap.containsKey(currentMove.getEnd())){

	            BaseEntity entity;
	            if(snakeMap.containsKey(currentMove.getEnd())){
	                entity = snakeMap.get(currentMove.getEnd());
	            }
	            else{
	                entity = ladderMap.get(currentMove.getEnd());
	            }

	            currentMove.move(currentMove.getStart(), entity.getEnd());

	            if(currentMove.getEnd().getId() == 100){
	                game.end();
	                break;
	            }
	        }
	        return currentMove;
	}

}
