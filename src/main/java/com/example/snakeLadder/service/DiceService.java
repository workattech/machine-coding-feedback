package com.example.snakeLadder.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DiceService {

    public static int rollDice() {
        return new Random().nextInt(6) + 1;
    }
}
