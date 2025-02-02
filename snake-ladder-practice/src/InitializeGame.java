import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class InitializeGame {
    
    Board board;
    Dice dice;
    Deque<Player> players = new LinkedList<>();
    Player winner;

    InitializeGame(){
        board = new Board(10);
        dice = new Dice();
        addPlayers();
        winner = null;
    }

    public void startGame(){
        while (winner == null) {
            Player currPlayer = players.peek();
            int diceNumber = dice.roll();
            int currPosition = currPlayer.position;
            int newPosition = getposition(currPosition, diceNumber);

            if(newPosition <= 100){
                System.out.println(currPlayer.name + " rolled a " +  diceNumber + " and moved from "+ currPosition + " to " + newPosition );
                if(newPosition == 100){
                    System.out.println(currPlayer.name + " wins the game");
                    winner = currPlayer;
                }
                currPlayer.position = newPosition;
            }
            else {
                System.out.println(currPlayer.name + " rolled a " +  diceNumber + " and stays there ");
            }
            changePlayers(players);
        }
    }

    private void changePlayers(Deque<Player> players){
        Player removeCurrPlayer = players.peek();
        players.pop();
        players.add(removeCurrPlayer);
    }

    private int getposition(int currPosition,int diceValue){

        int newPosition = currPosition + diceValue;
        if(newPosition > 100){
            return newPosition;
        }
        Cell cell = board.getCell(newPosition);

        if(cell.jump != null && cell.jump.start == newPosition){
            newPosition = cell.jump.end;
        }
        return newPosition;
    }

    private void addPlayers(){
        Scanner scanner = new Scanner(System.in); 
        try {
            int numberOfPlayers = scanner.nextInt();
            while (numberOfPlayers > 0) {
                players.add(new Player(scanner.next(),0));
                numberOfPlayers--;
            }
        }
        finally {
            scanner.close();
        }
    }
}
