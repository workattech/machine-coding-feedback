package Entities;

import java.util.Objects;
import java.util.Scanner;

public class InputService {

    public InputService(){
    }

    public void startGame(){
        ChessBoard chessgame = new ChessBoard();
        Player player = new Player(true);
        chessgame.showBoard();
        boolean isGameRunning=true;
        Scanner sc = new Scanner(System.in);
        while(isGameRunning){
            String start = sc.next();
            if(Objects.equals(start, "exit")){
                System.out.println("Game Over");
                break;
            }
            String end = sc.next();

            int startX = 8 - (start.charAt(1)-'0');
            int startY = start.charAt(0)-'a';
            int endX = 8 - (end.charAt(1)-'0');
            int endY = end.charAt(0)-'a';

            Peice p = chessgame.getPeice(startX,startY);
            if(p!=null &&  player.isWhite()==p.isWhite() && p.isValidMove(chessgame,startX,startY,endX,endY)) {
                chessgame.setPeice(endX, endY, p);
                chessgame.setPeice(startX, startY, null);
                chessgame.showBoard();
            }else{
                System.out.println("Invalid Move");
                continue;
            }
            // change the player
            player.switchPlayer();
        }
    }
}
