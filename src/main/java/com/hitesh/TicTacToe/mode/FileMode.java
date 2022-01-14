package com.hitesh.TicTacToe.mode;

import com.hitesh.TicTacToe.model.Command;
import com.hitesh.TicTacToe.model.Game;

import java.io.*;

public class FileMode extends Mode{

    private String fileName;

    public FileMode(Game game, String fileName) {
        super(game);
        this.fileName = fileName;
    }

    @Override
    public void process() throws IOException {

        final File file = new File(fileName);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        String input = reader.readLine();
        while (input != null) {
            final Command command = new Command(input);
            processCommand(command);
            input = reader.readLine();
        }
    }

}
