//
//  Dice.cpp
//  SnakeAndLadderGame
//
//  Created by Srijani Sen on 25/01/21.
//  Copyright © 2021 Srijani Sen. All rights reserved.
//

#include "Dice.hpp"
#include <time.h>
#include <stdlib.h>

Dice::Dice(int range)
:
diceRange(range)
{
	srand((unsigned)time(0));
}

int Dice::rollDice()
{
	int val = rand() % diceRange;
	return val+1;
}

