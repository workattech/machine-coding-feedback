package driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Board;
import model.JumpEntity;
import model.Player;
import services.SnakeLadderService;
import util.Constants;

public class SnakeLadderDriver {

	private final static Logger driverLogger = Logger.getLogger(SnakeLadderDriver.class.getName());

	public static void main(String[] args) throws IOException {
		String inputFilePath = getInputFileLocation();
		Scanner inputScanner = new Scanner(new FileInputStream(inputFilePath));
		int snakesCount = inputScanner.nextInt();
		List<JumpEntity> snakeList = createJumpEntityList(inputScanner, snakesCount);
		int ladderCount = inputScanner.nextInt();
		List<JumpEntity> ladderList = createJumpEntityList(inputScanner, ladderCount);
		int playerCount = inputScanner.nextInt();
		inputScanner.nextLine();
		int x;
		List<Player> playerList = createPlayerList(inputScanner, playerCount);
		Board gameBoard;
		if (inputScanner.hasNextInt()) {
			gameBoard = createUserInputBoard(inputScanner);
		} else {
			gameBoard = createDefaultBoard();
		}
		SnakeLadderService.startGame(gameBoard, playerList, snakeList, ladderList);
	}

	private static Board createDefaultBoard() {
		Board board = new Board();
		board.setLength(Constants.DEFAULT_BOARD_LENGTH);
		board.setWidth(Constants.DEFAULT_BOARD_WIDTH);
		board.setStartPosition(0);
		board.setWinningPosition(board.getLength() * board.getWidth());
		board.setDiceCount(1);
		board.setRepeatTurns(false);

		return board;
	}

	private static String getInputFileLocation() throws IOException {
		try {
			InputStream appPropertiesInput = new FileInputStream(
					"/Users/aaishsindwani/Desktop/machine coding prac/mock-machine-coding-1/SnakeLadderApplication/resources/application.properties");
			Properties appProperties = new Properties();
			appProperties.load(appPropertiesInput);
			return appProperties.getProperty("INPUT_FILE_PATH");
		} catch (IOException e) {
			driverLogger.log(Level.SEVERE, "Error while loading Application properties");
			e.printStackTrace();
			throw new IOException("Error while loading Application properties");
		}
	}

	private static List<JumpEntity> createJumpEntityList(Scanner inputScanner, int count) {
		List<JumpEntity> jumpEntityList = new ArrayList<JumpEntity>();
		for (int iterator = 0; iterator < count; iterator++) {
			JumpEntity jumpEntity = new JumpEntity();
			jumpEntity.setStart(inputScanner.nextInt());
			jumpEntity.setEnd(inputScanner.nextInt());
			jumpEntityList.add(jumpEntity);
		}
		return jumpEntityList;

	}

	private static List<Player> createPlayerList(Scanner inputScanner, int playerCount) {
		List<Player> playerList = new ArrayList<Player>();
		for (int iterator = 0; iterator < playerCount; iterator++) {
			Player player = new Player();
			player.setName(inputScanner.nextLine());
			playerList.add(player);
		}
		return playerList;
	}

	private static Board createUserInputBoard(Scanner inputScanner) {
		Board board = new Board();
		board.setLength(inputScanner.nextInt());
		board.setWidth(inputScanner.nextInt());
		board.setStartPosition(0);
		board.setWinningPosition(board.getLength() * board.getWidth());
		board.setDiceCount(inputScanner.nextInt());
		inputScanner.nextLine();
		String repeatTurns = inputScanner.nextLine();
		{
			if (repeatTurns.equalsIgnoreCase(Constants.TRUE)) {
				board.setRepeatTurns(true);
				board.setRepeatNumber(Constants.DICE_END * board.getDiceCount());
				board.setMaxRepeat(3);
			}
		}
		return board;

	}

}
