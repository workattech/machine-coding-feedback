/*
 * Service.h
 *
 *  Created on: 14-Jan-2021
 *      Author: sam
 */

#ifndef SERVICE_H_
#define SERVICE_H_
#include "Snake.h"
#include "Ladder.h"
#include "Player.h"
#include "SnakeandLadderboard.h"
#include<bits/stdc++.h>
#include<iostream>
#include<string>
#include<random>
#include<time.h>
using namespace std;

class Service {

	const size_t default_size=100;
	SnakeandLadderboard snlb;
	queue<Player> player;

public:
	Service();

	int DiceRoll();
	void setPlayer(queue<Player> p);
	void setSnake(vector<Snake> sna);
	void setLadder(vector<Ladder> ladd);

	int move(int newpos);
	int playermove(Player p, int newpos, int oldpos);
	bool didplayerwin(int pos);
	bool isgameover();
	void rungame();

};

#endif /* SERVICE_H_ */
