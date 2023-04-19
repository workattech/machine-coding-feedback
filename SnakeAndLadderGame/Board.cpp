//
//  Board.cpp
//  SnakeAndLadderGame
//
//  Created by Srijani Sen on 25/01/21.
//  Copyright © 2021 Srijani Sen. All rights reserved.
//

#include "Board.hpp"
#define MAX_BOARD_SIZE 1000 // We won't allocate any board size bigger than this (Assumption)


Board::Board(int x)
{
	if(x < 0 || x > MAX_BOARD_SIZE)
	{
		isValid = false;
		return;
	}
	
	board.clear();
	board.resize(x+1);
	boardRange = x;
	isValid = true;

}

int Board::getBoardRange()
{
	if(isValid)
		return boardRange;
	
	return -1;
}

bool Board::isBoardValid()
{
	return isValid;
}

void Board::addBoardComponent(std::string name, int head, int tail, int direction)
{
	pointToBoardMap[head] = std::make_unique<BoardComponent>(name, head, tail, direction);
}

int Board::getNewPos(int currPos)
{
	if(pointToBoardMap.find(currPos) == pointToBoardMap.end())
		return currPos;
	
	auto& boardComponentPtr = pointToBoardMap[currPos];
	return boardComponentPtr->getTail();
}

BoardComponent::BoardComponent(std::string name, int head, int tail, int direction)
:
name(name),
head(head),
tail(head),
direction(direction)
{
}

std::string BoardComponent::getName()
{
	return name;
}

int BoardComponent::getHead()
{
	return head;
}

int BoardComponent::getTail()
{
	return tail;
}

int BoardComponent::getDirection()
{
	return direction;
}
