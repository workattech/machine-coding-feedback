/*
 * SnakeandLadderboard.cpp
 *
 *  Created on: 14-Jan-2021
 *      Author: sam
 */

#include "SnakeandLadderboard.h"

SnakeandLadderboard::SnakeandLadderboard(){
	size=0;
}
SnakeandLadderboard::SnakeandLadderboard(size_t s) {
	// TODO Auto-generated constructor stub
	size = s;
}

void SnakeandLadderboard::setsize(size_t s){
	size = s;
}

void SnakeandLadderboard::setsnakes(vector<Snake> snak){
	sn = snak;
}
void SnakeandLadderboard::setladders(vector<Ladder> lad){
	ld = lad;
}
void SnakeandLadderboard::setplayerpeices(unordered_map<string, int> pp){

	playerpeices = pp;
}
vector<Snake> SnakeandLadderboard::getsnakes(){
	return sn;
}
vector<Ladder> SnakeandLadderboard::getladders(){
	return ld;
}
unordered_map<string, int> SnakeandLadderboard::getplayerpeices(){
	return playerpeices;
}
int SnakeandLadderboard::getsize(){
	return size;
}

