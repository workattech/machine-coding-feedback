
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SnakeLadderApplication  {
    public static void main(String []args){

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            Integer snakes = Integer.parseInt( reader.readLine() );
            List<Snake > snakesList = new ArrayList<>();
            for(int i = 0 ; i < snakes ; i++ ) {
                String line =  reader.readLine();
                String []coord = line.split(" ");
                snakesList.add(new Snake(Integer.parseInt(coord[0]), Integer.parseInt(coord[1]) ));
            }

            Integer ladders = Integer.parseInt( reader.readLine() );
            List<Ladder > ladderList = new ArrayList<>();
            for(int i = 0 ; i < ladders ; i++ ) {
                String line =  reader.readLine();
                String []coord = line.split(" ");
                ladderList.add(new Ladder(Integer.parseInt(coord[0]), Integer.parseInt(coord[1]) ));
            }

            Integer players = Integer.parseInt( reader.readLine() );
            List<Player > playersList = new ArrayList<>();
            for(int i = 0 ; i < players ; i++ ) {
                String name =  reader.readLine();
                playersList.add(new Player(name ,1 ));
            }

            Board board = new Board(snakesList , ladderList);

            Boolean isGameOver = false;

            int playersTurn = 0;

            while (!isGameOver){
                Player currentPlayer = playersList.get(playersTurn++);


                if(playersTurn >= playersList.size())playersTurn = 0;

                System.out.println("Player " + currentPlayer.getName() + " please roll the dice by pressing 1\n");
                reader.readLine();
                Integer number  =  Dice.rollTheDice();

                System.out.println("Dice value is " + number);
                currentPlayer.makeMove(number , board);
                System.out.println("current position is  " + currentPlayer.getPosition());
                if(currentPlayer.getPosition() == 100 ){
                    isGameOver = true;
                    System.out.println("Player won " + currentPlayer.getName());
                }
            }

        }catch (Exception e){
            System.out.println("Error in reading input " + e.getMessage());
        }
    }
}
