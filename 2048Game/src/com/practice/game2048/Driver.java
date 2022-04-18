package com.practice.game2048;

import java.util.*;

public class Driver {
	public static void main(String[] args) {
		BoardManager boardManager = new BoardManager(4, 2048, 2);
		boardManager.play();
	}
}
