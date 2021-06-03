package com.snake.and.ladder;

import java.util.Random;

public class Utility {
  static int getRandomNumber() {
    int min = 1;
    int max = 1000;
    return (int) (Math.random() * (max - min + 1) + min);
  }

  static int roll() {
    return new Random().nextInt(6) + 1;
  }
}
