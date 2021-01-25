//
//  Dice.hpp
//  SnakeAndLadderGame
//
//  Created by Srijani Sen on 25/01/21.
//  Copyright © 2021 Srijani Sen. All rights reserved.
//

#ifndef Dice_hpp
#define Dice_hpp

#include <stdio.h>


class Dice
{
	int diceRange;
public:
	Dice(int x);
	int rollDice();
};
#endif /* Dice_hpp */
