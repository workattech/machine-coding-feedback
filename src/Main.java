import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        GameManager gameManager = new GameManager(new Game(new Board()));
        int i=0, snakes, start, end, ladder, players;
        String name;
        File file = new File("/home/saikat/IdeaProjects/mock-machine-coding-1/test/input.txt");
        Scanner sc = new Scanner(file);
        snakes = sc.nextInt();
        while(i<snakes) {
            start = sc.nextInt();
            end = sc.nextInt();
            gameManager.getGame().addSnakeToBoard(start,end);
            i++;
        }
        i=0;
        ladder = sc.nextInt();
        while (i<ladder) {
            start = sc.nextInt();
            end = sc.nextInt();
            gameManager.getGame().addLadderToBoard(start, end);
            i++;
        }
        i=0;
        players = sc.nextInt();
        while(i<players) {
            name = sc.next();
            gameManager.getGame().getBoard().addPlayerToGame(new Player(name));
            i++;
        }
        gameManager.play();
    }
}
