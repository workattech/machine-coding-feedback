/*
 * SnakeandLadderboard.h
 *
 *  Created on: 14-Jan-2021
 *      Author: sam
 */

#ifndef SNAKEANDLADDERBOARD_H_
#define SNAKEANDLADDERBOARD_H_
#include "Snake.h"
#include "Ladder.h"
#include "Player.h"
#include<bits/stdc++.h>
#include<iostream>
#include<string>
using namespace std;

class SnakeandLadderboard {
	int size;
	vector<Snake> sn;
	vector<Ladder> ld;
	unordered_map<string, int> playerpeices;
public:
	SnakeandLadderboard();
	SnakeandLadderboard(size_t s);
	void setsize(size_t s);
	void setsnakes(vector<Snake> s);
	void setladders(vector<Ladder> l);
	void setplayerpeices(unordered_map<string, int> pp);
	vector<Snake> getsnakes();
	vector<Ladder> getladders();
	unordered_map<string, int> getplayerpeices();
	int getsize();
};

#endif /* SNAKEANDLADDERBOARD_H_ */
