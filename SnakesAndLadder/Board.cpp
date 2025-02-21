#include "Board.h"

Board::Board(int size, vector<pair<int, int>> snakes, vector<pair<int, int>> ladders) {
	this->winningPosition = size;
	for (auto snake : snakes) {
		this->snakes[snake.first] = snake.second;
	}
	for (auto ladder : ladders) {
		this->ladders[ladder.first] = ladder.second;
	}
}

int Board::makeMove(int diceRoll, int position) {
	int newPosition = position + diceRoll;
	if (newPosition > winningPosition) {
		return position;
	}
	if (snakes.find(newPosition) != snakes.end()) {
		newPosition = snakes[newPosition];
		makeMove(0, newPosition);
	}
	else if (ladders.find(newPosition) != ladders.end()) {
		newPosition = ladders[newPosition];
		makeMove(0, newPosition);
	}
	return newPosition;
}

bool Board::isWinningPosition(int position) {
	return position == winningPosition;
}