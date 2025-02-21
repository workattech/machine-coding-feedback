#pragma once
#include <vector>
#include <unordered_map>

using namespace std;

class Board
{
private:
	int winningPosition;
	unordered_map<int, int> snakes;
	unordered_map<int, int> ladders;
public:
	Board(int size, vector<pair<int,int>> snakes, vector<pair<int,int>> ladders);
	int makeMove(int diceRoll, int position);
	bool isWinningPosition(int position);
	
};

