package com.machine.coding.projects.service;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.machine.coding.projects.dto.Ladders;
import com.machine.coding.projects.dto.Person;
import com.machine.coding.projects.dto.Position;
import com.machine.coding.projects.dto.Snakes;

public class SnakeAndLadder extends AbstractGameService {

    private Ladders ladders;

    private Snakes snakes;

    private List<Person> persons;

    @Override
    public void initialize(Scanner sc) {
        System.out.println("In the init class");
        this.snakes = InitializeSnakes(sc);
        this.ladders = InitializeLadder(sc);
        this.persons = InitializePerson(sc);
    }

    @Override
    public void playGame() {

        while(true) {

            boolean endGame = false;

            for (int i=0; i < persons.size(); i++) {

                Random random = new Random();

                int rand_num = random.nextInt(6) + 1;

                Person person = persons.get(i);

                int newPosition = person.getPosition() + rand_num;

                if (newPosition == 100) {
                    super.setWinner(person.getName());
                    endGame = true;
                    System.out.println(person.toPrint(rand_num, newPosition));
                    break;
                }

                if (newPosition > 100)  {
                    System.out.println(person.getName()+ " is unable to make a move of " + rand_num + " from " + person.getPosition());
                    continue;
                }

                if (snakes.getPositions(newPosition) == -1) {
                    if (ladders.getPositions(newPosition) != -1) {
                        newPosition = ladders.getPositions(newPosition);
                    }
                } else {
                    newPosition = ladders.getPositions(newPosition);
                    if (ladders.getPositions(newPosition) != -1) {
                        newPosition = ladders.getPositions(newPosition);
                    }
                }

                if (newPosition == 100) {
                    super.setWinner(person.getName());
                    endGame = true;
                    System.out.println(person.toPrint(rand_num, newPosition));
                    break;
                }

                System.out.println(person.toPrint(rand_num, newPosition));

                persons.get(i).setPositions(newPosition);

            }

            if (endGame)    break;

        }

    }

    private static List<Person> InitializePerson(Scanner sc) {
        int num_person = sc.nextInt();
        List<Person> personList = new ArrayList<>();
        for (int i=0; i<num_person; i++) {
            String name = sc.next();
            Person person = new Person(name, 0);
            personList.add(person);
        }
        return personList;
    }

    private static Ladders InitializeLadder(Scanner sc) {
        Map<Integer, Integer> ladders = new HashMap<>();
        int num_ladders = sc.nextInt();
        for (int i=0; i<num_ladders; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            ladders.put(start, end);
        }
        return new Ladders(ladders);
    }

    private static Snakes InitializeSnakes(Scanner sc) {
        Map<Integer, Integer> snakes = new HashMap<>();
        int num_snakes = sc.nextInt();
        Set<Snakes> snakesSet = new HashSet<>();
        for (int i=0; i<num_snakes; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            snakes.put(start, end);
        }
        return new Snakes(snakes);
    }

}
