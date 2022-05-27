#include <iostream>
#include <iosfwd>
#include <iomanip>
#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <ctime>
#include <cmath>
#include <cassert>
#include <cctype>
#include <climits>
#include <vector>
#include <bitset>
#include <set>
#include <queue>
#include <stack>
#include <map>
#include <deque>
#include <string>
#include <list>
#include <iterator>
#include <sstream>
#include <complex>
#include <fstream>
#include <functional>
#include <numeric>
#include <utility>
#include <algorithm>
#include <assert.h>
#include <unordered_map>
#include "Person.h"
#include "Snake.h"
#include "Ladder.h"
using namespace std;

class Game
{
	vector<Snake> snakes;
	vector<Ladder> ladders;
	vector<Person> players;
	int numberOfSnakes, numberOfLadders, numberOfPlayers;

public:

	Game(int numSnakes, vector<Snake> snakesPos, int numLadders, vector<Ladder> laddersPos, int numPlayers, vector<Person> playersInfo)
	{
		snakes = snakesPos;
		ladders = laddersPos;
		players = playersInfo;
		numberOfSnakes = numSnakes;
		numberOfLadders = numLadders;
		numberOfPlayers = numPlayers;
	}

	int getDiceThrowValue()
	{
		return rand() % 6 + 1;
	}

	void startGame()
	{
		int diceValue, currentPlayerPosition, earlierPlayerPosition;

		if (numberOfPlayers == 0)
		{
			cout << "The game can't be started with zero players" << endl;
			return;
		}

		int currentPlayer = 0;  // first Player to be indexed at 0
		currentPlayerPosition = earlierPlayerPosition = players[currentPlayer].getPosition();
		int snakeBite = 0, ladderFound = 0;
		while(currentPlayerPosition != 100)
		{
			diceValue = getDiceThrowValue();
			if (currentPlayerPosition + diceValue > 100)
			{
				currentPlayer = (currentPlayer + 1) % numberOfPlayers;
				currentPlayerPosition = earlierPlayerPosition = players[currentPlayer].getPosition();
				continue;
			}
			else
			{

				currentPlayerPosition += diceValue;
				for (int i = 0; i < numberOfSnakes; i++)
				{
					if (snakes[i].getEndPosition() == currentPlayerPosition)
					{
						currentPlayerPosition = snakes[i].getStartPosition();
						snakeBite = 1;
						break;
					}
				}

				for (int i = 0; i < numberOfLadders; i++)
				{
					if (ladders[i].getStartPosition() == currentPlayerPosition)
					{
						currentPlayerPosition = ladders[i].getEndPosition();
						ladderFound = 1;
						break;
					}
				}
			}
			if (!snakeBite && !ladderFound)
				cout << players[currentPlayer].getName() + " rolled a " + to_string(diceValue) + " and moved from " + to_string(earlierPlayerPosition) + " to " + to_string(currentPlayerPosition) << endl;
			else if(snakeBite)
				cout << players[currentPlayer].getName() + " rolled a " + to_string(diceValue) + " and moved from " + to_string(earlierPlayerPosition) + " to " + to_string(currentPlayerPosition) << endl;
			else
				cout << players[currentPlayer].getName() + " rolled a " + to_string(diceValue) + " and moved from " + to_string(earlierPlayerPosition) + " to " + to_string(currentPlayerPosition) << endl;

			snakeBite = ladderFound = 0;

			players[currentPlayer].setPosition(currentPlayerPosition);
			
			if (currentPlayerPosition == 100)
			{	
				cout << players[currentPlayer].getName() + " wins the game" << endl;
				break;
			}
			currentPlayer = (currentPlayer + 1) % numberOfPlayers;
			currentPlayerPosition = earlierPlayerPosition = players[currentPlayer].getPosition();
		}
	}
};


int main()
{
	vector<Snake> snakesPos;
	vector<Ladder> laddersPos;
	vector<Person> playersInfo;
	int numSnakes, numLadders, numPlayers;
	cin >> numSnakes;
	int start, end;
	for (int i = 0; i < numSnakes; i++)
	{
		cin >> start >> end;
		snakesPos.push_back(Snake(start, end));
	}

	cin >> numLadders;
	for (int i = 0; i < numLadders; i++)
	{
		cin >> start >> end;
		laddersPos.push_back(Ladder(start, end));
	}

	cin >> numPlayers;
	string name;
	for (int i = 0; i < numPlayers; i++)
	{
		cin >> name;
		playersInfo.push_back(Person(i, name));
	}

	Game g = Game(numSnakes, snakesPos, numLadders, laddersPos, numPlayers, playersInfo);
	g.startGame();
	return 0;	
}