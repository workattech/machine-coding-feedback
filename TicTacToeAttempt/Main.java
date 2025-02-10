import Entities.*;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();
        Game game = new Game(row,col);
        game.InitialiseGrid(row,col);
        int players  = sc.nextInt();
        for(int i=1;i<=players;i++){
            String peiceType = sc.next();
            String  name = sc.next();
            game.getGrid().addPlayer(new Player(name,new Peice(peiceType)));
        }

        // Print the grid
        game.printGrid(row,col);


        boolean isChance=true;
        while(isChance){
            for(int i=0;i<players;i++){
                Player p = game.getGrid().getPlayers().get(i);
                String r = sc.next();
                if(Objects.equals(r, "exit")){
                    isChance=false;
                    continue;
                }
                String q = sc.next();
                int rowNo = Integer.parseInt(r)-1;
                int colNo = Integer.parseInt(q)-1;

                if(game.getGrid().getboard(rowNo,colNo)=='-')
                    game.getGrid().changeBoard(rowNo,colNo,p);
                else{
                    System.out.println("Invalid Move Retry");
                    i--;
                }

                // print
                game.printGrid(row,col);

                // Check if the game is finished
                boolean isGameFinished = game.gridCheck(rowNo,colNo,row,col,p.getPeice());
                if(isGameFinished){
                    System.out.println(p.getName() + " Wins");
                    isChance=false;
                    break;
                }

                boolean isSpaceLeft = game.spaceCheck(row,col);
                if(isSpaceLeft)continue;
                else{
                    System.out.println("Game Finished and it's a tie");
                    isChance=false;
                    break;
                }
            }
        }

    }
}