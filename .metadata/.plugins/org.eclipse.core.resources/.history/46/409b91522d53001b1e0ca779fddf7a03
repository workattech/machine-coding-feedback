package services;

import models.BoardEntity;
import models.PlayerEntity;

public class Player {
	PlayerEntity player;
	public Player(PlayerEntity player)
	{
		this.player=player;
	}
	public void play(BoardEntity board)
	{
		int diceThrow=board.dice.run(),oldPosition=board.positions.get(this),newPosition;
		newPosition=oldPosition+diceThrow;
		while(true)
		{
			if(board.ladders.containsKey(newPosition))
				newPosition=board.ladders.get(newPosition);
			else if(board.snakes.containsKey(newPosition))
				newPosition=board.snakes.get(newPosition);
			else
				break;
		}
		System.out.println(player.getName()+" rolled a "+diceThrow+" and moved from "+oldPosition+" to "+newPosition);
		board.positions.put(this, newPosition);
	}
}
