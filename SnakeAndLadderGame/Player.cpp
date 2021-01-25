//
//  Player.cpp
//  SnakeAndLadderGame
//
//  Created by Srijani Sen on 25/01/21.
//  Copyright © 2021 Srijani Sen. All rights reserved.
//

#include "Player.hpp"

Player::Player(std::string name, std::shared_ptr<Board>& boardPtr)
:
playerName(name),
currPosition(0),
mpBoardPtr(boardPtr)
{
}

bool Player::isPlayerTurn()
{
	return isTurn;
}

std::string Player::getName()
{
	return playerName;
}

int Player::setMove(int x)
{
	if(x + currPosition <= mpBoardPtr->getBoardRange())
	{
		currPosition += x;
		currPosition = mpBoardPtr->getNewPos(currPosition);
	}
	
	return currPosition;
}

int Player::getCurrPosition()
{
	return currPosition;
}

