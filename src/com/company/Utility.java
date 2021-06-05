package com.company;

public class Utility {
  static int getRandomNumber() {
    int min = 1;
    int max = 1000;
    return (int) (Math.random() * (max - min + 1) + min);
  }
}
