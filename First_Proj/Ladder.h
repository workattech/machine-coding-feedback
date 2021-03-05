/*
 * Ladder.h
 *
 *  Created on: 14-Jan-2021
 *      Author: sam
 */

#ifndef LADDER_H_
#define LADDER_H_
#include<iostream>
#include<string>
#include<bits/stdc++.h>
using namespace std;

class Ladder {
	int startpt, endpt;
public:
	Ladder(int s, int e);
	int getstart();
	int getend();
};

#endif /* LADDER_H_ */
