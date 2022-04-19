import java.util.*;

import Models.*;
import Services.SnakeAndLadderGameService;

public class Driver {
    public static void main(String args[]) {
        int noOfSnakes, noOfLadders, noOfPlayers, noOfDices, boardSize;
        ArrayList<Snake> snakes = new ArrayList<Snake>();
        ArrayList<Ladder> ladders = new ArrayList<Ladder>();
        Queue<Player> players = new ArrayDeque<Player>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of dices to use in game");
        noOfDices = sc.nextInt();

        System.out.println("Enter board size");
        boardSize = sc.nextInt();

        System.out.println("Enter Number of Snakes");
        noOfSnakes = sc.nextInt();
        System.out.println("Enter Position of head and tail of " + noOfSnakes + " Snakes");
        for(int i = 0; i < noOfSnakes; i++) {
            int head, tail;
            head = sc.nextInt();
            tail = sc.nextInt();
            snakes.add(new Snake(head, tail));
        }

        System.out.println("Enter Number of Ladders");
        noOfLadders = sc.nextInt();
        System.out.println("Enter Position of start and end of " + noOfLadders + " Ladders");
        for(int i = 0; i < noOfLadders; i++) {
            int start, end;
            start = sc.nextInt();
            end = sc.nextInt();
            ladders.add(new Ladder(start, end));
        }

        System.out.println("Enter Number of Players");
        noOfPlayers = sc.nextInt();
        System.out.println("Enter Names of " + noOfPlayers + " Players");
        for(int i = 0; i < noOfPlayers; i++) {
            System.out.println("Enter Player Name: ");
            String name;
            name = sc.next();
            players.add(new Player(name));
        }

        Board board = new Board(boardSize, snakes, ladders);
        SnakeAndLadderGameService gameService = new SnakeAndLadderGameService(noOfPlayers, noOfDices, board, players);

        System.out.println("Do you want to end game after getting first winner: Yes/No");
        while(true) {
            String endGameAfterFirstWinner;
            endGameAfterFirstWinner = sc.nextLine();
            if(endGameAfterFirstWinner.equalsIgnoreCase("YES")) {
                gameService.setEndGameAfterFirstWinner(true);
                break;
            }
            else if(endGameAfterFirstWinner.equalsIgnoreCase("NO")) {
                gameService.setEndGameAfterFirstWinner(false);
                break;
            }
            else {
                System.out.println("Please Enter 'Yes' or 'No'");
            }
        }

        Queue<Player> leaderBoard = gameService.startGame();
        System.out.println("------------Leader Board------------");
        while(leaderBoard.size() != 0) {
            Player p = leaderBoard.poll();
            System.out.println(p.getStatus() + "-----" + p.getName() + "----" + p.getRank() + "-----" + p.getPosition() + "-----");
        }
        return;
    }
}

//9
//62 5
//33 6
//49 9
//88 16
//41 20
//56 53
//98 64
//93 73
//95 75
//8
//2 37
//27 46
//10 32
//51 68
//61 79
//65 84
//71 91
//81 100
//2
//Gaurav
//Sagar