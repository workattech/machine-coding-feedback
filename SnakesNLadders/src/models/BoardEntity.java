package models;

import java.util.*;
import services.*;

public class BoardEntity {
	private int numberOfCells;
	private Map<Integer,Integer> snakes;
	private Map<Integer,Integer> ladders;
	private List<Player> players;
	private Dice dice;
	private Map<Player,Integer> positions;
	private Set<Player> playersFinishedPlaying;
	public BoardEntity(int numberOfCells,Dice dice,List<Snake> snakes,List<Ladder> ladders,List<Player> players)
	{
		int index;
		this.numberOfCells=numberOfCells;
		this.dice=dice;
		this.snakes=new HashMap<>();
		this.playersFinishedPlaying=new HashSet<>();
		for(index=0;index<snakes.size();index++)
			this.snakes.put(snakes.get(index).getStart(), snakes.get(index).getEnd());
		this.ladders=new HashMap<>();
		for(index=0;index<ladders.size();index++)
			this.ladders.put(ladders.get(index).getStart(), ladders.get(index).getEnd());
		this.players=players;
		positions=new HashMap<>();
		for(index=0;index<players.size();index++)
			positions.put(players.get(index), 0);
	}
	public int getNumberOfCells()
	{
		return numberOfCells;
	}
	public Map<Integer,Integer> getSnakes()
	{
		return snakes;
	}
	public Map<Integer,Integer> getLadders()
	{
		return ladders;
	}
	public List<Player> getPlayers()
	{
		return players;
	}
	public Dice getDice()
	{
		return dice;
	}
	public Map<Player,Integer> getPlayerPositions()
	{
		return positions;
	}
	public Set<Player> getPlayersFinishedPlaying()
	{
		return playersFinishedPlaying;
	}
}
