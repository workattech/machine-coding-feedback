// SnakesAndLadder.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include "Game.h"

int main()
{
	Game snakesAndLadders(100, { { 99, 1 },{ 98, 2 },{ 97, 3 } }, { { 1, 38 },{ 4, 14 },{ 9, 31 } });
	snakesAndLadders.AddPlayers({ "Gaurav", "Saurabh", "Ravi" });
	snakesAndLadders.StartGame();
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
