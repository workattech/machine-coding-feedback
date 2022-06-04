package com.hitesh.TicTacToe.commands;

import com.hitesh.TicTacToe.model.Command;
import com.hitesh.TicTacToe.model.Game;

public class MoveCommandExecutor extends CommandExecutor{

    public static final String MOVE = "move";

    @Override
    public void execute(Command command, Game game) {

        int x = Integer.parseInt(command.getParams().get(0));
        int y = Integer.parseInt(command.getParams().get(1));

        game.processMove(x-1,y-1);

    }

    @Override
    public boolean validate(Command command) {
        return true;
    }
}
