import java.util.*;
import java.lang.*;
import java.io.*;

// Please make sure not to delete the WorkAtTech class
// You can create additional non-public classes as well
// But the main method should be in the WorkAtTech class
class WorkAtTech
{
	static final HashMap<Integer, Integer> snakes = new HashMap<>();
	static final HashMap<Integer, Integer> ladder = new HashMap<>();
	public static int chance = -1;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int noSnakes = in.nextInt();
		
		
		for(int i = 0;i < noSnakes; i++) {
			snakes.put(in.nextInt(),in.nextInt());
		}
		
		int noLadders = in.nextInt();
		
		for(int i = 0; i < noLadders; i++)
			ladder.put(in.nextInt(), in.nextInt());
		
		//System.out.println("How many players want to play ?");
		int noOfPlayer = in.nextInt();
		in.nextLine();
		Players[] obj = new Players[noOfPlayer];
		
		//System.out.println("Enter Name of each player : ");
		for(int i = 0;i < noOfPlayer; i++) {
	//		System.out.print("Player " + i+1);
			String n = in.nextLine();
			obj[i] = new Players(n, 0, 0);
		}
		
		do {
			chance++;
			int val = rollDice();
			
			if(chance >= noOfPlayer)
				chance = chance % noOfPlayer;
			
			obj[chance].finalPosition = obj[chance].initialPosition + val;
			if(obj[chance].finalPosition > 100)
				continue;
			
			boolean check = true;
			
			while(check) {
				if(checkSnake(obj, chance))
				   obj[chance].finalPosition = snakes.get(obj[chance].finalPosition);
				else if(checkLadder(obj, chance))
				   obj[chance].finalPosition = ladder.get(obj[chance].finalPosition);
				else
					check = false;
			}
			
		//	if(ladder.containsKey(obj[chance].finalPosition))
			//	obj[chance].finalPosition = ladder.get(obj[chance].finalPosition);
			
			System.out.println(obj[chance].name + " rolled a " + val+ " and moved from " + obj[chance].initialPosition+ " to "+obj[chance].finalPosition);
			//if(obj[chance].isWinning())
			//	break;
			obj[chance].initialPosition = obj[chance].finalPosition;
			
		} while(!obj[chance].isWinning());
		
		if(obj[chance].isWinning())
			System.out.println(obj[chance].name +  " wins the game");
		
		return;
		// your code goes here
	}
/*	public boolean anyoneWins() {
		for(int i = 0;i < obj.length; i++)
			if(obj[i].finalPosition == 100) {
				System.out.println(obj[i] + "wins the game");
				return true;
			}
		return false;
	}
	*/
	public static int rollDice() {
		Random rand = new Random();
		return rand.nextInt(6) + 1;
	}
	
	public static boolean checkSnake(Players[] obj, int chance) {
		if(snakes.containsKey(obj[chance].finalPosition))
			return true;
		return false;
	}
	
	public static boolean checkLadder(Players[] obj, int chance) {
		if(ladder.containsKey(obj[chance].finalPosition))
			return true;
		return false;
	}
}

class Players {
	public int initialPosition;
	public int finalPosition;
	public String name;
	
	public Players(String name, int initialPosition,int finalPosition) {
		this.initialPosition = initialPosition;
		this.finalPosition = finalPosition;
		this.name = name;
	}
	
	public boolean isWinning() {
		if(finalPosition == 100)
			return true;
		else
			return false;
	}
}