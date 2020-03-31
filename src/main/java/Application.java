import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws Exception{


        Scanner sc = new Scanner(new File("/home/jigar/Desktop/mock-machine-coding-1/src/main/java/in.txt"));

        Board board = new Board(1,100);

        SnakesMap snakesMap = new SnakesMap(sc.nextInt());

        for(int i=0 ; i<snakesMap.getNumberOfSnakes() ; i++) {

            int head = sc.nextInt();
            int tail = sc.nextInt();

            snakesMap.addSnake(head,tail);
        }
        LaddersMap laddersMap = new LaddersMap(sc.nextInt());

        for(int i=0 ; i<laddersMap.getNumberOfLadders() ; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            laddersMap.addLadder(start,end);
        }

        int numberOfplayers = sc.nextInt();
        List<Player> players = new ArrayList<>();

        for(int i= 0 ;i<numberOfplayers ; i++){
            String playerName = sc.next();
            players.add(new Player(playerName,1));
        }

        List<Dice> dices = Arrays.asList(new Dice(1,6),new Dice(1,6));

        SnakeAndLadderGame game = new SnakeAndLadderGame(board,snakesMap,laddersMap,players,dices);

        List<String> logs = game.playAuto();


        logs.forEach(System.out::println);

        sc.close();


    }
}