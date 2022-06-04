package com.hitesh.TicTacToe.commands;

import com.hitesh.TicTacToe.model.Command;
import com.hitesh.TicTacToe.model.Game;

public class ExitCommandExecutor extends CommandExecutor{

    public static final String EXIT = "exit";

    @Override
    public void execute(Command command, Game game) {

    }

    @Override
    public boolean validate(Command command) {
        return false;
    }
}
