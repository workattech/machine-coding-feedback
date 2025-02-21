#pragma once
#include "Player.h"
#include "Board.h"

using namespace std;

class Game
{
private:
	unordered_map<int, shared_ptr<Player>> players;
	Board board;
public:
	Game(int size, vector<pair<int,int>> snakes, vector<pair<int, int>> ladders);

	int RollDice();
	bool MakeMoveForPlayer(int playerId);
	void AddPlayers(vector<string> playerNames);
	void StartGame();
	void DisplayWinner(int playerId);

};