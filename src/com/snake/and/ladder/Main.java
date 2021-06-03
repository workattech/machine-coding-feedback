package com.snake.and.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TakeInputs();
    }
    public static void TakeInputs(){
        List<Snakes> snakes;
        List<Ladders> ladders;
        List<Players> people;
        int start, end;
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of snakes: ");
        int numberOfSnakes = sc.nextInt();
        snakes = new ArrayList<>(numberOfSnakes);
        System.out.println("Enter " + numberOfSnakes + " snakes staring and end points: ");
        for (int i = 0; i < numberOfSnakes; i++) {
            start = sc.nextInt();
            end = sc.nextInt();
            if (start <= end) {
                System.out.println("start point must be greater than end");
                sc.close();
                return;
            }
            snakes.add(new Snakes(start, end));
        }
        System.out.println("Enter number of ladders: ");
        int numberOfLadders = sc.nextInt();
        ladders = new ArrayList<>(numberOfLadders);
        System.out.println("Enter " + numberOfLadders + " ladders staring and end points: ");
        for (int i = 0; i < numberOfLadders; i++) {
            start = sc.nextInt();
            end = sc.nextInt();
            if (start >= end) {
                System.out.println("start point must be less than end");
                sc.close();
                return;
            }
            ladders.add(new Ladders(start, end));
        }
        System.out.println("Enter number of person: ");
        int numberOfPerson = sc.nextInt();
        if (numberOfPerson <= 1) {
            System.out.println("please add more than one person to the game");
            sc.close();
            return;
        }
        System.out.println("Enter "+numberOfPerson+" person names: ");
        people = new ArrayList<>(numberOfPerson);
        for (int i = 0; i < numberOfPerson; i++) {
            name = sc.next();
            people.add(new Players(name));
        }
        sc.close();
        var game = new Game();
        game.initialize(people,snakes,ladders);
    }
}












