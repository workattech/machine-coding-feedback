package com.hitesh.TicTacToe.commands;

import com.hitesh.TicTacToe.model.Command;
import com.hitesh.TicTacToe.model.Game;
import com.hitesh.TicTacToe.model.Piece;
import com.hitesh.TicTacToe.model.Player;

import java.util.List;
import java.util.UUID;

public class AddPlayerCommandExecutor extends CommandExecutor{

    public static final String NAME = "add_player";

    @Override
    public void execute(Command command, Game game) {

        List<String> params = command.getParams();
        char piece = params.get(0).charAt(0);
        String playerName = params.get(1);

        Player player = new Player(UUID.randomUUID().toString(), playerName, new Piece(piece));
        game.getPlayerList().add(player);
    }

    @Override
    public boolean validate(Command command) {

        List<String> params = command.getParams();

        if(params.size()<2){
            throw new RuntimeException("Invalid input");
        }

        return true;
    }
}
