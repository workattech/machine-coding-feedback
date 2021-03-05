/*
 * Player.cpp
 *
 *  Created on: 14-Jan-2021
 *      Author: sam
 */

#include "Player.h"

Player::Player(string n, string i) {
	// TODO Auto-generated constructor stub
	name = n;
	id = i;
}

string Player::getname(){
	return name;
}

string Player::getid(){
	return id;
}

