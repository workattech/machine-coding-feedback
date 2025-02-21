#include <iostream>
#include <vector>
#include <unordered_map>
#include "Game.h"

using namespace std;

Game::Game(int boardSize, vector<pair<int, int>> snakes, vector<pair<int, int>> ladders) 
    : board(boardSize, snakes, ladders) {}

void Game::AddPlayers(vector<string> playerNames) {
	for (int i = 0; i < playerNames.size(); i++) {
		this->players[i] = make_shared<Player>(playerNames[i], i);
	}
}

int Game::RollDice() {
	return rand() % 6 + 1;
}

bool Game::MakeMoveForPlayer(int playerId) {
	int DiceRoll = RollDice();
	int currPos = players[playerId]->getPosition();
	int newPos = board.makeMove(DiceRoll, currPos);

	players[playerId]->updatePosition(newPos);
	bool haveWon = false;

	cout << players[playerId]->getName() << " rolled a " << DiceRoll << " and moved from " << currPos << " to " << newPos << endl;

	if (board.isWinningPosition(newPos)) {
		DisplayWinner(playerId);
		haveWon = true;
	}

	return haveWon;
}

void Game::DisplayWinner(int playerId) {
	cout << players[playerId]->getName() << " wins the game!" << endl;
}

void Game::StartGame() {
	while (true) {
		for (auto player : players) {
			if (MakeMoveForPlayer(player.first))
				return;
		}
	}
}
