import java.util.*;
public class SnakeLadderTestDrive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int snakes = sc.nextInt();
		ArrayList<Dynamics> snakeList = new ArrayList<Dynamics>();
		while (snakes-- > 0) {
			String startEndLocations = sc.next();
			String [] locations = startEndLocations.split(",");
			snakeList.add(new Snake(Integer.parseInt(locations[0]), Integer.parseInt(locations[1])));
		}
		
		int ladders = sc.nextInt();
		ArrayList<Dynamics> ladderList = new ArrayList<Dynamics>();
		while (ladders-- > 0) {
			String startEndLocations = sc.next();
			String [] locations = startEndLocations.split(",");
			ladderList.add(new Ladder(Integer.parseInt(locations[0]), Integer.parseInt(locations[1])));
		}
		
		int users = sc.nextInt();
		ArrayList<String> usersList = new ArrayList<String>();
		while (users-- > 0) {
			String userName = sc.next();
			usersList.add(userName);
		}
		
		
		Board board = new Board(10, 10, snakeList, ladderList, usersList);
		PlayGame game = new PlayGame(board);
		game.start();
		
	}
}
