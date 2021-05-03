package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        String file = "src/com/company/input.txt";
        InputService inputService = InputService.getInstance();
        inputService.initializeArrays();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            Integer count = Integer.parseInt(reader.readLine());
            while (count-- > 0){
                Snake snake = new Snake();
                String[] arr = reader.readLine().split(" ");
                snake.setHead(Integer.parseInt(arr[0]));
                snake.setTail(Integer.parseInt(arr[1]));
                inputService.addSnake(snake);
            }

            count = Integer.parseInt(reader.readLine());
            while (count-- > 0){
                Ladder ladder = new Ladder();
                String[] arr = reader.readLine().split(" ");
                ladder.setStart(Integer.parseInt(arr[0]));
                ladder.setEnd(Integer.parseInt(arr[1]));
                inputService.addLadder(ladder);
            }

            count = Integer.parseInt(reader.readLine());
            while (count-- > 0){
                inputService.addPlayer(reader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        InputMappingService inputMappingService = new InputMappingService(inputService);
        inputMappingService.setSnakes();
        inputMappingService.setLadders();

//        System.out.println("Snakes are -> " + inputMappingService.getSnakes());
//        System.out.println("Ladders are -> " + inputMappingService.getLadders());
//        System.out.println("Players are -> " + inputService.getPlayers());

        GamingService gamingService = new GamingService(inputMappingService);
        gamingService.playGame();
    }
}
