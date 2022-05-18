import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        SnakeLadderManager snakeLadderManager = new SnakeLadderManager();
        File file = new File("/Users/varsha.lalwani/personal/mock-machine-coding-2/snake-ladder/resources/input.txt");
        Scanner scanner = new Scanner(file);
        String command = scanner.nextLine();
        Integer numOfSnakes = Integer.valueOf(command);
        for (int i=0; i<numOfSnakes; i++) {
            command = scanner.nextLine();
            String[] commands = command.split(" ");
            snakeLadderManager.addSnake(Integer.valueOf(commands[0]),
                    Integer.valueOf(commands[1]));
        }
        command = scanner.nextLine();
        Integer numOfLadder = Integer.valueOf(command);
        for (int i=0; i<numOfLadder; i++) {
            command = scanner.nextLine();
            String[] commands = command.split(" ");
            snakeLadderManager.addLadder(Integer.valueOf(commands[0]),
                    Integer.valueOf(commands[1]));
        }
        command = scanner.nextLine();
        Integer numOfUsers = Integer.valueOf(command);
        for (int i=0; i<numOfUsers; i++) {
            command = scanner.nextLine();
            snakeLadderManager.addUser(command);
        }
        snakeLadderManager.playGame();
    }
}
