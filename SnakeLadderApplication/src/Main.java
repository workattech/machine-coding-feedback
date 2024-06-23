import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = Game.getInstance(10,10,1);
        Scanner scanner = new Scanner(System.in);
        int snakes = scanner.nextInt();
        scanner.nextLine();
        Game.setSnakes(snakes);
        for(int i = 0; i< Game.getSnakes(); i++) {
            String[] snakePosition = scanner.nextLine().split(" ");
            int pos1 = Integer.parseInt(snakePosition[0]);
            int pos2 = Integer.parseInt(snakePosition[1]);
            game.getBoard().getSnakeMap().put(pos1,pos2);
        }
        int ladders = scanner.nextInt();
        scanner.nextLine();
        Game.setLadders(ladders);
        for(int i = 0; i< Game.getLadders(); i++) {
            String[] ladderPosition = scanner.nextLine().split(" ");
            int pos1 = Integer.parseInt(ladderPosition[0]);
            int pos2 = Integer.parseInt(ladderPosition[1]);
            game.getBoard().getLaddersMap().put(pos1,pos2);
        }
        int players = scanner.nextInt();
        scanner.nextLine();
        for(int  i = 0;i<players;i++) {
            String playerName = scanner.nextLine();
            game.getPlayersList().add(new Player(playerName));
        }
        scanner.close();
        game.start();
    }
}