package service;

import models.Board;

import java.io.IOException;

public class BoardService {

    public void initializeAndPlay() {
        Board board;

        // initialize the inputs
        InputService inputService = new InputService();
        try {
            board = inputService.readInputs();
        } catch (IOException io) {
            throw new RuntimeException();
        }

        PlayService playService = new PlayService(board);

        // play the match;
        playService.playMatch();
    }
}
