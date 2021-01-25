//
//  Player.hpp
//  SnakeAndLadderGame
//
//  Created by Srijani Sen on 25/01/21.
//  Copyright © 2021 Srijani Sen. All rights reserved.
//

#ifndef Player_hpp
#define Player_hpp

#include <stdio.h>
#include <string>
#include "Board.hpp"


class Board;

class Player
{
	std::string playerName;
	bool isTurn;
	int move;
	int currPosition;
	std::shared_ptr<Board> mpBoardPtr;
	
public:
	Player(std::string name, std::shared_ptr<Board>& boardPtr);
	bool isPlayerTurn();
	int setMove(int move);
	int getCurrPosition();
	std::string getName();
	
	
};

#endif /* Player_hpp */
