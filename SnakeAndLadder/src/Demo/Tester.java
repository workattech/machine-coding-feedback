package Demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		int numberOfPlayer = 0;
		ArrayList<String> names = new ArrayList<>();
		System.out.println("enter number of players:");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			numberOfPlayer = Integer.valueOf(input.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Enter valid number");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < numberOfPlayer; i++) {
			System.out.println("enter player name "+(i+1)+":");
			String name;
			try {
				name = input.readLine();
				names.add(name);
			} catch (IOException e) {
				System.out.println("enter valid name.");
				e.printStackTrace();
			}
		}
		
		SnakeAndLadder game = new SnakeAndLadder(names);
		game.start();
	}

}
