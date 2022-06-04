package com.hitesh.TicTacToe.mode;

import com.hitesh.TicTacToe.commands.CommandExecutor;
import com.hitesh.TicTacToe.commands.CommandExecutorFactory;
import com.hitesh.TicTacToe.model.Command;
import com.hitesh.TicTacToe.model.Game;
import lombok.AllArgsConstructor;

import java.io.IOException;

@AllArgsConstructor
public abstract class Mode {

    protected Game game;

    public abstract void process() throws IOException;

    protected void processCommand(Command command){
        CommandExecutor commandExecutor = CommandExecutorFactory.getCommandExecutor(command);
        if(commandExecutor.validate(command)){
            commandExecutor.execute(command, game);
        }
    }

}
