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
		int diceThrow=board.getDice().run(),diceThrow2nd=0,diceThrow3rd=0,oldPosition=board.getPlayerPositions().get(this),newPosition;
		if(diceThrow==6)
		{
			diceThrow2nd=board.getDice().run();
			if(diceThrow2nd==6)
			{
				diceThrow3rd=board.getDice().run();
				if(diceThrow3rd==6)
				{
					diceThrow=0;
					diceThrow2nd=0;
					diceThrow3rd=0;
				}
			}
		}
		newPosition=oldPosition+diceThrow+diceThrow2nd+diceThrow3rd;
		if(diceThrow==6 && diceThrow2nd==6 && diceThrow3rd==6)
		{
			System.out.println(player.getName()+" rolled a 6-6-6 and the chance got cancelled.");
			return;
		}
		String diceValToDisplay = diceThrow3rd==0 ? (diceThrow2nd==0 ? diceThrow+"" : diceThrow+"-"+diceThrow2nd) : diceThrow+"-"+diceThrow2nd+"-"+diceThrow3rd;
		if(newPosition > board.getNumberOfCells())
		{
			System.out.println(player.getName()+" rolled a "+diceValToDisplay+" and stayed at the same position "+oldPosition);
			return;
		}
		while(true)
		{
			if(board.getLadders().containsKey(newPosition))
				newPosition=board.getLadders().get(newPosition);
			else if(board.getSnakes().containsKey(newPosition))
				newPosition=board.getSnakes().get(newPosition);
			else
				break;
		}
		System.out.println(player.getName()+" rolled a "+diceValToDisplay+" and moved from "+oldPosition+" to "+newPosition);
		board.getPlayerPositions().put(this, newPosition);
	}
}
