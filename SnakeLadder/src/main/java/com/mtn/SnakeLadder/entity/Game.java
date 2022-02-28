package com.mtn.SnakeLadder.entity;

import java.util.List;

import com.mtn.SnakeLadder.constants.GameStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Builder
public class Game {
	
	private String id;
    private Board board;
    @Setter private Player currentPlayer;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;

    public void start() {
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public void end() {
        this.gameStatus = GameStatus.ENDED;
    }
	
}
