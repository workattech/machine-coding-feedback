package com.hitesh.TicTacToe.commands;

import com.hitesh.TicTacToe.model.Command;
import com.hitesh.TicTacToe.model.Game;

public abstract class CommandExecutor {

    public abstract void execute(Command command, Game game);

    public abstract boolean validate(Command command);

}
