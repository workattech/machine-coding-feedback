package com.snake.and.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

  private List<Snake> snake;
  private List<Ladder> ladder;
  private List<Person> person;

  public void TakeInput() {
    int start, end;
    String name;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of snakes: ");
    int numberOfSnakes = sc.nextInt();
    snake = new ArrayList<>(numberOfSnakes);
    System.out.println("Enter " + numberOfSnakes + " snakes staring and end points: ");
    for (int i = 0; i < numberOfSnakes; i++) {
      start = sc.nextInt();
      end = sc.nextInt();
      if (start <= end) {
        System.out.println("start point must be greater than end");
        sc.close();
        return;
      }
      snake.add(new Snake(start, end));
    }
    System.out.println("Enter number of ladders: ");
    int numberOfLadders = sc.nextInt();
    ladder = new ArrayList<>(numberOfLadders);
    System.out.println("Enter " + numberOfLadders + " ladders staring and end points: ");
    for (int i = 0; i < numberOfLadders; i++) {
      start = sc.nextInt();
      end = sc.nextInt();
      if (start >= end) {
        System.out.println("start point must be less than end");
        sc.close();
        return;
      }
      ladder.add(new Ladder(start, end));
    }
    System.out.println("Enter number of person: ");
    int numberOfPerson = sc.nextInt();
    if (numberOfPerson <= 1) {
      System.out.println("please add more than one person to the game");
      sc.close();
      return;
    }
    System.out.println("Enter "+numberOfPerson+" person names: ");
    person = new ArrayList<>(numberOfPerson);
    for (int i = 0; i < numberOfPerson; i++) {
      name = sc.next();
      person.add(new Person(name));
    }
    sc.close();
    initialize();
  }

  public void initialize() {
    boolean isEndTheGame = false;
    int move = 0;
    boolean moved = false;
    // bool status=false;
    while (true) {
      if (isEndTheGame) {
        for (Person person : this.person) {
          if (person.getPosition() >= 100) {
            System.out.println(person.getName() + " wins the game");
          }
        }
        break;
      }
      // person.forEach((i)-> System.out.println(i.getName()));
      int roll = 0;
      for (Person person : this.person) {

        roll = Utility.roll();
        // check if there is snake
        for (Snake snake : this.snake) {
          if (snake.getStart() == roll) {
            move = person.getPosition() - roll;
            moved = true;
            break;
          }
        }
        // check if there is a ladder
        for (Ladder ladder : this.ladder) {
          if (ladder.getStart() == roll) {
            move = person.getPosition() + roll;
            moved = true;
            break;
          }
        }
        // if there is no snake or ladder
        if (!moved) {
          move = person.getPosition() + roll;
        }
        System.out.println(
            person.getName() + " rolled a " + roll + " and moved from " + person.getPosition()
                + " to " + move);
        person.setPosition(move);
        moved = false;
        if (person.getPosition() >= 100) {
          isEndTheGame = true;
          break;
        }

      }
    }
  }

}
