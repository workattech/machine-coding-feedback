package com.machine.coding.projects.service;

import java.util.Scanner;

public interface GameService {

    void initialize(Scanner sc);

    void playGame();

    String getWinner();

}
