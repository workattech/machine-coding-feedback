package main.java.models;

import java.util.Scanner;

public class GameDriver {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        GameService service = new GameService();
        int size = scanner.nextInt();
        service.initialize(size);
        service.printValues();
        while(true){
            int direction = scanner.nextInt();
            service.startGame(direction);
            if(service.hasWon()) {
                System.out.println("Congratulations");
                break;
            }
            else{
                if(service.isGameOver()){
                    System.out.println("Game Over");
                    break;
                }
            }
        }
    }
}
