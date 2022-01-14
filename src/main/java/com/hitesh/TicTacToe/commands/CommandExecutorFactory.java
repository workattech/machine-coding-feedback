package com.hitesh.TicTacToe.commands;

import com.hitesh.TicTacToe.model.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {

    private static final Map<String,CommandExecutor> commands = new HashMap<>();

    static {
        commands.put(AddPlayerCommandExecutor.NAME, new AddPlayerCommandExecutor());
        commands.put(MoveCommandExecutor.MOVE, new MoveCommandExecutor());
        commands.put(ExitCommandExecutor.EXIT, new ExitCommandExecutor());
    }

    public static CommandExecutor getCommandExecutor(Command command){

        if(!commands.containsKey(command.getName())){
            throw new RuntimeException("Invalid Command");
        }

        return commands.get(command.getName());
    }

}
