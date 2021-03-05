/*
 * Player.h
 *
 *  Created on: 14-Jan-2021
 *      Author: sam
 */

#ifndef PLAYER_H_
#define PLAYER_H_
#include<iostream>
#include<bits/stdc++.h>
#include<string>
using namespace std;

class Player {

	string name;
	string id;
public:
	Player(string n, string i);
	string getname();
	string getid();
};

#endif /* PLAYER_H_ */
