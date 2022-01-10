package com.hitesh.demo.snakeladder.controller;

import com.hitesh.demo.snakeladder.entity.Game;
import com.hitesh.demo.snakeladder.entity.Ladder;
import com.hitesh.demo.snakeladder.entity.Player;
import com.hitesh.demo.snakeladder.entity.Snake;
import com.hitesh.demo.snakeladder.service.GameService;
import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    public Game add(@NotNull final List<Snake> snakeList, @NotNull final List<Ladder> ladderList,
                    @NotNull final  List<Player> playerList){

        return gameService.add(snakeList, ladderList, playerList);
    }

    public Player run(@NotNull final Game game){
        return gameService.run(game);
    }


}
