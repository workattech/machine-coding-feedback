package com.mtn.SnakeLadder.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class BaseEntity {
	
	private String id;
	private CellPosition start;
	private CellPosition end;
	
}
