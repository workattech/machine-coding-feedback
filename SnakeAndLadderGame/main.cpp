//
//  main.cpp
//  SnakeAndLadderGame
//
//  Created by Srijani Sen on 25/01/21.
//  Copyright © 2021 Srijani Sen. All rights reserved.
//

#include <iostream>
#include "Player.hpp"
#include "Dice.hpp"
#include <queue>

int main(int argc, const char * argv[]) {
	// insert code here...
	int boardSize = 100;
	
	auto boardPtr = std::make_shared<Board>(boardSize);
	
	if(!boardPtr->isBoardValid())
		std::cout<<"Please enter a valid board size\n";
	else
		std::cout<<"Snake and ladder game starts\n";
	
	//Input Snake
	int snakes = 0;
	std::cout<<"Please input the snakes\n";
	std::cin>>snakes;
	while(snakes--)
	{
		int head, tail;
		std::cin>>head>>tail;
		boardPtr->addBoardComponent("Snake", head, tail, -1);
	}
	
	
	// Input ladder
	int ladder = 0;
	std::cout<<"Please input the ladders\n";
	std::cin>>ladder;
	while(ladder--)
	{
		int head, tail;
		std::cin>>head>>tail;
		boardPtr->addBoardComponent("Ladder", head, tail, 1);
	}
	
	std::cout<<"Please input the players\n";
	int numOfPlayers = 0;
	std::cin>>numOfPlayers;
	std::queue<std::unique_ptr<Player>> turnQueue;
	
	while(numOfPlayers--)
	{
		std::string name;
		std::cin>>name;
		turnQueue.push(std::make_unique<Player>(name, boardPtr));
	}
	
	std::cout<<"Game begins\n";
	//Initialise Dice
	int diceRange = 6;
	auto dicePtr = std::make_unique<Dice>(diceRange);
	
	//Starting the game
	while(1)
	{
		auto currPlayer = std::move(turnQueue.front());
		turnQueue.pop();
		
		int diceVal = dicePtr->rollDice();
		int initialPos = currPlayer->getCurrPosition();
		int newPos = currPlayer->setMove(diceVal);
		std::cout<<currPlayer->getName()<<" rolled a "<<diceVal<<" and moved from "<<initialPos<<" to "<<newPos<<std::endl;
		
		if(newPos == boardSize)
		{
			std::cout<<currPlayer->getName()<<" wins the  game\n";
			break;
		}
		turnQueue.push(std::move(currPlayer));
	}
	
	return 0;
}

