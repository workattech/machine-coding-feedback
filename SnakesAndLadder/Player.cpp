#include "Player.h"
#include <iostream>

using namespace std;

Player::Player(string name, int id) : name(name), id(id) {
	position = 0;
}

int Player::getPosition() {
	return position;
}

void Player::updatePosition(int position) {
	this->position = position;
}

string Player::getName() {
	return name;
}