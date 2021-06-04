package main.java.models;

import java.util.Random;

public class DiceRollService {
  static int noOfDices = 1;
  public static int roll() {
    return new Random().nextInt(noOfDices * 6) + 1;
  }

}
