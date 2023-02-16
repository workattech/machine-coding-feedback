package io.shaeli.machinecoding.snakeandladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import io.shaeli.machinecoding.snakeandladder.models.BoardDimension;
import io.shaeli.machinecoding.snakeandladder.models.EntityType;
import io.shaeli.machinecoding.snakeandladder.models.Ladder;
import io.shaeli.machinecoding.snakeandladder.models.Player;
import io.shaeli.machinecoding.snakeandladder.models.Snake;
import io.shaeli.machinecoding.snakeandladder.models.SpecialEntity;

public class InputLoader {

    private static final Scanner scanner = new Scanner(System.in);

    public InputLoader() {

    }

    public BoardDimension getBoardSize() {
        System.out.println("Enter board dimension. row col\n E.g 10 10");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new BoardDimension(row, col);
    }

    public List<SpecialEntity> getSpecialEntity(EntityType type) {
        List<SpecialEntity> entities = new ArrayList<>();
        System.out.println("Enter number of " + type.name() + " : ");
        int numEntities = scanner.nextInt();

        for(int i=0; i<numEntities; i++) {
            System.out.println("Enter start and end of " + type.name());
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if(type == EntityType.SNAKE) {
                entities.add(new Snake(start, end));
            } else {
                entities.add(new Ladder(start, end));
            }
        }

        return entities;
    }

    public Player getPlayer() {
        System.out.println("Enter player name : ");
        String name = scanner.next();

        return new Player(name);

    }

}
