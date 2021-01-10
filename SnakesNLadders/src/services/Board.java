package services;

import models.BoardEntity;

public class Board {
	BoardEntity board;
	public Board(BoardEntity board)
	{
		this.board=board;
	}
	public void play()
	{
		int index=0,rank=1;
		while(true)
		{
			if(board.getPlayersFinishedPlaying().contains(board.getPlayers().get(index)))
			{
				index++;
				if(index>=board.getPlayers().size())
					index=0;
				continue;
			}
			if(rank==board.getPlayers().size())
			{
				System.out.println(board.getPlayers().get(index).player.getName()+" came last.");
				return;
			}
			board.getPlayers().get(index).play(board);
			if(board.getPlayerPositions().get(board.getPlayers().get(index))==board.getNumberOfCells())
			{
				System.out.println(board.getPlayers().get(index).player.getName()+" came rank "+rank);
				rank++;
				board.getPlayersFinishedPlaying().add(board.getPlayers().get(index));
			}
			index++;
			if(index>=board.getPlayers().size())
				index=0;
		}
	}
}
