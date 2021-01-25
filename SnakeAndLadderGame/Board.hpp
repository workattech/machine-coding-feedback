//
//  Board.hpp
//  SnakeAndLadderGame
//
//  Created by Srijani Sen on 25/01/21.
//  Copyright © 2021 Srijani Sen. All rights reserved.
//

#ifndef Board_hpp
#define Board_hpp

#include <stdio.h>
#include <vector>
#include <string>
#include <unordered_map>
#include "Player.hpp"


class BoardComponent;

class Board
{
	int boardRange;
	std::vector<int> board;
	bool isValid;
	std::unordered_map<int, std::unique_ptr<BoardComponent>> pointToBoardMap;
	
public:
	Board(int x);
	int getBoardRange();
	bool isBoardValid();
	void addBoardComponent(std::string name, int head, int tail, int direction);
	int getNewPos(int pos);
};

class BoardComponent
{
	std::string name;
	int head;
	int tail;
	int direction;
	
public:
	
	BoardComponent(std::string name, int head, int tail, int direction);
	std::string getName();
	int getHead();
	int getTail();
	int getDirection();
};

#endif /* Board_hpp */
