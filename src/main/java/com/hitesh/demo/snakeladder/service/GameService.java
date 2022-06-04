package com.hitesh.demo.snakeladder.service;

import com.hitesh.demo.snakeladder.constant.GameStatus;
import com.hitesh.demo.snakeladder.entity.*;
import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    private Map<String, Game> gameMap;
    private Map<CellPosition,Snake> snakeMap;
    private Map<CellPosition,Ladder> ladderMap;

    private void populateSnakesAndLadders(List<Snake> snakeList, List<Ladder> ladderList) {

        if(snakeMap == null){
            snakeMap = new HashMap<>();
        }
        if(ladderMap == null){
            ladderMap = new HashMap<>();
        }

        snakeList.forEach(snake -> {
            snakeMap.put(snake.getStart(), snake);
        });

        ladderList.forEach(ladder -> {
            ladderMap.put(ladder.getStart(), ladder);
        });
    }

    public Game add(@NotNull final List<Snake> snakeList, @NotNull final List<Ladder> ladderList,
                           @NotNull final  List<Player> playerList)
    {
        if(gameMap == null){
            gameMap = new HashMap<>();
        }

        Game newGame = Game.builder()
                .id(UUID.randomUUID().toString())
                .gameStatus(GameStatus.STARTED)
                .board(new Board(UUID.randomUUID().toString()))
                .moves(new ArrayList<>())
                .players(playerList)
                .build();

        populateSnakesAndLadders(snakeList,ladderList);
        gameMap.put(newGame.getId(),newGame);

        return newGame;
    }

    public Player run(@NotNull final Game game){

        int listSize = game.getPlayers().size();
        int index = 0;
        game.start();

        while(!game.getGameStatus().equals(GameStatus.ENDED)){

            int currentPlayerIndex = index % listSize;
            Player currentPlayer = game.getPlayers().get(currentPlayerIndex);
            game.setCurrentPlayer(currentPlayer);

            CellPosition randomDiceNumber = Dice.getRandomNumber();
            Move move = movePlayer(game, randomDiceNumber);

            if(move != null){
                currentPlayer.setCurrentPosition(move.getEnd());
                System.out.println(currentPlayer.getName() + " rolled a " + randomDiceNumber.getId()
                        + " and moved from " + move.getStart().getId() + " to "+ move.getEnd().getId());

                game.getMoves().add(move);
            }
            else{
                System.out.println(currentPlayer.getName() +
                        " rolled a " + randomDiceNumber.getId()
                        + " and remains at same position");
            }

            index++;
        }

        return game.getCurrentPlayer();
    }

    private Move movePlayer(Game game, CellPosition randomDiceNumber){

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

