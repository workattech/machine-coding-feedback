package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import model.Board;
import model.JumpEntity;
import model.Player;
import util.Constants;

public class SnakeLadderService {
	
	public static void startGame(Board gameBoard,List<Player> playerList,List<JumpEntity> snakeList,List<JumpEntity> ladderList) {
		Map<Integer,JumpEntity> jumpEntityMap=createJumpMap(snakeList, ladderList);
		int totalPlayers=playerList.size();
		while(playerList.size()!=0&&playerList.size()!=totalPlayers-1) {
			for(int playerIterator=0;playerIterator<playerList.size();playerIterator++) {
				takeTurn(playerIterator, jumpEntityMap, gameBoard, playerList);
			}
		}
	}
	
	private static Map<Integer,JumpEntity> createJumpMap(List<JumpEntity> snakeList,List<JumpEntity> ladderList){
		Map<Integer,JumpEntity> jumpEntityMap=new HashMap<Integer, JumpEntity>();
		for(JumpEntity jumpEntity:snakeList) {
			jumpEntityMap.put(jumpEntity.getStart(),jumpEntity);
		}
		for(JumpEntity jumpEntity:ladderList) {
			jumpEntityMap.put(jumpEntity.getStart(),jumpEntity);
		}
		return jumpEntityMap;
	}
	
	private static int diceRoll(int diceCount) {
		int minNumber=diceCount*Constants.DICE_START;
		int maxNumber=diceCount*Constants.DICE_END;
		return ThreadLocalRandom.current().nextInt(minNumber,maxNumber+1);
	}
	
	private static void takeTurn(int playerIterator,Map<Integer,JumpEntity> jumpMap,Board gameBoard,List<Player> playerList) {
		int diceNumber=diceRoll(gameBoard.getDiceCount());
		Player currentPlayer=playerList.get(playerIterator);
		int repeatTurnNumber=0;
		int newPosition=0;
		int prevNewPosition=currentPlayer.getPosition();
		do {
			newPosition=getNewPosition(currentPlayer, diceNumber, jumpMap,gameBoard);
			if(newPosition>100) {
				newPosition=prevNewPosition;
				break;
			}
			else if(newPosition==100){
				break;
			}
			if(gameBoard.isRepeatTurns()&&++repeatTurnNumber==gameBoard.getMaxRepeat()) {
				newPosition=currentPlayer.getPosition();
				break;
			}
			prevNewPosition=newPosition;
		}
		while(gameBoard.isRepeatTurns()&&diceNumber==gameBoard.getRepeatNumber());
		System.out.println(currentPlayer.name+" rolled a  "+diceNumber+" and moved "
				+ "from "+currentPlayer.position+" to "+newPosition);
		if(newPosition==100){
			playerList.remove(playerIterator);
			System.out.println(currentPlayer.name+" has reached the end");
		}
		currentPlayer.position=newPosition;
		
	}
	
	private static int getNewPosition(Player currentPlayer,int diceNumber,Map<Integer,JumpEntity> jumpMap,Board gameBoard) {
		int newPosition=currentPlayer.position+diceNumber;
		while(jumpMap.containsKey(newPosition)) {
			newPosition=jumpMap.get(newPosition).getEnd();
		}
		return newPosition;
	}

}


