/*
 * Snake.h
 *
 *  Created on: 14-Jan-2021
 *      Author: sam
 */

#ifndef SNAKE_H_
#define SNAKE_H_
#include<iostream>
#include<string>
#include<bits/stdc++.h>
using namespace std;

class Snake {
	int startpt, endpt;
public:
	Snake(int s, int e);
	int getstart();
	int getend();

};

#endif /* SNAKE_H_ */
