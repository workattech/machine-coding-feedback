package com.practice.tictactoe;

import java.util.*;

public class Driver {
	public static void main(String[] args) {
		BoardManager boardManager = new BoardManager(3);
		boardManager.play();
	}
}
