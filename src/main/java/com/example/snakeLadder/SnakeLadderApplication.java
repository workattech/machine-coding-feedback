package com.example.snakeLadder;

import com.example.snakeLadder.model.Board;
import com.example.snakeLadder.model.Ladder;
import com.example.snakeLadder.model.Player;
import com.example.snakeLadder.model.Snake;
import com.example.snakeLadder.service.StartGame;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class SnakeLadderApplication {
    public static void main(String[] args) throws Exception {
        int snakeNumbers = 9;

        List<Snake> snakeList = new ArrayList<>();

        snakeList.add(new Snake(62, 5));
        snakeList.add(new Snake(33, 6));
        snakeList.add(new Snake(49, 9));
        snakeList.add(new Snake(88, 16));
        snakeList.add(new Snake(41, 20));
        snakeList.add(new Snake(56, 53));
        snakeList.add(new Snake(98, 64));
        snakeList.add(new Snake(93, 73));
        snakeList.add(new Snake(95, 75));

        int ladderNumbers = 8;

        List<Ladder> ladderList = new ArrayList<>();

        ladderList.add(new Ladder(2, 37));
        ladderList.add(new Ladder(27, 46));
        ladderList.add(new Ladder(10, 32));
        ladderList.add(new Ladder(51, 68));
        ladderList.add(new Ladder(61, 79));
        ladderList.add(new Ladder(65, 84));
        ladderList.add(new Ladder(71, 91));
        ladderList.add(new Ladder(81, 100));

        int playersNumber = 3;

        HashMap<Integer, Integer> playerPos = new HashMap<>();
        LinkedList<Player> playersList = new LinkedList<>();
        playersList.add(new Player(101, "Gaurav"));
        playersList.add(new Player(102, "Sagar"));
        playersList.add(new Player(103, "Mayank"));

        for (int i = 0; i < playersNumber; i++) {
            playerPos.put(playersList.get(i).getId(), 0);
        }
        int size = 100;

        Board snakeLadderBoard = new Board(size, ladderList, snakeList, playerPos);

        StartGame s = new StartGame(snakeLadderBoard, playersList);
        s.run();

    }

}
