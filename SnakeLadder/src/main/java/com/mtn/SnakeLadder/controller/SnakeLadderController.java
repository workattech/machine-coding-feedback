package com.mtn.SnakeLadder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtn.SnakeLadder.entity.Game;
import com.mtn.SnakeLadder.entity.Ladder;
import com.mtn.SnakeLadder.entity.Player;
import com.mtn.SnakeLadder.entity.Snake;
import com.mtn.SnakeLadder.service.SnakeLadderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SnakeLadderController {

	private final SnakeLadderService snakeLadderService;
	
	public Game add(List<Snake> snakes, List<Ladder> ladders, List<Player> players) {
		return snakeLadderService.add(snakes, ladders, players);
	}

	public Player run(Game game) {
		return snakeLadderService.run(game);
	}
}
