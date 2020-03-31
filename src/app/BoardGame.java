package app;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * BoardGame
 */
public class BoardGame {
    private int snakes[] = new int[10001];
    private int ladders[] = new int[10001];
    private Map<String,Integer> inGamePlayerPositions = new HashMap<String,Integer>();

    public void prepare(){
        Scanner sc = new Scanner(System.in);
        int numberOfSnakes = sc.nextInt();
        int start,end;
        System.out.println("Input snakes");
        for(int i=0;i<numberOfSnakes;i++)
        {
            start = sc.nextInt();
            end = sc.nextInt();
            snakes[start]=end;
        }
        System.out.println("Input laders");
        int numberOfLadders = sc.nextInt();
        for(int i=0;i<numberOfLadders;i++)
        {
            start = sc.nextInt();
            end = sc.nextInt();
            ladders[start]=end;
        }
        System.out.println("Input players");
        int numberOfPlayers = sc.nextInt();
        for(int i=0;i<numberOfPlayers;i++)
        {
            String playerName = sc.next();
            inGamePlayerPositions.put(playerName, 0);
        }
        sc.close();
    }

    public int rollDice(){
        return (int) (Math.random()*6+1);
    }

	public void play() {
        while(true){
            for (Map.Entry<String,Integer> player : inGamePlayerPositions.entrySet()){
                int currMove = rollDice();
                int finalPosition;
                List<Integer> moves = new LinkedList<>();
                if(currMove==6){
                    // accumulate moves until not 6
                    moves = rolledDiceStatus6(player.getKey(),currMove);
                }else{
                    moves.add(currMove);
                }
                // evaluate accummulated moves;
                finalPosition = evaluateMoves(player.getKey(),moves);
                if(updatePlayerPosition(player.getKey(),finalPosition)==1)
                {
                    System.out.println(player.getKey()+" wins the game");
                    return;
                }
            }
        }
	}

    // evaluating every move
    private int evaluateMoves(String player,List<Integer> moves) {
        int finalPosition = inGamePlayerPositions.get(player);
        if(moves.size()==0){
            System.out.println(player+" rolled 3 consecutive 6s and stays at the same position");
            return finalPosition;
        }
        for(int currMove:moves){
            if(finalPosition+currMove>100){
                System.out.print(player+" rolled "+currMove+" and moved from "+finalPosition+" to "+finalPosition);
                continue;
            }
            System.out.print(player+" rolled "+currMove+" and moved from "+finalPosition+" to ");
            if(snakes[finalPosition+currMove]!=0){
                finalPosition = snakes[finalPosition+currMove];
            }else if(ladders[finalPosition+currMove]!=0){
                finalPosition = ladders[finalPosition+currMove];
            }else{
                finalPosition+=currMove;
            }
            System.out.println(finalPosition);
        }
        return finalPosition;
    }

    // special case of rolling  a dice and getting 6
    private List<Integer> rolledDiceStatus6(String player,int currMove) {
        int count=1;
        List<Integer> moves = new LinkedList<>();
        moves.add(currMove);
        int move;
        while(count<3){
            move = rollDice();
            if(move==6){
                count++;
                moves.add(move);
            }else {
                moves.add(move);
                break;
            }
        }
        if(count>=3){
            return new LinkedList<Integer>();
        }
        return moves;
    }
    // updating the database
    private int updatePlayerPosition(String player, int finalPosition) {
        if(finalPosition==100)
        {
            return 1;
        }
        inGamePlayerPositions.put(player, finalPosition);
        return 0;
    }
}