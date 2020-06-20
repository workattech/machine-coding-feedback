package com.games.snakesandladders.props;

import java.util.Random;

public class Dice {
  private final static int SIDES = 6;
  private final static Random random = new Random();

  public static int roll() {
    return random.nextInt(SIDES) + 1;
  }
}
