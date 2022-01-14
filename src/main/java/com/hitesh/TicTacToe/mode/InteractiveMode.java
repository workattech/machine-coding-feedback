package com.hitesh.TicTacToe.mode;

import com.hitesh.TicTacToe.commands.ExitCommandExecutor;
import com.hitesh.TicTacToe.model.Command;
import com.hitesh.TicTacToe.model.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode{

    public InteractiveMode(Game game) {
        super(game);
    }

    @Override
    public void process() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String inputLine = reader.readLine();
            Command command = new Command(inputLine);
            if(command.getName().equals(ExitCommandExecutor.EXIT)){
                break;
            }
            processCommand(command);
            if(!game.isNotOver()){
                break;
            }
        }
    }
}
