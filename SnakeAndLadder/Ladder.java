import java.util.*;
import java.lang.*;
import java.io.*;
import Board.java;
import Ladder.java;
import Snake.java;
import Player.java;



class Ladder{
	
	private int startingPosition;
	private int endingPosition;
	
	public Ladder(int startingPosition, int endingPosition){
		this.startingPosition = startingPosition;
		this.endingPosition = endingPosition;
	}

	public int getLadderStartingPosition(){
		return this.startingPosition;
	}
	
	public int getLadderEndingPosition(){
		return this.endingPosition;
	}
}