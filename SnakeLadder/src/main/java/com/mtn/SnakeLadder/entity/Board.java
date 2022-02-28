package com.mtn.SnakeLadder.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;

@Getter
public class Board {

	private String id;
	private List<List<CellPosition>> positions;
	
	public Board(String id) {
		this.id = id;
		initialize();
	}

	private void initialize() {
		if(positions == null) {
			positions = new ArrayList<>();
		}
		
		int currentPosition = 1;
		for(int i=0; i<10; i++) {
			List<CellPosition> cellPositionList = new ArrayList<>();
			for(int j=0; j<10; j++) {
				cellPositionList.add(new CellPosition(currentPosition));
				currentPosition++;
			}
			if(i%2==1) {
				Collections.reverse(cellPositionList);
			}
			positions.add(cellPositionList);
		}
	}
}
